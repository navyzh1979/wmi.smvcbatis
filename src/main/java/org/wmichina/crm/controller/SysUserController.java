
package org.wmichina.crm.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.entity.SysRole;
import org.wmichina.crm.entity.SysUser;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.helper.SysCache;
import org.wmichina.crm.service.SysDefaultService;
import org.wmichina.crm.service.SysRoleUserService;
import org.wmichina.crm.util.Md5;

@Controller
@RequestMapping(value = "sys/user")
public class SysUserController {

	@Resource(name = "sysRoleUserService")
	private SysRoleUserService sysRoleUserService;
	
	@Resource(name = "sysDefaultService")
	private SysDefaultService sysDefaultService;

	@RequestMapping(value = {"list","new"})
	public ModelAndView listUser(Integer pageNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(pageNo==null) pageNo=1;
		//获取工作部门列表
		List<SysConstant> departments = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_BASE_DEPART);
		//获取角色列表
		List<SysRole> roles = new ArrayList<SysRole>();
		roles.addAll(SysCache.getInstance().ROLES_BY_ID.values());
		//获取用户列表
		ResultPageBuilder<SysUser> userPage = this.sysRoleUserService.findUsersByPage(null, pageNo);
		//设置request
		map.put("roles", roles);
		map.put("departments", departments);
		map.put("pageInfo", userPage);
		map.put("sysUser", new SysUser());
		
		return new ModelAndView("sys/sys_user_all", map);
	}

	@RequestMapping(value = {"save","update"})
	public ModelAndView saveUser(@ModelAttribute @Valid SysUser sysUser, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		if(result.hasErrors()){	
			//获取工作部门列表
			List<SysConstant> departments = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_BASE_DEPART);
			//获取角色列表
			List<SysRole> roles = new ArrayList<SysRole>();
			roles.addAll(SysCache.getInstance().ROLES_BY_ID.values());
			//获取用户列表
			ResultPageBuilder<SysUser> userPage = this.sysRoleUserService.findUsersByPage(null, 1);
			//设置request
			map.put("roles", roles);
			map.put("departments", departments);
			map.put("pageInfo", userPage);
			map.put("sysUser", sysUser);
			
			return new ModelAndView("sys/sys_user_all", map);
		}
		//
		boolean isExistsLoginName = this.sysRoleUserService.checkLoginName(sysUser.getLoginName());
		boolean isExistsEmail = this.sysRoleUserService.checkEmail(sysUser.getEmail());
		boolean isExistsMobile = this.sysRoleUserService.checkMobile(sysUser.getMobile());
		if(isExistsLoginName || isExistsEmail || isExistsMobile ){
			//获取工作部门列表
			List<SysConstant> departments = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_BASE_DEPART);
			//获取角色列表
			List<SysRole> roles = new ArrayList<SysRole>();
			roles.addAll(SysCache.getInstance().ROLES_BY_ID.values());
			//获取用户列表
			ResultPageBuilder<SysUser> userPage = this.sysRoleUserService.findUsersByPage(null, 1);
			//设置request
			map.put("roles", roles);
			map.put("departments", departments);
			map.put("pageInfo", userPage);
			map.put("sysUser", sysUser);
			if(isExistsLoginName){
				FieldError error = new FieldError("sysUser","loginName","用户名已存在！");
				result.addError(error);
			}
			if(isExistsEmail){
				FieldError error = new FieldError("sysUser","email","邮箱地址已存在！");
				result.addError(error);
			}
			if(isExistsMobile){
				FieldError error = new FieldError("sysUser","mobile","手机号已存在！");
				result.addError(error);
			}
			return new ModelAndView("sys/sys_user_all", map);
		}
		String action= sysUser.getAction();
		// create user
		if(action!=null &&action.equals("new")){
			sysUser.setLoginPwd(Md5.getMd5(sysUser.getLoginPwd().trim()));
			sysUser.setAuditStatus(EntityConstants.AUDITSTATUS_0);
			sysUser.setIsValid(EntityConstants.IS_VALILD_1);
			
			this.sysRoleUserService.createUser(sysUser);
			map.put("success_msg", "用户创建成功！");
		}
		// update user
		if(action!=null && action.equals("update")){
			sysUser.setLoginPwd(Md5.getMd5(sysUser.getLoginPwd().trim()));
			sysUser.setUpdateDate(Calendar.getInstance().getTime());
			
			this.sysRoleUserService.updateUser(sysUser);
			map.put("success_msg", "用户修改成功！");
		}

		//获取工作部门列表
		List<SysConstant> departments = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_BASE_DEPART);
		//获取角色列表
		List<SysRole> roles = new ArrayList<SysRole>();
		roles.addAll(SysCache.getInstance().ROLES_BY_ID.values());
		//获取用户列表
		ResultPageBuilder<SysUser> userPage = this.sysRoleUserService.findUsersByPage(null, 1);
		//设置request
		map.put("roles", roles);
		map.put("departments", departments);
		map.put("pageInfo", userPage);
		map.put("sysUser", sysUser);	
		
		return new ModelAndView("sys/sys_user_all", map);
	}	
}