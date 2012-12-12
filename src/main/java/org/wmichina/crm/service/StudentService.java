package org.wmichina.crm.service;

import java.util.List;

import org.wmichina.crm.entity.Student;
import org.wmichina.crm.helper.ResultPageBuilder;

public interface StudentService {
	
	List<Student> findStudents();
	ResultPageBuilder<Student> findStudentsByPage(Student student, int currentPage);
	Student selectOneStudent(long studentId);
	public boolean isStudentNoExists(String studentNo);
	public boolean isEmailExists(String email);
	public boolean isMobileExists(String mobile);
	public boolean isMobileStandbyExists(String mobile);
	public boolean isEmailStandbyExists(String email);
	void createStudent(Student student);
	void updateStudent(Student student);
	
}
