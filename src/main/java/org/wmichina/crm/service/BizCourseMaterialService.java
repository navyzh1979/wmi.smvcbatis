package org.wmichina.crm.service;

import java.util.List;

import org.wmichina.crm.entity.BizCourse;
import org.wmichina.crm.entity.BizMaterial;
import org.wmichina.crm.helper.ResultPageBuilder;

public interface BizCourseMaterialService {
    /** BizCourse **/
	List<BizCourse> findCourses();
	boolean checkCourseCode(String courseCode);
	boolean checkCourseName(String courseName);
	BizCourse selectCourseByCode(String courseCode);
	BizCourse selectCourseByName(String courseName);
	BizCourse selectCourseById(Integer courseId);
	void insertCourse(BizCourse course);
	void updateCourse(BizCourse course);
	ResultPageBuilder<BizCourse> findCoursesByPage(BizCourse course, int currentPage);

    /** BizMaterial **/
	List<BizMaterial> findMaterials();
	boolean checkMaterialCode(String materialCode);
	boolean checkMaterialName(String materialName);
	BizMaterial selectMaterialByCode(String materialCode);
	BizMaterial selectMaterialByName(String materialName);
	BizMaterial selectMaterialById(Integer materialId);
	void insertMaterial(BizMaterial material);
	void updateMaterial(BizMaterial material);
	ResultPageBuilder<BizMaterial> findMaterialsByPage(BizMaterial material, int currentPage);

}
