
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
import org.wmichina.crm.entity.BizActivity;
import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.helper.SysCache;
import org.wmichina.crm.service.BizActChannelService;

@Controller
@RequestMapping(value = "biz/activity")
public class BizActivityController {

	@Resource(name = "bizActChannelService")
	private BizActChannelService bizActChannelService;

	@RequestMapping(value = {"list","new"})
	public ModelAndView listActivity(Integer pageNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(pageNo==null) pageNo=1;
		//获取活动
		ResultPageBuilder<BizActivity> activityPage = this.bizActChannelService.findActivitiesByPage(null, pageNo);
		//获取属性选项
		List<SysConstant> activityClass_1=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_ACTIVITY_C1);
		List<SysConstant> activityClass_2=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_ACTIVITY_C2);
		List<SysConstant> activityClass_3=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_ACTIVITY_C3);
		//设置request
		map.put("pageInfo", activityPage);
		map.put("activityClass_1", activityClass_1);
		map.put("activityClass_2", activityClass_2);
		map.put("activityClass_3", activityClass_3);
		map.put("bizActivity", new BizActivity());
		
		return new ModelAndView("sys/sys_activity_all", map);
	}

	@RequestMapping(value = {"save","update"})
	public ModelAndView saveActivity(@ModelAttribute @Valid BizActivity bizActivity, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		if(result.hasErrors()){	
			//获取活动
			ResultPageBuilder<BizActivity> activityPage = this.bizActChannelService.findActivitiesByPage(null, 1);
			//获取属性选项
			List<SysConstant> activityClass_1=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_ACTIVITY_C1);
			List<SysConstant> activityClass_2=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_ACTIVITY_C2);
			List<SysConstant> activityClass_3=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_ACTIVITY_C3);
			//设置request
			map.put("pageInfo", activityPage);
			map.put("activityClass_1", activityClass_1);
			map.put("activityClass_2", activityClass_2);
			map.put("activityClass_3", activityClass_3);
			map.put("bizActivity", bizActivity);
			
			return new ModelAndView("sys/sys_activity_all", map);
		}
		//
		boolean isExistsActivityName = this.bizActChannelService.checkActivityName(bizActivity.getActivityName());
		boolean isExistsActivityCode = this.bizActChannelService.checkActivityCode(bizActivity.getActivityCode());
		if(isExistsActivityName || isExistsActivityCode  ){
			//获取活动
			ResultPageBuilder<BizActivity> activityPage = this.bizActChannelService.findActivitiesByPage(null, 1);
			//获取属性选项
			List<SysConstant> activityClass_1=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_ACTIVITY_C1);
			List<SysConstant> activityClass_2=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_ACTIVITY_C2);
			List<SysConstant> activityClass_3=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_ACTIVITY_C3);
			//设置request
			map.put("pageInfo", activityPage);
			map.put("activityClass_1", activityClass_1);
			map.put("activityClass_2", activityClass_2);
			map.put("activityClass_3", activityClass_3);
			map.put("bizActivity", bizActivity);
			if(isExistsActivityName){
				FieldError error = new FieldError("bizActivity","activityName","活动主题已存在！");
				result.addError(error);
			}
			if(isExistsActivityCode){
				FieldError error = new FieldError("bizActivity","activityCode","活动标识已存在！");
				result.addError(error);
			}

			return new ModelAndView("sys/sys_activity_all", map);
		}
		String action= bizActivity.getAction();
		// create activity
		if(action!=null &&action.equals("new")){
			bizActivity.setIsValid(EntityConstants.IS_VALILD_1);
			
			this.bizActChannelService.insertActivity(bizActivity);
			map.put("success_msg", "活动创建成功！");
		}
		// update activity
		if(action!=null && action.equals("update")){
			bizActivity.setUpdateDate(Calendar.getInstance().getTime());
			
			this.bizActChannelService.updateActivity(bizActivity);
			map.put("success_msg", "活动修改成功！");
		}

		//获取活动
		ResultPageBuilder<BizActivity> activityPage = this.bizActChannelService.findActivitiesByPage(null, 1);
		//获取属性选项
		List<SysConstant> activityClass_1=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_ACTIVITY_C1);
		List<SysConstant> activityClass_2=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_ACTIVITY_C2);
		List<SysConstant> activityClass_3=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_ACTIVITY_C3);
		//设置request
		map.put("pageInfo", activityPage);
		map.put("activityClass_1", activityClass_1);
		map.put("activityClass_2", activityClass_2);
		map.put("activityClass_3", activityClass_3);
		map.put("bizActivity", bizActivity);	
		
		return new ModelAndView("sys/sys_activity_all", map);
	}	
}