package org.wmichina.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.wmichina.crm.entity.Student;
import org.wmichina.crm.entity.example.StudentExample;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.mapper.StudentMapper;
import org.wmichina.crm.service.StudentService;

@Repository(value="studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

	@Resource(name="studentMapper")
	private StudentMapper studentMapper;
	
	@Override
	public List<Student> findStudents() {
		return studentMapper.selectByExample(null);
	}

	@Override
	public ResultPageBuilder<Student> findStudentsByPage(Student student, int currentPage) {
		StudentExample example = new StudentExample();
		int allRows = this.studentMapper.countByExample(example);
		//
		ResultPageBuilder<Student> pageBuilder = new ResultPageBuilder<Student>(allRows, EntityConstants.PAGE_SIZE, currentPage);
		//
		example.setStart(pageBuilder.getStart());
		example.setStart(pageBuilder.getEnd());
		List<Student> users = this.studentMapper.selectByExample(example);
		
		pageBuilder.setResultSet(users);
		
		return pageBuilder;
	}

	@Override
	public Student selectOneStudent(long studentId) {
		// TODO Auto-generated method stub
		return this.studentMapper.selectByPrimaryKey(studentId);
	}

	@Override
	public boolean isStudentNoExists(String studentNo) {
		StudentExample example = new StudentExample();
		StudentExample.Criteria query = example.createCriteria();
		query.andStudentNoEqualTo(studentNo);
		
		List<Student> result = this.studentMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public boolean isEmailExists(String email) {
		StudentExample example = new StudentExample();
		StudentExample.Criteria query = example.createCriteria();
		query.andEmailEqualTo(email);
		
		List<Student> result = this.studentMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public boolean isMobileExists(String mobile) {
		StudentExample example = new StudentExample();
		StudentExample.Criteria query = example.createCriteria();
		query.andMobileEqualTo(mobile);
		
		List<Student> result = this.studentMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public boolean isMobileStandbyExists(String mobile) {
		StudentExample example = new StudentExample();
		StudentExample.Criteria query = example.createCriteria();
		query.andMobileStandbyEqualTo(mobile);
		
		List<Student> result = this.studentMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public boolean isEmailStandbyExists(String email) {
		StudentExample example = new StudentExample();
		StudentExample.Criteria query = example.createCriteria();
		query.andEmailStandbyEqualTo(email);
		
		List<Student> result = this.studentMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public void createStudent(Student student) {
		this.studentMapper.insertSelective(student);
	}

	@Override
	public void updateStudent(Student student) {
		this.studentMapper.updateByPrimaryKeySelective(student);
	}


}
