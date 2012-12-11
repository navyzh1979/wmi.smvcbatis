
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
import org.wmichina.crm.entity.SysNotice;
import org.wmichina.crm.entity.SysRole;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.helper.SysCache;
import org.wmichina.crm.service.SysJobTagNoticeService;

@Controller
@RequestMapping(value = "sys/notice")
public class SysNoticeController {

	@Resource(name = "sysJobTagNoticeService")
	private SysJobTagNoticeService sysJobTagNoticeService;

	@RequestMapping(value = {"list","new"})
	public ModelAndView listUser(Integer pageNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(pageNo==null) pageNo=1;
		//获取角色列表
		List<SysRole> roles = new ArrayList<SysRole>();
		roles.addAll(SysCache.getInstance().ROLES_BY_ID.values());
		//获取公告列表
		ResultPageBuilder<SysNotice> noticePage = this.sysJobTagNoticeService.findNoticesByPage(null, pageNo);
		//设置request
		map.put("roles", roles);
		map.put("pageInfo", noticePage);
		map.put("sysNotice", new SysNotice());
		
		return new ModelAndView("sys/sys_notice_all", map);
	}

	@RequestMapping(value = {"save","update"})
	public ModelAndView saveUser(@ModelAttribute @Valid SysNotice sysNotice, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		if(result.hasErrors()){	
			//获取角色列表
			List<SysRole> roles = new ArrayList<SysRole>();
			roles.addAll(SysCache.getInstance().ROLES_BY_ID.values());
			//获取公告列表
			ResultPageBuilder<SysNotice> noticePage = this.sysJobTagNoticeService.findNoticesByPage(null, 1);
			//设置request
			map.put("roles", roles);
			map.put("pageInfo", noticePage);
			map.put("sysNotice", sysNotice);
			
			return new ModelAndView("sys/sys_notice_all", map);
		}
		//
		boolean isExistsNoticeName = this.sysJobTagNoticeService.checkNoticeName(sysNotice.getNoticeName());
		if(isExistsNoticeName ){
			//获取角色列表
			List<SysRole> roles = new ArrayList<SysRole>();
			roles.addAll(SysCache.getInstance().ROLES_BY_ID.values());
			//获取公告列表
			ResultPageBuilder<SysNotice> noticePage = this.sysJobTagNoticeService.findNoticesByPage(null, 1);
			//设置request
			map.put("roles", roles);
			map.put("pageInfo", noticePage);
			map.put("sysNotice", sysNotice);
			if(isExistsNoticeName){
				FieldError error = new FieldError("sysNotice","noiticeName","公告名已存在！");
				result.addError(error);
			}
			return new ModelAndView("sys/sys_notice_all", map);
		}
		String action= sysNotice.getAction();
		// create notice
		if(action!=null &&action.equals("new")){
			sysNotice.setIsValid(EntityConstants.IS_VALILD_1);
			
			this.sysJobTagNoticeService.insertNotice(sysNotice);
			map.put("success_msg", "公告创建成功！");
		}
		// update notice
		if(action!=null && action.equals("update")){
			sysNotice.setUpdateDate(Calendar.getInstance().getTime());
			
			this.sysJobTagNoticeService.updateNotice(sysNotice);
			map.put("success_msg", "公告修改成功！");
		}

		//获取角色列表
		List<SysRole> roles = new ArrayList<SysRole>();
		roles.addAll(SysCache.getInstance().ROLES_BY_ID.values());
		//获取公告列表
		ResultPageBuilder<SysNotice> noticePage = this.sysJobTagNoticeService.findNoticesByPage(null, 1);
		//设置request
		map.put("roles", roles);
		map.put("pageInfo", noticePage);
		map.put("sysNotice", sysNotice);	
		
		return new ModelAndView("sys/sys_notice_all", map);
	}	
}