
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
import org.wmichina.crm.entity.BizMaterial;
import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.helper.SysCache;
import org.wmichina.crm.service.BizCourseMaterialService;

@Controller
@RequestMapping(value = "biz/material")
public class BizMaterialController {

	@Resource(name = "bizCourseMaterialService")
	private BizCourseMaterialService bizCourseMaterialService;

	@RequestMapping(value = "list")
	public ModelAndView listMaterial(@ModelAttribute BizMaterial bizMaterial, Integer pageNo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if(pageNo==null) pageNo=1;
		//获取资料列表		
		ResultPageBuilder<BizMaterial> materialPage = this.bizCourseMaterialService.findMaterialsByPage(bizMaterial, pageNo);
		//获取属性选项
		List<SysConstant> materialCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CATEGORY);
		List<SysConstant> materialClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CLASS);
		List<SysConstant> materialType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_TYPE);
		//设置request
		map.put("pageInfo", materialPage);
		map.put("materialCategory", materialCategory);
		map.put("materialClass", materialClass);
		map.put("materialType", materialType);
		map.put("bizMaterial", bizMaterial);
		
		return new ModelAndView("sys/biz_material_list", map);
	}
	
	@RequestMapping(value = "new")
	public ModelAndView newMaterial(@ModelAttribute BizMaterial bizMaterial) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//获取属性选项
		List<SysConstant> materialCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CATEGORY);
		List<SysConstant> materialClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CLASS);
		List<SysConstant> materialType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_TYPE);
		//设置request
		map.put("materialCategory", materialCategory);
		map.put("materialClass", materialClass);
		map.put("materialType", materialType);
		
		return new ModelAndView("sys/biz_material_new", map);
	}

	@RequestMapping(value = "save")
	public ModelAndView saveMaterial(@ModelAttribute @Valid BizMaterial bizMaterial, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		if(result.hasErrors()){	
			//获取属性选项
			List<SysConstant> materialCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CATEGORY);
			List<SysConstant> materialClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CLASS);
			List<SysConstant> materialType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_TYPE);
			//设置request
			map.put("materialCategory", materialCategory);
			map.put("materialClass", materialClass);
			map.put("materialType", materialType);
			map.put("bizMaterial", bizMaterial);
			
			return new ModelAndView("sys/biz_material_new", map);
		}
		//
		boolean isExistsMaterialName = this.bizCourseMaterialService.checkMaterialName(bizMaterial.getMaterialName());
		boolean isExistsMaterialCode = this.bizCourseMaterialService.checkMaterialCode(bizMaterial.getMaterialCode());
		if(isExistsMaterialName || isExistsMaterialCode  ){
			//获取属性选项
			List<SysConstant> materialCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CATEGORY);
			List<SysConstant> materialClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CLASS);
			List<SysConstant> materialType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_TYPE);
			//设置request
			map.put("materialCategory", materialCategory);
			map.put("materialClass", materialClass);
			map.put("materialType", materialType);
			map.put("bizMaterial", bizMaterial);
			if(isExistsMaterialName){
				FieldError error = new FieldError("bizMaterial","materialName","资料编号已存在！");
				result.addError(error);
			}
			if(isExistsMaterialCode){
				FieldError error = new FieldError("bizMaterial","materialCode","资料名称已存在！");
				result.addError(error);
			}

			return new ModelAndView("sys/biz_material_new", map);
		}
		//
		bizMaterial.setIsValid(EntityConstants.IS_VALILD_1);
		this.bizCourseMaterialService.insertMaterial(bizMaterial);
		//
		map.put("success_msg", "资料创建成功！");
		//
		return new ModelAndView("sys/biz_material_success", map);
	}
	
	@RequestMapping(value = "edit")
	public ModelAndView editMaterial(Integer materialId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//获取属性选项
		List<SysConstant> materialCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CATEGORY);
		List<SysConstant> materialClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CLASS);
		List<SysConstant> materialType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_TYPE);
		//设置request
		map.put("materialCategory", materialCategory);
		map.put("materialClass", materialClass);
		map.put("materialType", materialType);
		//
		BizMaterial bizMaterial = this.bizCourseMaterialService.selectMaterialById(materialId);
		map.put("bizMaterial", bizMaterial);
		
		return new ModelAndView("sys/biz_material_edit", map);
	}


	@RequestMapping(value = "update")
	public ModelAndView updateMaterial(@ModelAttribute @Valid BizMaterial bizMaterial, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		//
		if(result.hasErrors()){	
			//获取属性选项
			List<SysConstant> materialCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CATEGORY);
			List<SysConstant> materialClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CLASS);
			List<SysConstant> materialType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_TYPE);
			//设置request
			map.put("materialCategory", materialCategory);
			map.put("materialClass", materialClass);
			map.put("materialType", materialType);
			map.put("bizMaterial", bizMaterial);
			
			return new ModelAndView("sys/biz_material_new", map);
		}
		//
		BizMaterial existsMaterialByName = this.bizCourseMaterialService.selectMaterialByName(bizMaterial.getMaterialName());
		BizMaterial existsMaterialByCode = this.bizCourseMaterialService.selectMaterialByCode(bizMaterial.getMaterialCode());
		boolean isExistsMaterialName = false;
		boolean isExistsMaterialCode = false;
		if(existsMaterialByName != null && 
				existsMaterialByName.getMaterialId().intValue() != bizMaterial.getMaterialId()) {
			isExistsMaterialName = true;
		}
		if(existsMaterialByCode != null &&
				existsMaterialByCode.getMaterialId().intValue() != bizMaterial.getMaterialId()) {
			isExistsMaterialCode = true;
		}
		if(isExistsMaterialName || isExistsMaterialCode  ){
			//获取属性选项
			List<SysConstant> materialCategory=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CATEGORY);
			List<SysConstant> materialClass=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_CLASS);
			List<SysConstant> materialType=SysCache.getInstance().CONSTANT_ATTR_OPTION_MAP.get(EntityConstants.ENTITY_MATERIAL_TYPE);
			//设置request
			map.put("materialCategory", materialCategory);
			map.put("materialClass", materialClass);
			map.put("materialType", materialType);
			map.put("bizMaterial", bizMaterial);
			if(isExistsMaterialName){
				FieldError error = new FieldError("bizMaterial","materialName","资料编号已存在！");
				result.addError(error);
			}
			if(isExistsMaterialCode){
				FieldError error = new FieldError("bizMaterial","materialCode","资料名称已存在！");
				result.addError(error);
			}

			return new ModelAndView("sys/biz_material_new", map);
		}
		//
		this.bizCourseMaterialService.insertMaterial(bizMaterial);
		//
		map.put("success_msg", "资料修改成功！");
		//
		return new ModelAndView("sys/biz_material_success", map);
	}	
}