
package org.wmichina.crm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Controller;
import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.entity.SysRegion;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.SysCache;
import org.wmichina.crm.service.SysDefaultService;

@Controller
@RemoteProxy(name = "defaultController")
public class DwrDefaultController {

	@Resource(name = "sysDefaultService")
	private SysDefaultService sysDefaultService;

	@RemoteMethod
	public String getRegionsByParentCode(String regionCode, Integer childLevel) {
		if(childLevel==null) return "";
		if(regionCode==null || regionCode.equals("")) return "";
		//
		//List<SysRegion> regions = this.sysDefaultService.findRegionsByParentCode(regionCode);
		List<SysRegion> regions = new ArrayList<SysRegion>();
		regions.addAll(SysCache.getInstance().REGION_PROVINCE_BYCODE.values());
		
		StringBuilder builder = new StringBuilder();
		if(childLevel==EntityConstants.REGION_LEVEL_PROVINCE){
			builder.append("<option value=\"\">请选择省...</option>\n");
		}else if(childLevel==EntityConstants.REGION_LEVEL_CITY){
			builder.append("<option value=\"\">请选择市...</option>\n");
		}else if(childLevel==EntityConstants.REGION_LEVEL_COUNTY){
			builder.append("<option value=\"\">请选择区/县...</option>\n");
		}
		for(SysRegion region:regions){
			builder.append("<option value=\"");
			builder.append(region.getRegionCode()).append("\">");
			builder.append(region.getRegionName());
			builder.append("</option>\n");
		}
		return builder.toString();
	}

	
	/**
	 * 根据学员信息的其他联系的选项集合
	 * @return
	 */
	@RemoteMethod
	public String getAttrContactOthers() {;
		//
		List<SysConstant> constants = this.sysDefaultService.findConstantsByParentCode(EntityConstants.ENTITY_STUDENT_OTCONTACTS);
		StringBuilder builder = new StringBuilder();

		for(SysConstant constant:constants){
			builder.append("<option value=\"");
			builder.append(constant.getConstantCode()).append("\">");
			builder.append(constant.getConstantName());
			builder.append("</option>\n");
		}
		return builder.toString();
	}
	
	/**
	 * 根据实体编号获取该实体的属性集合
	 * @param entityCode
	 * @return
	 */
	@RemoteMethod
	public String getAttrByEntityCode(String entityCode) {
		System.out.println("Try to get attributes.....");
		//
		List<SysConstant> constants = this.sysDefaultService.findConstantsByParentCode(entityCode);
		StringBuilder builder = new StringBuilder();

		for(SysConstant constant:constants){
			builder.append("<option value=\"");
			builder.append(constant.getConstantCode()).append("\">");
			builder.append(constant.getConstantName());
			builder.append("</option>\n");
		}
		System.out.println("Got attributes: " + builder.toString());
		return builder.toString();
	}
}