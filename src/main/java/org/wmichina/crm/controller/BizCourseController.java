
package org.wmichina.crm.controller;

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
import org.wmichina.crm.entity.BizCourse;
import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.helper.SysCache;
import org.wmichina.crm.service.BizCourseMaterialService;

@Controller
@RequestMapping(value = "biz/course")
public class BizCourseController {

	@Resource(name = "bizCourseMaterialService")
	private BizCourseMaterialService bizCourseMaterialService;

	@RequestMapping(value = "list")
	public ModelAndView listCourse(@ModelAttribute BizCourse bizCourse, Integer pageNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(pageNo==null) pageNo=1;
		//获取来源		
		ResultPageBuilder<BizCourse> coursePage = this.bizCourseMaterialService.findCoursesByPage(bizCourse, pageNo);
		//获取属性选项
		List<SysConstant> courseCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CATEGORY);
		List<SysConstant> courseClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CLASS);
		List<SysConstant> courseType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TYPE);
		List<SysConstant> learningMode=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_MODE);
		List<SysConstant> learningTime=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TIME);
		List<SysConstant> learningCity=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_BASE_LNCITY);
		//设置request
		map.put("pageInfo", coursePage);
		map.put("courseCategory", courseCategory);
		map.put("courseClass", courseClass);
		map.put("courseType", courseType);
		map.put("learningMode", learningMode);
		map.put("learningTime", learningTime);
		map.put("learningCity", learningCity);
		map.put("bizCourse", bizCourse);
		
		return new ModelAndView("sys/biz_course_list", map);
	}
	
	@RequestMapping(value = "new")
	public ModelAndView newCourse(@ModelAttribute BizCourse bizCourse) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//获取属性选项
		List<SysConstant> courseCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CATEGORY);
		List<SysConstant> courseClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CLASS);
		List<SysConstant> courseType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TYPE);
		List<SysConstant> learningMode=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_MODE);
		List<SysConstant> learningTime=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TIME);
		List<SysConstant> learningCity=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_BASE_LNCITY);
		//设置request
		map.put("courseCategory", courseCategory);
		map.put("courseClass", courseClass);
		map.put("courseType", courseType);
		map.put("learningMode", learningMode);
		map.put("learningTime", learningTime);
		map.put("learningCity", learningCity);
		
		return new ModelAndView("sys/biz_course_new", map);
	}

	@RequestMapping(value = "save")
	public ModelAndView saveCourse(@ModelAttribute @Valid BizCourse bizCourse, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		if(result.hasErrors()){	
			//获取属性选项
			List<SysConstant> courseCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CATEGORY);
			List<SysConstant> courseClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CLASS);
			List<SysConstant> courseType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TYPE);
			List<SysConstant> learningMode=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_MODE);
			List<SysConstant> learningTime=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TIME);
			List<SysConstant> learningCity=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_BASE_LNCITY);
			//设置request
			map.put("courseCategory", courseCategory);
			map.put("courseClass", courseClass);
			map.put("courseType", courseType);
			map.put("learningMode", learningMode);
			map.put("learningTime", learningTime);
			map.put("learningCity", learningCity);
			map.put("bizCourse", bizCourse);
			
			return new ModelAndView("sys/biz_course_new", map);
		}
		//
		boolean isExistsCourseName = this.bizCourseMaterialService.checkCourseName(bizCourse.getCourseName());
		boolean isExistsCourseCode = this.bizCourseMaterialService.checkCourseCode(bizCourse.getCourseCode());
		if(isExistsCourseName || isExistsCourseCode  ){
			//获取属性选项
			List<SysConstant> courseCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CATEGORY);
			List<SysConstant> courseClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CLASS);
			List<SysConstant> courseType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TYPE);
			List<SysConstant> learningMode=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_MODE);
			List<SysConstant> learningTime=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TIME);
			List<SysConstant> learningCity=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_BASE_LNCITY);
			//设置request
			map.put("courseCategory", courseCategory);
			map.put("courseClass", courseClass);
			map.put("courseType", courseType);
			map.put("learningMode", learningMode);
			map.put("learningTime", learningTime);
			map.put("learningCity", learningCity);
			map.put("bizCourse", bizCourse);
			if(isExistsCourseName){
				FieldError error = new FieldError("bizCourse","courseName","课程编号已存在！");
				result.addError(error);
			}
			if(isExistsCourseCode){
				FieldError error = new FieldError("bizCourse","courseCode","课程名称已存在！");
				result.addError(error);
			}

			return new ModelAndView("sys/biz_course_new", map);
		}
		//
		bizCourse.setIsValid(EntityConstants.IS_VALILD_1);
		this.bizCourseMaterialService.insertCourse(bizCourse);
		//
		map.put("success_msg", "课程创建成功！");
		//
		return new ModelAndView("sys/biz_course_success", map);
	}
	
	@RequestMapping(value = "edit")
	public ModelAndView editCourse(Integer courseId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//获取属性选项
		List<SysConstant> courseCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CATEGORY);
		List<SysConstant> courseClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CLASS);
		List<SysConstant> courseType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TYPE);
		List<SysConstant> learningMode=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_MODE);
		List<SysConstant> learningTime=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TIME);
		List<SysConstant> learningCity=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_BASE_LNCITY);
		//设置request
		map.put("courseCategory", courseCategory);
		map.put("courseClass", courseClass);
		map.put("courseType", courseType);
		map.put("learningMode", learningMode);
		map.put("learningTime", learningTime);
		map.put("learningCity", learningCity);
		//
		BizCourse bizCourse = this.bizCourseMaterialService.selectCourseById(courseId);
		map.put("bizCourse", bizCourse);
		
		return new ModelAndView("sys/biz_course_edit", map);
	}


	@RequestMapping(value = "update")
	public ModelAndView updateCourse(@ModelAttribute @Valid BizCourse bizCourse, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		if(result.hasErrors()){	
			//获取属性选项
			List<SysConstant> courseCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CATEGORY);
			List<SysConstant> courseClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CLASS);
			List<SysConstant> courseType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TYPE);
			List<SysConstant> learningMode=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_MODE);
			List<SysConstant> learningTime=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TIME);
			List<SysConstant> learningCity=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_BASE_LNCITY);
			//设置request
			map.put("courseCategory", courseCategory);
			map.put("courseClass", courseClass);
			map.put("courseType", courseType);
			map.put("learningMode", learningMode);
			map.put("learningTime", learningTime);
			map.put("learningCity", learningCity);
			map.put("bizCourse", bizCourse);
			
			return new ModelAndView("sys/biz_course_new", map);
		}
		//
		BizCourse existsCourseByName = this.bizCourseMaterialService.selectCourseByName(bizCourse.getCourseName());
		BizCourse existsCourseByCode = this.bizCourseMaterialService.selectCourseByCode(bizCourse.getCourseCode());
		boolean isExistsCourseName = false;
		boolean isExistsCourseCode = false;
		if(existsCourseByName != null && 
				existsCourseByName.getCourseId().intValue() != bizCourse.getCourseId()) {
			isExistsCourseName = true;
		}
		if(existsCourseByCode != null &&
				existsCourseByCode.getCourseId().intValue() != bizCourse.getCourseId()) {
			isExistsCourseCode = true;
		}
		if(isExistsCourseName || isExistsCourseCode  ){
			//获取属性选项
			List<SysConstant> courseCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CATEGORY);
			List<SysConstant> courseClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_CLASS);
			List<SysConstant> courseType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TYPE);
			List<SysConstant> learningMode=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_MODE);
			List<SysConstant> learningTime=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_COURSE_TIME);
			List<SysConstant> learningCity=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_BASE_LNCITY);
			//设置request
			map.put("courseCategory", courseCategory);
			map.put("courseClass", courseClass);
			map.put("courseType", courseType);
			map.put("learningMode", learningMode);
			map.put("learningTime", learningTime);
			map.put("learningCity", learningCity);
			map.put("bizCourse", bizCourse);
			if(isExistsCourseName){
				FieldError error = new FieldError("bizCourse","courseName","课程编号已存在！");
				result.addError(error);
			}
			if(isExistsCourseCode){
				FieldError error = new FieldError("bizCourse","courseCode","课程名称已存在！");
				result.addError(error);
			}

			return new ModelAndView("sys/biz_course_new", map);
		}
		//
		bizCourse.setIsValid(EntityConstants.IS_VALILD_1);
		this.bizCourseMaterialService.insertCourse(bizCourse);
		//
		map.put("success_msg", "课程修改成功！");
		//
		return new ModelAndView("sys/biz_course_success", map);
	}	
}