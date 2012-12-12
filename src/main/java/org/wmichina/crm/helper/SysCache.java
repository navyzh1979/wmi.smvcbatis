package org.wmichina.crm.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.entity.SysRegion;
import org.wmichina.crm.entity.SysRight;
import org.wmichina.crm.entity.SysRole;
import org.wmichina.crm.service.SysDefaultService;
import org.wmichina.crm.service.SysRoleUserService;

public class SysCache{
	//权限相关
	public final Map<Integer, SysRight> RIGHTS_BY_ID = new HashMap<Integer, SysRight>();
	public final Map<Integer, SysRight> RIGHTS_BY_ID_BRANCH = new HashMap<Integer, SysRight>();
	public final Map<Integer, SysRight> RIGHTS_BY_ID_NODE = new HashMap<Integer, SysRight>();
	public final Map<Integer, SysRight> RIGHTS_BY_ID_LEAF = new HashMap<Integer, SysRight>();
	public final Map<String, SysRight> RIGHTS_BY_CODE = new HashMap<String, SysRight>();
	public final Map<String, SysRight> RIGHTS_BY_CODE_BRANCH = new HashMap<String, SysRight>();
	public final Map<String, SysRight> RIGHTS_BY_CODE_NODE = new HashMap<String, SysRight>();
	public final Map<String, SysRight> RIGHTS_BY_CODE_LEAF = new HashMap<String, SysRight>();
	//
	public final Map<Integer, SysRole> ROLES_BY_ID = new HashMap<Integer, SysRole>();
	//地区相关
	public final Map<String, SysRegion> ALL_REGIONS = new HashMap<String, SysRegion>();
	public final Map<String, SysRegion> REGION_NATION_BYCODE = new HashMap<String, SysRegion>();
	public final Map<String, SysRegion> REGION_NATION_BYNAME = new HashMap<String, SysRegion>();
	public final Map<String, SysRegion> REGION_PROVINCE_BYCODE = new HashMap<String, SysRegion>();
	public final Map<String, SysRegion> REGION_PROVINCE_BYNAME = new HashMap<String, SysRegion>();
	public final Map<String, List<SysRegion>> REGION_PROVINCE_CITY = new HashMap<String, List<SysRegion>>();
	public final Map<String, SysRegion> REGION_CITY = new HashMap<String, SysRegion>();
	public final Map<String, List<SysRegion>> REGION_CITY_COUNTY = new HashMap<String, List<SysRegion>>();
	public final Map<String, SysRegion> REGION_COUNTY = new HashMap<String, SysRegion>();
	//业务实体选项
	public final Map<String, List<SysConstant>> CONSTANT_ENTITY_ATTR_MAP = new HashMap<String, List<SysConstant>>();
	public final Map<String, SysConstant> CONSTANT_ENTITY_MAP = new HashMap<String, SysConstant>();
	public final Map<String, SysConstant> CONSTANT_ATTR_MAP = new HashMap<String, SysConstant>();
	public final Map<String, List<SysConstant>> CONSTANT_ATTR_OPTION_MAP = new HashMap<String, List<SysConstant>>();
	public final Map<String, SysConstant> CONSTANT_OPTION_MAP = new HashMap<String, SysConstant>();
	
	public static boolean hasInitialized = false;
	
	static class SingletonHolder {
		static SysCache instance = new SysCache();
	}

	public static SysCache getInstance() {
		return SingletonHolder.instance;
	}
	
	public void initCache(SysRoleUserService sysRoleUserService, SysDefaultService sysDefaultService){
		if(hasInitialized) return;
		// Load Rights
		System.out.println(" Loading rights  from DB ......");
		List<SysRight> rights = sysRoleUserService.findRights();
		System.out.println(" Loaded rights : " + rights.size());
		System.out.println(" Try to fill various types of right maps ...... " );
		for(SysRight right : rights){
			RIGHTS_BY_ID.put(right.getRightId(), right);
			RIGHTS_BY_CODE.put(right.getRightCode(), right);
			if(right.getRightLevel() == EntityConstants.RIGHT_LEVEL_BRANCH){
				RIGHTS_BY_ID_BRANCH.put(right.getRightId(), right);
				RIGHTS_BY_CODE_BRANCH.put(right.getRightCode(), right);
			}else if(right.getRightLevel() == EntityConstants.RIGHT_LEVEL_NODE){
				RIGHTS_BY_ID_NODE.put(right.getRightId(), right);
				RIGHTS_BY_CODE_NODE.put(right.getRightCode(), right);
			}else if(right.getRightLevel() == EntityConstants.RIGHT_LEVEL_LEAF){
				RIGHTS_BY_ID_LEAF.put(right.getRightId(), right);
				RIGHTS_BY_CODE_LEAF.put(right.getRightCode(), right);
			}
		}
		System.out.println(" Finished filling various types of right maps ...... " );
		System.out.println(" RIGHTS_BY_ID's size : " + RIGHTS_BY_ID.size() );
		System.out.println(" RIGHTS_BY_CODE's  size : " + RIGHTS_BY_CODE.size() );
		System.out.println(" RIGHTS_BY_ID_BRANCH's size : " + RIGHTS_BY_ID.size() );
		System.out.println(" RIGHTS_BY_CODE_BRANCH's size : " + RIGHTS_BY_ID.size() );
		System.out.println(" RIGHTS_BY_ID_NODE's size : " + RIGHTS_BY_ID.size() );
		System.out.println(" RIGHTS_BY_CODE_NODE's size : " + RIGHTS_BY_ID.size() );
		System.out.println(" RIGHTS_BY_ID_LEAF's size : " + RIGHTS_BY_ID.size() );
		System.out.println(" RIGHTS_BY_CODE_LEAF's size : " + RIGHTS_BY_ID.size() );
		
		//Load Roles
		System.out.println(" Loading roles  from DB ......");
		List<SysRole> roles = sysRoleUserService.findRoles();
		System.out.println(" Loaded roles : " + roles.size());
		System.out.println(" Try to fill ROLES_BY_ID map ...... " );
		for(SysRole role : roles){
			ROLES_BY_ID.put(role.getRoleId(), role);
		}
		System.out.println(" Finished filling ROLES_BY_ID map : " +ROLES_BY_ID.size() );
		
		//Load Regions
		System.out.println(" Loading regions  from DB ......");
		List<SysRegion> regions = sysDefaultService.findRegions();
		System.out.println(" Loaded regions : " + regions.size());
		System.out.println(" Try to fill various types of region maps ...... " );
		for(SysRegion region : regions){
			ALL_REGIONS.put(region.getRegionCode(), region);
			if(region.getRegionLevel() == EntityConstants.REGION_LEVEL_PROVINCE){
				REGION_PROVINCE_BYCODE.put(region.getRegionCode(), region);
				REGION_PROVINCE_BYNAME.put(region.getRegionName(), region);
			}else if(region.getRegionLevel() == EntityConstants.REGION_LEVEL_CITY){
				REGION_CITY.put(region.getRegionCode(), region);
				//
				List<SysRegion> cities = REGION_PROVINCE_CITY.get(region.getParentCode());
				if(cities == null) cities = new ArrayList<SysRegion>();
				cities.add(region);
				REGION_PROVINCE_CITY.put(region.getParentCode(), cities);
			}else if(region.getRegionLevel() == EntityConstants.REGION_LEVEL_COUNTY){
				REGION_COUNTY.put(region.getRegionCode(), region);
				//
				List<SysRegion> counties = REGION_CITY_COUNTY.get(region.getParentCode());
				if(counties == null) counties = new ArrayList<SysRegion>();
				counties.add(region);
				REGION_CITY_COUNTY.put(region.getParentCode(), counties);
			}else if(region.getRegionLevel() == EntityConstants.REGION_LEVEL_NATION){
				REGION_NATION_BYCODE.put(region.getRegionCode(), region);
				REGION_NATION_BYNAME.put(region.getRegionName(), region);
			}else {
				System.out.println(" unkow regionLevel: " + region.getRegionLevel() +", region:" + new JSONObject(region).toString());
			}
		}
		System.out.println(" Finished filling various types of region maps ...... " );
		System.out.println(" ALL_REGIONS's size : " + ALL_REGIONS.size() );
		System.out.println(" REGION_NATION's size : " + REGION_NATION_BYCODE.size() );
		System.out.println(" REGION_PROVINCE's  size : " + REGION_PROVINCE_BYNAME.size() );
		System.out.println(" REGION_PROVINCE_CITY's size : " + REGION_PROVINCE_CITY.size() );
		System.out.println(" REGION_CITY's size : " + REGION_CITY.size() );
		System.out.println(" REGION_CITY_COUNTY's size : " + REGION_CITY_COUNTY.size() );
		System.out.println(" REGION_COUNTY's size : " + REGION_COUNTY.size() );
		
		//Load Constants
		System.out.println(" Loading regions  from DB ......");
		List<SysConstant> constants = sysDefaultService.findConstants();
		System.out.println(" Loaded constants : " + regions.size());
		System.out.println(" Try to fill various types of constant maps ...... " );
		for(SysConstant constant : constants){
			if(constant.getConstantLevel() == EntityConstants.CONSTANT_LEVEL_ENTITY){
				CONSTANT_ENTITY_MAP.put(constant.getConstantCode(), constant);
			}else if(constant.getConstantLevel() == EntityConstants.CONSTANT_LEVEL_ATTRIBUTE){
				CONSTANT_ATTR_MAP.put(constant.getConstantCode(), constant);
				//
				List<SysConstant> attrs = CONSTANT_ENTITY_ATTR_MAP.get(constant.getParentCode());
				if(attrs == null) attrs = new ArrayList<SysConstant>();
				attrs.add(constant);
				CONSTANT_ENTITY_ATTR_MAP.put(constant.getParentCode(), attrs);
			}else if(constant.getConstantLevel() == EntityConstants.CONSTANT_LEVEL_OPTION){
				CONSTANT_OPTION_MAP.put(constant.getConstantCode(), constant);
				//
				List<SysConstant> options = CONSTANT_ATTR_OPTION_MAP.get(constant.getParentCode());
				if(options == null) options = new ArrayList<SysConstant>();
				options.add(constant);
				CONSTANT_ATTR_OPTION_MAP.put(constant.getParentCode(), options);
			}else {
				System.out.println(" unkow constantLevel: " + constant.getConstantLevel() +", constant:" + new JSONObject(constant).toString());
			}
		}
		System.out.println(" Finished filling various types of constant maps ...... " );
		System.out.println(" CONSTANT_ENTITY_MAP's size : " + CONSTANT_ENTITY_MAP.size() );
		System.out.println(" CONSTANT_ENTITY_ATTR_MAP's size : " + CONSTANT_ENTITY_ATTR_MAP.size() );
		System.out.println(" CONSTANT_ATTR_MAP's  size : " + CONSTANT_ATTR_MAP.size() );
		System.out.println(" CONSTANT_ATTR_OPTION_MAP's size : " + CONSTANT_ATTR_OPTION_MAP.size() );
		System.out.println(" CONSTANT_OPTION_MAP : " + CONSTANT_OPTION_MAP.size() );
		
		hasInitialized = true;
	}
}
