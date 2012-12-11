
package org.wmichina.crm.controller;

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
import org.wmichina.crm.entity.SysTag;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.service.SysDefaultService;
import org.wmichina.crm.service.SysJobTagNoticeService;

@Controller
@RequestMapping(value = "sys/tag")
public class SysTagController {

	@Resource(name = "sysJobTagNoticeService")
	private SysJobTagNoticeService sysJobTagNoticeService;

	@Resource(name = "sysDefaultService")
	private SysDefaultService sysDefaultService;

	@RequestMapping(value = {"list","new"})
	public ModelAndView listTag(Integer pageNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(pageNo==null) pageNo=1;
		//获取工作部门列表
		List<SysConstant> departments = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_BASE_DEPART);
		
		//获取标签
		ResultPageBuilder<SysTag> tagPage = this.sysJobTagNoticeService.findTagsByPage(null, pageNo);
		//设置request
		map.put("departments", departments);
		map.put("pageInfo", tagPage);
		map.put("sysTag", new SysTag());
		
		return new ModelAndView("sys/sys_tag_all", map);
	}

	@RequestMapping(value = {"save","update"})
	public ModelAndView saveTag(@ModelAttribute @Valid SysTag sysTag, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		if(result.hasErrors()){	
			//获取工作部门列表
			List<SysConstant> departments = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_BASE_DEPART);
			
			//获取标签
			ResultPageBuilder<SysTag> tagPage = this.sysJobTagNoticeService.findTagsByPage(null, 1);
			//设置request
			map.put("departments", departments);
			map.put("pageInfo", tagPage);
			map.put("sysTag", sysTag);
			
			return new ModelAndView("sys/sys_tag_all", map);
		}
		//
		boolean isExistsTagName = this.sysJobTagNoticeService.checkTagName(sysTag.getTagName());
		if(isExistsTagName  ){
			//获取工作部门列表
			List<SysConstant> departments = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_BASE_DEPART);
			
			//获取标签
			ResultPageBuilder<SysTag> tagPage = this.sysJobTagNoticeService.findTagsByPage(null, 1);
			//设置request
			map.put("departments", departments);
			map.put("pageInfo", tagPage);
			map.put("sysTag", sysTag);
			if(isExistsTagName){
				FieldError error = new FieldError("sysTag","tagName","标签名称已存在！");
				result.addError(error);
			}

			return new ModelAndView("sys/sys_tag_all", map);
		}
		String action= sysTag.getAction();
		// create tag
		if(action!=null &&action.equals("new")){
			sysTag.setIsValid(EntityConstants.IS_VALILD_1);
			
			this.sysJobTagNoticeService.insertTag(sysTag);
			map.put("success_msg", "工作创建成功！");
		}
		// update tag
		if(action!=null && action.equals("update")){
			sysTag.setUpdateDate(Calendar.getInstance().getTime());
			
			this.sysJobTagNoticeService.updateTag(sysTag);
			map.put("success_msg", "工作修改成功！");
		}

		//获取工作部门列表
		List<SysConstant> departments = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_BASE_DEPART);
		
		//获取标签
		ResultPageBuilder<SysTag> tagPage = this.sysJobTagNoticeService.findTagsByPage(null, 1);
		//设置request
		map.put("departments", departments);
		map.put("pageInfo", tagPage);
		map.put("sysTag", sysTag);	
		
		return new ModelAndView("sys/sys_tag_all", map);
	}	
}