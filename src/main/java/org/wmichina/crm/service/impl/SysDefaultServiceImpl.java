package org.wmichina.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.entity.SysConstantOption;
import org.wmichina.crm.entity.SysRegion;
import org.wmichina.crm.entity.example.SysConstantExample;
import org.wmichina.crm.entity.example.SysRegionExample;
import org.wmichina.crm.entity.example.SysRegionExample.Criteria;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.mapper.SysConstantMapper;
import org.wmichina.crm.mapper.SysRegionMapper;
import org.wmichina.crm.service.SysDefaultService;

@Repository(value="sysDefaultService")
@Transactional
public class SysDefaultServiceImpl implements SysDefaultService {

	@Resource(name="sysConstantMapper")
	private SysConstantMapper sysConstantMapper;
	@Resource(name="sysRegionMapper")
	private SysRegionMapper regionMapper;
	
	@Override
	public List<SysRegion> findRegions() {
		SysRegionExample example = new SysRegionExample();
		return this.regionMapper.selectByExample(example);
	}

	@Override
	public List<SysRegion> findRegionsByLevel(int level) {
		SysRegionExample example = new SysRegionExample();
		Criteria queryCondition = example.createCriteria();
		
		queryCondition.andRegionLevelEqualTo(level);
		queryCondition.andIsValidEqualTo(EntityConstants.IS_VALILD_1);
				
		return this.regionMapper.selectByExample(example);
	}

	@Override
	public List<SysRegion> findRegionsByParentCode(String parentCode) {
		SysRegionExample example = new SysRegionExample();
		Criteria queryCondition = example.createCriteria();
		
		queryCondition.andParentCodeEqualTo(parentCode);
		queryCondition.andIsValidEqualTo(EntityConstants.IS_VALILD_1);
				
		return this.regionMapper.selectByExample(example);
	}

	@Override
	public SysRegion selectOneRegion(String regionCode) {
		SysRegionExample example = new SysRegionExample();
		Criteria queryCondition = example.createCriteria();
		
		queryCondition.andRegionCodeEqualTo(regionCode);
		queryCondition.andIsValidEqualTo(EntityConstants.IS_VALILD_1);

		List<SysRegion> regions = this.regionMapper.selectByExample(example);
		if(regions!=null && regions.size()==1){
			return regions.get(0);
		}else {
			return null;
		}
		
	}


	/**
	 * Operations on SysConstant 
	 */
	
	@Override
	public List<SysConstant> findConstants() {
		return this.sysConstantMapper.loadConstants();
	}

	@Override
	public List<SysConstant> findConstantsByLevel(int level) {
		return this.sysConstantMapper.queryByLevel(level);
	}
	
	@Override
	public List<SysConstant> findConstantsByParentCode(String parentCode) {
		return this.sysConstantMapper.queryByParentCode(parentCode);
	}

	@Override
	public SysConstant selectOneConstant(String constantCode) {
		return this.sysConstantMapper.selectOneConstant(constantCode);
	}

	@Override
	public boolean checkOption(SysConstantOption sysOption) {
		SysConstantExample example = new SysConstantExample();
		SysConstantExample.Criteria query = example.createCriteria();
		query.andConstantNameEqualTo(sysOption.getOptionName());
		query.andParentCodeEqualTo(sysOption.getAttrCode());
		
		List<SysConstant> result = this.sysConstantMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public void insertOneConstant(SysConstant constant) {
		String maxCode = this.sysConstantMapper.getMaxCode(constant.getParentCode());
		if(maxCode == null) maxCode=constant.getParentCode();
		//自动生成ConstantCode
		constant.setConstantCode(nextCode(maxCode,constant.getConstantLevel()));
		//
		this.sysConstantMapper.insertOneConstant(constant);
	}

	@Override
	public ResultPageBuilder<SysConstantOption> findConstantsByPage(SysConstant constant, int currentPage) {
		SysConstantExample example = new SysConstantExample();
		SysConstantExample.Criteria queryCondition = example.createCriteria();
		queryCondition.andConstantLevelEqualTo(EntityConstants.CONSTANT_LEVEL_OPTION);
		queryCondition.andIsValidEqualTo(EntityConstants.IS_VALILD_1);
		//
		int allRows = this.sysConstantMapper.countByExample(example);
		//
		ResultPageBuilder<SysConstantOption> pageBuilder = new ResultPageBuilder<SysConstantOption>(allRows, EntityConstants.PAGE_SIZE, currentPage);
		//
		List<SysConstantOption> rights = this.sysConstantMapper.loadOptions(pageBuilder.getStart(), pageBuilder.getEnd());
		//
		pageBuilder.setResultSet(rights);
		
		return pageBuilder;
	}

	@Override
	public void updateConstant(SysConstant constant) {
		this.sysConstantMapper.updateByPrimaryKeySelective(constant);
	}
	/**
	 * Generate next constant_code by maxCode and constant_level.
	 * @param maxCode  Must be 6-bit integer.
	 * @param level
	 * @return
	 */
	private String nextCode(String maxCode,int level){
		int code_s1 = Character.getNumericValue(maxCode.charAt(0));
		int code_s2 = Character.getNumericValue(maxCode.charAt(1));
		int code_s3 = Character.getNumericValue(maxCode.charAt(2));
		int code_s4 = Character.getNumericValue(maxCode.charAt(3));
		int code_s5 = Character.getNumericValue(maxCode.charAt(4));
		int code_s6 = Character.getNumericValue(maxCode.charAt(5));
		
		if(level==EntityConstants.CONSTANT_LEVEL_ENTITY){
			return new StringBuilder().append(nextIncreSEQ(code_s1,code_s2))
					.append(code_s3)
					.append(code_s4)
					.append(code_s5)
					.append(code_s6).toString();
		}else if(level==EntityConstants.CONSTANT_LEVEL_ATTRIBUTE){
			return new StringBuilder().append(code_s1)
					.append(code_s2)
					.append(nextIncreSEQ(code_s3,code_s4))
					.append(code_s5)
					.append(code_s6).toString();
		}else if(level==EntityConstants.CONSTANT_LEVEL_OPTION){
			return new StringBuilder().append(code_s1)
					.append(code_s2)
					.append(code_s3)
					.append(code_s4)
					.append(nextIncreSEQ(code_s5,code_s6)).toString();
		} 
		
		return maxCode;
	}
	
	/**
	 * 按照规则生成新的序列数(10-99), 序列如下：
	 * 10,20,30,40,50,60,70,80,90,11,21,31,41,51,61,71,81,91,12,22,32,42, ...... 99
	 * @param high
	 * @param low
	 * @return
	 */
	private String nextIncreSEQ(int high, int low ){
		boolean incre_low=false;
		if(high==9){
			high=1;
			incre_low=true;
		}else if( high>=0 && high<=8){
			high+=1;
		}
		if(incre_low){
			if(low==9){
				low=0;
			}else if( low>=0 && low<=8){
				low+=1;
			}
		}
		
		return high+""+low;
	}

}
