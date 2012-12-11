package org.wmichina.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.jdbc.SelectBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.wmichina.crm.entity.SysRight;
import org.wmichina.crm.entity.SysRole;
import org.wmichina.crm.entity.SysRoleRight;
import org.wmichina.crm.entity.SysUser;
import org.wmichina.crm.entity.SysUserRoles;
import org.wmichina.crm.entity.example.SysUserExample;
import org.wmichina.crm.entity.example.SysUserRolesExample;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.mapper.SysRoleRightMapper;
import org.wmichina.crm.mapper.SysUserMapper;
import org.wmichina.crm.mapper.SysUserRolesMapper;
import org.wmichina.crm.service.SysRoleUserService;

@Repository(value="sysRoleUserService")
@Transactional
public class SysRoleUserServiceImpl implements SysRoleUserService {

	@Resource(name="sysRoleRightMapper")
	private SysRoleRightMapper sysRoleRightMapper;
	@Resource(name="sysUserMapper")
	private SysUserMapper sysUserMapper;
	@Resource(name="sysUserRolesMapper")
	private SysUserRolesMapper sysUserRolesMapper;

	/**
	 * Operations on SysRight 
	 */

	@Override
	public List<SysRight> findRights() {
		String querySQL = "select * from sys_right";
		return this.sysRoleRightMapper.loadRights(querySQL);
	}
	@Override
	public List<SysRight> findRightsByRoleId(int roleId) {
		String querySQL = "select r.* from sys_right r, sys_role_rights rr where rr.right_id = r.right_id and rr.role_id=" + roleId;
		return this.sysRoleRightMapper.loadRights(querySQL);
	}
	@Override
	public List<SysRight> findRightsByUserId(int userId) {
		String querySQL = "select r.* from sys_right r, sys_role_rights rr, sys_user_roles ur  where rr.right_id = r.right_id and rr.role_id=ur.role_id and ur.user_id=" + userId;
		return this.sysRoleRightMapper.loadRights(querySQL);
	}

	@Override
	public ResultPageBuilder<SysRight> findRightsByPage(SysRight right, int currentPage) {
		SelectBuilder.BEGIN();
		SelectBuilder.SELECT("count(0)");
		SelectBuilder.FROM("sys_right");
		SelectBuilder.WHERE("1=1");
		//
		int allRows = this.sysRoleRightMapper.count(SelectBuilder.SQL());
		//
		ResultPageBuilder<SysRight> pageBuilder = new ResultPageBuilder<SysRight>(allRows, EntityConstants.PAGE_SIZE, currentPage);
		//
		SelectBuilder.BEGIN();
		SelectBuilder.SELECT("*");
		SelectBuilder.FROM("sys_right");
		SelectBuilder.WHERE("1=1");
		String querySQL = SelectBuilder.SQL() + " limit " + pageBuilder.getStart() +"," + pageBuilder.getEnd();
		List<SysRight> rights = this.sysRoleRightMapper.loadRights(querySQL);
		//
		pageBuilder.setResultSet(rights);
		
		return pageBuilder;
	}

	/**
	 * Operations on SysRole 
	 */

	@Override
	public List<SysRole> findRoles() {
		List<SysRole> roles = this.sysRoleRightMapper.loadRoles("select * from sys_role");
		//
		if(roles!=null){
			for(SysRole entry : roles){
				entry.setRoleRights(this.findRightsByRoleId(entry.getRoleId()));
			}
		}
		return roles;
	}

	@Override
	public List<SysRole> findRolesByUserId(int userId) {
		List<SysRole> roles = this.sysRoleRightMapper.loadRoles("select r.* from sys_role r, sys_user_roles ur where ur.role_id=r.role_id and ur.user_id="+userId);
		//
		if(roles!=null){
			for(SysRole entry : roles){
				entry.setRoleRights(this.findRightsByRoleId(entry.getRoleId()));
			}
		}
		return roles;
	}
	
	@Override
	public ResultPageBuilder<SysRole> findRolesByPage(SysRole role, int currentPage) {
		SelectBuilder.BEGIN();
		SelectBuilder.SELECT("count(0)");
		SelectBuilder.FROM("sys_role");
		SelectBuilder.WHERE("1=1");
		//
		int allRows = this.sysRoleRightMapper.count(SelectBuilder.SQL());
		//
		ResultPageBuilder<SysRole> pageBuilder = new ResultPageBuilder<SysRole>(allRows, EntityConstants.PAGE_SIZE, currentPage);
		//
		SelectBuilder.BEGIN();
		SelectBuilder.SELECT("*");
		SelectBuilder.FROM("sys_role");
		SelectBuilder.WHERE("1=1");
		String querySQL = SelectBuilder.SQL() + " limit " + pageBuilder.getStart() +"," + pageBuilder.getEnd();
		List<SysRole> roles = this.sysRoleRightMapper.loadRoles(querySQL);
		//
		if(roles!=null){
			for(SysRole entry : roles){
				entry.setRoleRights(this.findRightsByRoleId(entry.getRoleId()));
			}
		}
		
		pageBuilder.setResultSet(roles);
		
		return pageBuilder;
	}
	
	@Override
	public void createRole(SysRole role) {
		//#1. insert into sys_role
		this.sysRoleRightMapper.insertOneRole(role);
		
		//#2. batch insert sys_role_rights
		List<SysRoleRight> roleRights = new ArrayList<SysRoleRight>();
		for(String rightCode:role.getRoleRightCodes()){
			
			SysRoleRight roleRight = new SysRoleRight();
			roleRight.setRoleId(role.getRoleId());
			roleRight.setRightId(Integer.parseInt(rightCode));
			
			roleRights.add(roleRight);
		}
		this.sysRoleRightMapper.batchInsertRoleRights(roleRights);
	}

	@Override
	public void updateRole(SysRole role) {
		//#1. update sys_role
		this.sysRoleRightMapper.updateRole(role);
		
		//#2. delete sys_role_rights
		this.sysRoleRightMapper.deleteRoleRights(role.getRoleId());
		
		//#3. batch insert sys_role_rights
		List<SysRoleRight> roleRights = new ArrayList<SysRoleRight>();
		for(String roleId:role.getRoleRightCodes()){
			SysRoleRight roleRight = new SysRoleRight();
			roleRight.setRoleId(role.getRoleId());
			roleRight.setRightId(Integer.parseInt(roleId));
			
			roleRights.add(roleRight);
		}
		this.sysRoleRightMapper.batchInsertRoleRights(roleRights);
	}

	@Override
	public void auditRole(SysRole role) {
		this.sysRoleRightMapper.updateRole(role);
	}
	
	@Override
	public SysRole selectOneRole(int roleId) {
		SysRole sysRole = this.sysRoleRightMapper.selectOneRole(roleId);
		if(sysRole!=null){
			sysRole.setRoleRights(this.findRightsByRoleId(sysRole.getRoleId()));
		}
		return sysRole;
	}
	
	@Override
	public SysRole selectByRoleName(String roleName) {
		SysRole sysRole = this.sysRoleRightMapper.selectByRoleName(roleName);
		if(sysRole!=null){
			sysRole.setRoleRights(this.findRightsByRoleId(sysRole.getRoleId()));
		}
		return sysRole;
	}

	/**
	 * Operations on SysUser 
	 */
	
	@Override
	public List<SysUser> findUsers() {
		List<SysUser> users = this.sysUserMapper.selectByExample(null);
		
		if(users!=null && users.size()>0){
			for(SysUser user : users){
				user.setRoles(this.findRolesByUserId(user.getUserId()));
				user.setRights(this.findRightsByUserId(user.getUserId()));
				
			}
		}
		
		return users;
	}

	@Override
	public ResultPageBuilder<SysUser> findUsersByPage(SysUser user, int currentPage) {
		SysUserExample example = new SysUserExample();
		int allRows = this.sysUserMapper.countByExample(example);
		//
		ResultPageBuilder<SysUser> pageBuilder = new ResultPageBuilder<SysUser>(allRows, EntityConstants.PAGE_SIZE, currentPage);
		//
		example.setStart(pageBuilder.getStart());
		example.setStart(pageBuilder.getEnd());
		List<SysUser> users = this.sysUserMapper.selectByExample(example);
		//
		if(users!=null && users.size()>0){
			for(SysUser entry : users){
				entry.setRoles(this.findRolesByUserId(entry.getUserId()));
				entry.setRights(this.findRightsByUserId(entry.getUserId()));
			}
		}
		
		pageBuilder.setResultSet(users);
		
		return pageBuilder;
	}

	@Override
	public SysUser selectOneUser(int userId) {
		SysUser sysUser = this.sysUserMapper.selectByPrimaryKey(userId);

		sysUser.setRoles(this.findRolesByUserId(sysUser.getUserId()));
		sysUser.setRights(this.findRightsByUserId(sysUser.getUserId()));

		return sysUser;
	}
	
	@Override
	public int checkLogin(String loginName, String loginPwd) {
		//#1 check loginName
		SysUserExample example = new SysUserExample();
		org.wmichina.crm.entity.example.SysUserExample.Criteria query = example.createCriteria();
		query.andLoginNameEqualTo(loginName);
		
		List<SysUser> result = this.sysUserMapper.selectByExample(example);
		if(result==null || result.size()==0){
			return -1; //用户不存在
		}else if(result.size()==1){
			//#2 check　loginPwd
			SysUser sysUser = result.get(0);
			if(sysUser.getLoginPwd().equals(loginPwd)){
				return sysUser.getUserId(); //密码正确，返回用户ID
			}else{
				return -2; //密码错误
			}
		}else {
			return -99; //数据异常
		}
	}

	@Override
	public boolean checkLoginName(String loginName) {
		SysUserExample example = new SysUserExample();
		org.wmichina.crm.entity.example.SysUserExample.Criteria query = example.createCriteria();
		query.andLoginNameEqualTo(loginName);
		
		List<SysUser> result = this.sysUserMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public boolean checkEmail(String email) {
		SysUserExample example = new SysUserExample();
		org.wmichina.crm.entity.example.SysUserExample.Criteria query = example.createCriteria();
		query.andEmailEqualTo(email);
		
		List<SysUser> result = this.sysUserMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public boolean checkMobile(String mobile) {
		SysUserExample example = new SysUserExample();
		org.wmichina.crm.entity.example.SysUserExample.Criteria query = example.createCriteria();
		query.andMobileEqualTo(mobile);
		
		List<SysUser> result = this.sysUserMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public void createUser(SysUser user) {
		this.sysUserMapper.insertSelective(user);
		if(user.getRoleIds()!=null && user.getRoleIds().length>0){
			for(String roleId : user.getRoleIds()){
				SysUserRoles userRole = new SysUserRoles();
				userRole.setUserId(user.getUserId());
				userRole.setRoleId(Integer.parseInt(roleId));
				userRole.setCreateUser(user.getCreateUser());
				
				this.sysUserRolesMapper.insertSelective(userRole);
			}
		}
	}

	@Override
	public void updateUser(SysUser user) {
		this.sysUserMapper.updateByPrimaryKeySelective(user);
		if(user.getRoleIds()!=null && user.getRoleIds().length>0){
			// 1st: delete old roles.
			SysUserRolesExample example = new SysUserRolesExample();
			SysUserRolesExample.Criteria query = example.createCriteria();
			query.andUserIdEqualTo(user.getUserId());
			this.sysUserRolesMapper.deleteByExample(example);
			// 2nd: insert new roles.
			for(String roleId : user.getRoleIds()){
				SysUserRoles userRole = new SysUserRoles();
				userRole.setUserId(user.getUserId());
				userRole.setRoleId(Integer.parseInt(roleId));
				userRole.setCreateUser(user.getCreateUser());
				
				this.sysUserRolesMapper.insertSelective(userRole);
			}
		}
	}
}

