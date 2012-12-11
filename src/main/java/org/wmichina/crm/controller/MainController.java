
package org.wmichina.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wmichina.crm.entity.SysRight;
import org.wmichina.crm.entity.SysUser;
import org.wmichina.crm.helper.RightMenuBuilder;
import org.wmichina.crm.service.SysRoleUserService;

@Controller
@RequestMapping(value = "")
public class MainController {

	@Resource(name = "sysRoleUserService")
	private SysRoleUserService sysRoleUserService;

	@RequestMapping(value = "main")
	public ModelAndView toMainPage(@ModelAttribute SysUser sysUser) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		return new ModelAndView("main", map);
	}
	@RequestMapping(value = "left")
	public ModelAndView initLeftMenu(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		List<SysRight> allRights = this.sysRoleUserService.findRights();
		//@SuppressWarnings("unchecked")
		//List<SysRight> allRights = (List<SysRight>) request.getSession().getAttribute("rightList");
		
		RightMenuBuilder builder = RightMenuBuilder.initMymenus(allRights);
		map.put("builder", builder);
			
		return new ModelAndView("inc/left", map);
	}
	@RequestMapping(value = "top")
	public ModelAndView mainTop(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		
		return new ModelAndView("inc/top", map);
	}
}