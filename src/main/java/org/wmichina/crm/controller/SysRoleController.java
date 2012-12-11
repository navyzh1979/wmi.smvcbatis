
package org.wmichina.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wmichina.crm.entity.SysRight;
import org.wmichina.crm.entity.SysRole;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.helper.RightModuleBuilder;
import org.wmichina.crm.service.SysRoleUserService;

@Controller
@RequestMapping(value = "sys")
public class SysRoleController {

	@Resource(name = "sysRoleUserService")
	private SysRoleUserService sysRoleUserService;

	@RequestMapping(value = "role/list")
	public ModelAndView list(Integer pageNo) throws Exception {
		//获取角色分页列表
		if(pageNo==null || pageNo<=1) pageNo=1;
		ResultPageBuilder<SysRole> roles = this.sysRoleUserService.findRolesByPage(null, pageNo);
		//设置request
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageInfo", roles);
		//
		return new ModelAndView("sys/sys_role_list", map);
	}

	@RequestMapping(value = "role/new")
	public ModelAndView newRole(@ModelAttribute SysRole sysRole) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		List<SysRight> allRights = this.sysRoleUserService.findRights();
		RightModuleBuilder builder = RightModuleBuilder.initModules(allRights);
		map.put("builder", builder);
		
		return new ModelAndView("sys/sys_role_new", map);
	}

	@RequestMapping(value = "role/save")
	public ModelAndView saveRole(@ModelAttribute @Valid SysRole sysRole, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		SysRole checkOne = this.sysRoleUserService.selectByRoleName(sysRole.getRoleName());
		if(checkOne!=null){
			FieldError error = new FieldError("sysRole","roleName","角色名已存在！");
			result.addError(error);
		}
		if(result.hasErrors()){		
			List<SysRight> allRights = this.sysRoleUserService.findRights();
			RightModuleBuilder builder = RightModuleBuilder.initModules(allRights);
			map.put("builder", builder);
			return new ModelAndView("sys/sys_role_new", map);
		}
		// create SysRole
		sysRole.setAuditStatus(EntityConstants.IS_VALILD_0);
		sysRole.setIsValid(EntityConstants.IS_VALILD_1);
		this.sysRoleUserService.createRole(sysRole);
		//
		map.put("success_msg", "角色创建成功！");
		map.put("action", "new");
		return new ModelAndView("sys/sys_role_success", map);
	}


	@RequestMapping(value = "role/edit")
	public ModelAndView editRole(Integer roleId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		List<SysRight> allRights = this.sysRoleUserService.findRights();
		RightModuleBuilder builder = RightModuleBuilder.initModules(allRights);
		map.put("builder", builder);
		SysRole sysRole = this.sysRoleUserService.selectOneRole(roleId);
		map.put("sysRole", sysRole);
		
		return new ModelAndView("sys/sys_role_edit", map);
	}

	@RequestMapping(value = "role/update")
	public ModelAndView updateRole(@ModelAttribute @Valid SysRole sysRole, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		SysRole checkByName = this.sysRoleUserService.selectByRoleName(sysRole.getRoleName());
		if(checkByName!=null && checkByName.getRoleId().intValue()!=sysRole.getRoleId().intValue()){
			FieldError error = new FieldError("sysRole","roleName","角色名已存在！");
			result.addError(error);
		}
		SysRole checkById = this.sysRoleUserService.selectOneRole(sysRole.getRoleId());
		if(checkById==null){
			FieldError error = new FieldError("sysRole","roleName","更新的角色不存在！");
			result.addError(error);
		}
		if(result.hasErrors()){
			List<SysRight> allRights = this.sysRoleUserService.findRights();
			RightModuleBuilder builder = RightModuleBuilder.initModules(allRights);
			map.put("builder", builder);
			map.put("sysRole", sysRole);
			return new ModelAndView("sys/sys_role_edit", map);
		}
		// update SysRole
		checkById.setRoleName(sysRole.getRoleName());
		checkById.setRoleRightCodes(sysRole.getRoleRightCodes());
		this.sysRoleUserService.updateRole(checkById);
		//
		map.put("success_msg", "角色修改成功！");
		map.put("action", "update");
		return new ModelAndView("sys/sys_role_success", map);
	}

	@RequestMapping(value = "role/audit")
	public ModelAndView auditRole(Integer roleId, Integer auditStatus) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		MapBindingResult result = new MapBindingResult(map,"");
		if(roleId==null || auditStatus==null){
			FieldError error = new FieldError("sysRole","roleName","更新的角色不存在！");
			result.addError(error);
		}else {
			SysRole checkById = this.sysRoleUserService.selectOneRole(roleId);
			if(checkById==null){
				FieldError error = new FieldError("sysRole","roleName","更新的角色不存在！");
				result.addError(error);
			}
		}
		if(result.hasErrors()){		
			List<SysRight> allRights = this.sysRoleUserService.findRights();
			RightModuleBuilder builder = RightModuleBuilder.initModules(allRights);
			map.put("builder", builder);
			return new ModelAndView("sys/sys_role_view", map);
		}
		// audit SysRole
		SysRole sysRole = this.sysRoleUserService.selectOneRole(roleId);
		sysRole.setAuditStatus(auditStatus);
		this.sysRoleUserService.auditRole(sysRole);
		//
		map.put("success_msg", "角色审核通过！");
		map.put("action", "update");
		return new ModelAndView("sys/sys_role_success", map);
	}

	@RequestMapping(value = "role/view")
	public ModelAndView viewRole(Integer roleId,String action) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		List<SysRight> allRights = this.sysRoleUserService.findRights();
		RightModuleBuilder builder = RightModuleBuilder.initModules(allRights);
		map.put("builder", builder);
		SysRole sysRole = this.sysRoleUserService.selectOneRole(roleId);
		map.put("sysRole", sysRole);
		map.put("action", action);
		
		return new ModelAndView("sys/sys_role_view", map);
	}
}