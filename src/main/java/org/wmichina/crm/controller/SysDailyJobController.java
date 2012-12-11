
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
import org.wmichina.crm.entity.SysDailyJob;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.service.SysDefaultService;
import org.wmichina.crm.service.SysJobTagNoticeService;

@Controller
@RequestMapping(value = "sys/dailyjob")
public class SysDailyJobController {

	@Resource(name = "sysJobTagNoticeService")
	private SysJobTagNoticeService sysJobTagNoticeService;
	
	@Resource(name = "sysDefaultService")
	private SysDefaultService sysDefaultService;

	@RequestMapping(value = {"list","new"})
	public ModelAndView listDailyJob(Integer pageNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(pageNo==null) pageNo=1;
		//获取工作部门列表
		List<SysConstant> departments = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_BASE_DEPART);
		
		//获取工作列表
		ResultPageBuilder<SysDailyJob> dailyjobPage = this.sysJobTagNoticeService.findJobsByPage(null, pageNo);
		//设置request
		map.put("departments", departments);
		map.put("pageInfo", dailyjobPage);
		map.put("sysDailyJob", new SysDailyJob());
		
		return new ModelAndView("sys/sys_dailyjob_all", map);
	}

	@RequestMapping(value = {"save","update"})
	public ModelAndView saveDailyJob(@ModelAttribute @Valid SysDailyJob sysDailyJob, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		if(result.hasErrors()){	
			//获取工作部门列表
			List<SysConstant> departments = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_BASE_DEPART);
			
			//获取工作列表
			ResultPageBuilder<SysDailyJob> dailyjobPage = this.sysJobTagNoticeService.findJobsByPage(null, 1);
			//设置request
			map.put("departments", departments);
			map.put("pageInfo", dailyjobPage);
			map.put("sysDailyJob", sysDailyJob);
			
			return new ModelAndView("sys/sys_dailyjob_all", map);
		}
		//
		boolean isExistsJobCode = this.sysJobTagNoticeService.checkJobCode(sysDailyJob.getJobCode());
		boolean isExistsJobName = this.sysJobTagNoticeService.checkJobName(sysDailyJob.getJobName());
		if(isExistsJobCode || isExistsJobName ){
			//获取工作部门列表
			List<SysConstant> departments = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_BASE_DEPART);
			
			//获取工作列表
			ResultPageBuilder<SysDailyJob> dailyjobPage = this.sysJobTagNoticeService.findJobsByPage(null, 1);
			//设置request
			map.put("departments", departments);
			map.put("pageInfo", dailyjobPage);
			map.put("sysDailyJob", sysDailyJob);
			if(isExistsJobCode){
				FieldError error = new FieldError("sysDailyJob","jobCode","工作代码已存在！");
				result.addError(error);
			}
			if(isExistsJobName){
				FieldError error = new FieldError("sysDailyJob","jobName","工作名称已存在！");
				result.addError(error);
			}

			return new ModelAndView("sys/sys_dailyjob_all", map);
		}
		String action= sysDailyJob.getAction();
		// create dailyjob
		if(action!=null &&action.equals("new")){
			sysDailyJob.setIsValid(EntityConstants.IS_VALILD_1);
			
			this.sysJobTagNoticeService.insertJob(sysDailyJob);
			map.put("success_msg", "工作创建成功！");
		}
		// update dailyjob
		if(action!=null && action.equals("update")){
			sysDailyJob.setUpdateDate(Calendar.getInstance().getTime());
			
			this.sysJobTagNoticeService.updateJob(sysDailyJob);
			map.put("success_msg", "工作修改成功！");
		}

		//获取工作部门列表
		List<SysConstant> departments = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_BASE_DEPART);
		
		//获取工作列表
		ResultPageBuilder<SysDailyJob> dailyjobPage = this.sysJobTagNoticeService.findJobsByPage(null, 1);
		//设置request
		map.put("departments", departments);
		map.put("pageInfo", dailyjobPage);
		map.put("sysDailyJob", sysDailyJob);	
		
		return new ModelAndView("sys/sys_dailyjob_all", map);
	}	
}