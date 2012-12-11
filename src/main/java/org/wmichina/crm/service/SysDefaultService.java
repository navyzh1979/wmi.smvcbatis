package org.wmichina.crm.service;

import java.util.List;

import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.entity.SysConstantOption;
import org.wmichina.crm.entity.SysRegion;
import org.wmichina.crm.helper.ResultPageBuilder;

public interface SysDefaultService {
    /** SysRegion **/
	List<SysRegion> findRegions();
	List<SysRegion> findRegionsByLevel(int level);
	List<SysRegion> findRegionsByParentCode(String parentCode);
	SysRegion selectOneRegion(String regionCode);
	
	/** SysConstant **/
	List<SysConstant> findConstants();
	List<SysConstant> findConstantsByLevel(int level);
	List<SysConstant> findConstantsByParentCode(String parentCode);
	boolean checkOption(SysConstantOption sysOption);
	SysConstant selectOneConstant(String constantCode);
	void insertOneConstant(SysConstant constant);
	ResultPageBuilder<SysConstantOption> findConstantsByPage(SysConstant constant, int currentPage);
	void updateConstant(SysConstant constant);
}
