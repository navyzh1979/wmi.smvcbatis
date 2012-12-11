
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
import org.wmichina.crm.entity.SysConstantOption;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.service.SysDefaultService;

@Controller
@RequestMapping(value = "sys/option")
public class SysOptionsController {

	@Resource(name = "sysDefaultService")
	private SysDefaultService sysDefaultService;

	@RequestMapping(value = {"list","new"})
	public ModelAndView list(Integer pageNo) throws Exception {
		if(pageNo==null) pageNo=1;
		//获取实体名列表
		List<SysConstant> entities = this.sysDefaultService.findConstantsByLevel(EntityConstants.CONSTANT_LEVEL_ENTITY);
		//获取选项分页列表
		ResultPageBuilder<SysConstantOption> options = this.sysDefaultService.findConstantsByPage(null, pageNo);
		//设置request
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("entities", entities);
		map.put("pageInfo", options);
		map.put("sysConstantOption", new SysConstantOption());
		
		return new ModelAndView("sys/sys_option_all", map);
	}

	@RequestMapping(value = "save")
	public ModelAndView saveOption(@ModelAttribute @Valid SysConstantOption sysConstantOption, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		if(result.hasErrors()){	
			//获取实体名列表
			List<SysConstant> entities = this.sysDefaultService.findConstantsByLevel(EntityConstants.CONSTANT_LEVEL_ENTITY);
			//获取选项分页列表
			ResultPageBuilder<SysConstantOption> options = this.sysDefaultService.findConstantsByPage(null, 1);
			//设置request
			map.put("entities", entities);
			map.put("pageInfo", options);
			map.put("sysConstantOption", sysConstantOption);
			return new ModelAndView("sys/sys_option_all", map);
		}
		//
		boolean checkOption = this.sysDefaultService.checkOption(sysConstantOption);
		if(checkOption){
			//获取实体名列表
			List<SysConstant> entities = this.sysDefaultService.findConstantsByLevel(EntityConstants.CONSTANT_LEVEL_ENTITY);
			//获取选项分页列表
			ResultPageBuilder<SysConstantOption> options = this.sysDefaultService.findConstantsByPage(null, 1);
			//设置request
			map.put("entities", entities);
			map.put("pageInfo", options);
			map.put("sysConstantOption", sysConstantOption);			
			FieldError error = new FieldError("sysOption","optionName","选项名已存在！");
			result.addError(error);
			return new ModelAndView("sys/sys_option_all", map);
		}
		// create option
		if(sysConstantOption.getAction()!=null && sysConstantOption.getAction().equals("new")){
			SysConstant constant = new SysConstant();
			constant.setConstantLevel(EntityConstants.CONSTANT_LEVEL_OPTION);
			constant.setIsPredefined(EntityConstants.IS_PREDEFINED_0);
			constant.setIsValid(EntityConstants.IS_VALILD_1);
			constant.setConstantName(sysConstantOption.getOptionName());
			constant.setRemark(sysConstantOption.getRemark());
			constant.setParentCode(sysConstantOption.getAttrCode());
			
			this.sysDefaultService.insertOneConstant(constant);
			map.put("success_msg", "选项创建成功！");
		}
		// create option
		if(sysConstantOption.getAction()!=null && sysConstantOption.getAction().equals("update")){
			SysConstant constant = new SysConstant();
			constant.setConstantId(sysConstantOption.getOptionId());
			constant.setConstantName(sysConstantOption.getOptionName());
			constant.setRemark(sysConstantOption.getRemark());
			constant.setParentCode(sysConstantOption.getAttrCode());
			constant.setUpdateDate(Calendar.getInstance().getTime());
			
			this.sysDefaultService.updateConstant(constant);
			map.put("success_msg", "选项修改成功！");
		}
		//
		//获取实体名列表
		List<SysConstant> entities = this.sysDefaultService.findConstantsByLevel(EntityConstants.CONSTANT_LEVEL_ENTITY);
		//获取选项分页列表
		ResultPageBuilder<SysConstantOption> options = this.sysDefaultService.findConstantsByPage(null, 1);
		//设置request
		map.put("entities", entities);
		map.put("pageInfo", options);
		map.put("sysConstantOption", new SysConstantOption());
		
		return new ModelAndView("sys/sys_option_all", map);
	}	
}