
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
import org.wmichina.crm.entity.BizChannel;
import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.helper.SysCache;
import org.wmichina.crm.service.BizActChannelService;

@Controller
@RequestMapping(value = "biz/channel")
public class BizChannelController {

	@Resource(name = "bizActChannelService")
	private BizActChannelService bizActChannelService;

	@RequestMapping(value = {"list","new"})
	public ModelAndView listChannel(Integer pageNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(pageNo==null) pageNo=1;
		//获取来源
		ResultPageBuilder<BizChannel> channelPage = this.bizActChannelService.findChannelsByPage(null, pageNo);
		//获取属性选项
		List<SysConstant> channelClass_1=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C1);
		List<SysConstant> channelClass_2=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C2);
		List<SysConstant> channelClass_3=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C3);
		List<SysConstant> channelClass_4=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C4);
		List<SysConstant> channelClass_5=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C5);
		//设置request
		map.put("pageInfo", channelPage);
		map.put("channelClass_1", channelClass_1);
		map.put("channelClass_2", channelClass_2);
		map.put("channelClass_3", channelClass_3);
		map.put("channelClass_4", channelClass_4);
		map.put("channelClass_5", channelClass_5);
		map.put("bizChannel", new BizChannel());
		
		return new ModelAndView("sys/sys_channel_all", map);
	}

	@RequestMapping(value = {"save","update"})
	public ModelAndView saveChannel(@ModelAttribute @Valid BizChannel bizChannel, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		if(result.hasErrors()){	
			//获取来源
			ResultPageBuilder<BizChannel> channelPage = this.bizActChannelService.findChannelsByPage(null, 1);
			//获取属性选项
			List<SysConstant> channelClass_1=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C1);
			List<SysConstant> channelClass_2=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C2);
			List<SysConstant> channelClass_3=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C3);
			List<SysConstant> channelClass_4=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C4);
			List<SysConstant> channelClass_5=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C5);
			//设置request
			map.put("pageInfo", channelPage);
			map.put("channelClass_1", channelClass_1);
			map.put("channelClass_2", channelClass_2);
			map.put("channelClass_3", channelClass_3);
			map.put("channelClass_4", channelClass_4);
			map.put("channelClass_5", channelClass_5);
			map.put("bizChannel", bizChannel);
			
			return new ModelAndView("sys/sys_channel_all", map);
		}
		//
		boolean isExistsChannelName = this.bizActChannelService.checkChannelName(bizChannel.getChannelName());
		boolean isExistsChannelCode = this.bizActChannelService.checkChannelCode(bizChannel.getChannelCode());
		if(isExistsChannelName || isExistsChannelCode  ){
			//获取来源
			ResultPageBuilder<BizChannel> channelPage = this.bizActChannelService.findChannelsByPage(null, 1);
			//获取属性选项
			List<SysConstant> channelClass_1=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C1);
			List<SysConstant> channelClass_2=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C2);
			List<SysConstant> channelClass_3=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C3);
			List<SysConstant> channelClass_4=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C4);
			List<SysConstant> channelClass_5=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C5);
			//设置request
			map.put("pageInfo", channelPage);
			map.put("channelClass_1", channelClass_1);
			map.put("channelClass_2", channelClass_2);
			map.put("channelClass_3", channelClass_3);
			map.put("channelClass_4", channelClass_4);
			map.put("channelClass_5", channelClass_5);
			map.put("bizChannel", bizChannel);
			if(isExistsChannelName){
				FieldError error = new FieldError("bizChannel","channelName","来源主题已存在！");
				result.addError(error);
			}
			if(isExistsChannelCode){
				FieldError error = new FieldError("bizChannel","channelCode","来源标识已存在！");
				result.addError(error);
			}

			return new ModelAndView("sys/sys_channel_all", map);
		}
		String action= bizChannel.getAction();
		// create channel
		if(action!=null &&action.equals("new")){
			bizChannel.setIsValid(EntityConstants.IS_VALILD_1);
			
			this.bizActChannelService.insertChannel(bizChannel);
			map.put("success_msg", "来源创建成功！");
		}
		// update channel
		if(action!=null && action.equals("update")){
			bizChannel.setUpdateDate(Calendar.getInstance().getTime());
			
			this.bizActChannelService.updateChannel(bizChannel);
			map.put("success_msg", "来源修改成功！");
		}

		//获取来源
		ResultPageBuilder<BizChannel> channelPage = this.bizActChannelService.findChannelsByPage(null, 1);
		//获取属性选项
		List<SysConstant> channelClass_1=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C1);
		List<SysConstant> channelClass_2=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C2);
		List<SysConstant> channelClass_3=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C3);
		List<SysConstant> channelClass_4=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C4);
		List<SysConstant> channelClass_5=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_CHANNEL_C5);
		//设置request
		map.put("pageInfo", channelPage);
		map.put("channelClass_1", channelClass_1);
		map.put("channelClass_2", channelClass_2);
		map.put("channelClass_3", channelClass_3);
		map.put("channelClass_4", channelClass_4);
		map.put("channelClass_5", channelClass_5);
		map.put("bizChannel", bizChannel);	
		
		return new ModelAndView("sys/sys_channel_all", map);
	}	
}