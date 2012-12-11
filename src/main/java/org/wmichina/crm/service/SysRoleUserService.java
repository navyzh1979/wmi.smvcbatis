package org.wmichina.crm.service;

import java.util.List;

import org.wmichina.crm.entity.SysRight;
import org.wmichina.crm.entity.SysRole;
import org.wmichina.crm.entity.SysUser;
import org.wmichina.crm.helper.ResultPageBuilder;

public interface SysRoleUserService {

	/** SysRight **/
	List<SysRight> findRights();
	List<SysRight> findRightsByRoleId(int roleId);
	List<SysRight> findRightsByUserId(int userId);
	ResultPageBuilder<SysRight> findRightsByPage(SysRight right, int currentPage);

	/** SysRole **/
	List<SysRole> findRoles();
	List<SysRole> findRolesByUserId(int userId);
	ResultPageBuilder<SysRole> findRolesByPage(SysRole role, int currentPage);
	SysRole selectOneRole(int roleId);
	SysRole selectByRoleName(String roleName);
	void createRole(SysRole role);
	void updateRole(SysRole role);
	void auditRole(SysRole role); 
	
    /** SysUser **/
	List<SysUser> findUsers();
	ResultPageBuilder<SysUser> findUsersByPage(SysUser user, int currentPage);
	SysUser selectOneUser(int userId);
	int checkLogin(String loginName, String loginPwd);
	boolean checkLoginName(String loginName);
	boolean checkEmail(String email);
	boolean checkMobile(String mobile);
	void createUser(SysUser user);
	void updateUser(SysUser user);
}
