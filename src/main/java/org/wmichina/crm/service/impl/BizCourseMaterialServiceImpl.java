package org.wmichina.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.wmichina.crm.entity.BizCourse;
import org.wmichina.crm.entity.BizMaterial;
import org.wmichina.crm.entity.example.BizCourseExample;
import org.wmichina.crm.entity.example.BizMaterialExample;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.mapper.BizCourseMapper;
import org.wmichina.crm.mapper.BizMaterialMapper;
import org.wmichina.crm.service.BizCourseMaterialService;

@Repository(value="bizCourseMaterialService")
@Transactional
public class BizCourseMaterialServiceImpl implements BizCourseMaterialService {
	@Resource(name="bizCourseMapper")
	private BizCourseMapper bizCourseMapper;
	@Resource(name="bizMaterialMapper")
	private BizMaterialMapper bizMaterialMapper;
	
	/**
	 * BizCourse
	 */
	
	@Override
	public List<BizCourse> findCourses() {
		BizCourseExample example = new BizCourseExample();
		return this.bizCourseMapper.selectByExample(example);
	}

	@Override
	public boolean checkCourseCode(String courseCode) {
		BizCourseExample example = new BizCourseExample();
		BizCourseExample.Criteria query = example.createCriteria();
		query.andCourseCodeEqualTo(courseCode);
		
		List<BizCourse> result = this.bizCourseMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public boolean checkCourseName(String courseName) {
		BizCourseExample example = new BizCourseExample();
		BizCourseExample.Criteria query = example.createCriteria();
		query.andCourseNameEqualTo(courseName);
		
		List<BizCourse> result = this.bizCourseMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public BizCourse selectCourseByCode(String courseCode) {
		BizCourseExample example = new BizCourseExample();
		BizCourseExample.Criteria query = example.createCriteria();
		query.andCourseCodeEqualTo(courseCode);
		
		List<BizCourse> result = this.bizCourseMapper.selectByExample(example);

		if(result!=null && result.size()>0){
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public BizCourse selectCourseByName(String courseName) {
		BizCourseExample example = new BizCourseExample();
		BizCourseExample.Criteria query = example.createCriteria();
		query.andCourseNameEqualTo(courseName);
		
		List<BizCourse> result = this.bizCourseMapper.selectByExample(example);

		if(result!=null && result.size()>0){
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public BizCourse selectCourseById(Integer courseId) {
		if(courseId == null ) return null;
		return this.bizCourseMapper.selectByPrimaryKey(courseId);
	}

	@Override
	public void insertCourse(BizCourse course) {
		this.bizCourseMapper.insertSelective(course);
	}

	@Override
	public void updateCourse(BizCourse course) {
		this.bizCourseMapper.updateByPrimaryKeySelective(course);
	}

	@Override
	public ResultPageBuilder<BizCourse> findCoursesByPage(BizCourse course, int currentPage) {
		BizCourseExample example = new BizCourseExample();
		int allRows = this.bizCourseMapper.countByExample(example);
		//
		ResultPageBuilder<BizCourse> pageBuilder = new ResultPageBuilder<BizCourse>(allRows, EntityConstants.PAGE_SIZE, currentPage);
		//
		example.setStart(pageBuilder.getStart());
		example.setStart(pageBuilder.getEnd());
		List<BizCourse> jobs = this.bizCourseMapper.selectByExample(example);
		//
		pageBuilder.setResultSet(jobs);
		
		return pageBuilder;
	}

	/**
	 * BizMaterial
	 */
	
	@Override
	public List<BizMaterial> findMaterials() {
		BizMaterialExample example = new BizMaterialExample();
		return this.bizMaterialMapper.selectByExample(example);
	}

	@Override
	public boolean checkMaterialCode(String materialCode) {
		BizMaterialExample example = new BizMaterialExample();
		BizMaterialExample.Criteria query = example.createCriteria();
		query.andMaterialCodeEqualTo(materialCode);
		
		List<BizMaterial> result = this.bizMaterialMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public boolean checkMaterialName(String materialName) {
		BizMaterialExample example = new BizMaterialExample();
		BizMaterialExample.Criteria query = example.createCriteria();
		query.andMaterialNameEqualTo(materialName);
		
		List<BizMaterial> result = this.bizMaterialMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public BizMaterial selectMaterialByCode(String materialCode) {
		BizMaterialExample example = new BizMaterialExample();
		BizMaterialExample.Criteria query = example.createCriteria();
		query.andMaterialCodeEqualTo(materialCode);
		
		List<BizMaterial> result = this.bizMaterialMapper.selectByExample(example);

		if(result!=null && result.size()>0){
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public BizMaterial selectMaterialByName(String materialName) {
		BizMaterialExample example = new BizMaterialExample();
		BizMaterialExample.Criteria query = example.createCriteria();
		query.andMaterialNameEqualTo(materialName);
		
		List<BizMaterial> result = this.bizMaterialMapper.selectByExample(example);

		if(result!=null && result.size()>0){
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public BizMaterial selectMaterialById(Integer materialId) {
		if(materialId == null ) return null;
		return this.bizMaterialMapper.selectByPrimaryKey(materialId);
	}

	@Override
	public void insertMaterial(BizMaterial material) {
		this.bizMaterialMapper.insertSelective(material);
	}

	@Override
	public void updateMaterial(BizMaterial material) {
		this.bizMaterialMapper.updateByPrimaryKeySelective(material);
	}

	@Override
	public ResultPageBuilder<BizMaterial> findMaterialsByPage(BizMaterial material, int currentPage) {
		BizMaterialExample example = new BizMaterialExample();
		int allRows = this.bizMaterialMapper.countByExample(example);
		//
		ResultPageBuilder<BizMaterial> pageBuilder = new ResultPageBuilder<BizMaterial>(allRows, EntityConstants.PAGE_SIZE, currentPage);
		//
		example.setStart(pageBuilder.getStart());
		example.setStart(pageBuilder.getEnd());
		List<BizMaterial> jobs = this.bizMaterialMapper.selectByExample(example);
		//
		pageBuilder.setResultSet(jobs);
		
		return pageBuilder;
	}

}
