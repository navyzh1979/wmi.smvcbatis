package org.wmichina.crm.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;
import java.util.Map;

import org.wmichina.crm.entity.Student;
import org.wmichina.crm.entity.example.StudentExample;
import org.wmichina.crm.entity.example.StudentExample.Criteria;
import org.wmichina.crm.entity.example.StudentExample.Criterion;

public class StudentSqlProvider {

    public String countByExample(StudentExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("student");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(StudentExample example) {
        BEGIN();
        DELETE_FROM("student");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Student record) {
        BEGIN();
        INSERT_INTO("student");
        
        if (record.getStudentId() != null) {
            VALUES("student_id", "#{studentId,jdbcType=BIGINT}");
        }
        
        if (record.getStudentNo() != null) {
            VALUES("student_no", "#{studentNo,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentType() != null) {
            VALUES("student_type", "#{studentType,jdbcType=BIT}");
        }
        
        if (record.getStudentLevel() != null) {
            VALUES("student_level", "#{studentLevel,jdbcType=BIT}");
        }
        
        if (record.getMemberLevel() != null) {
            VALUES("member_level", "#{memberLevel,jdbcType=BIT}");
        }
        
        if (record.getStudentStatus() != null) {
            VALUES("student_status", "#{studentStatus,jdbcType=CHAR}");
        }
        
        if (record.getIsValid() != null) {
            VALUES("is_valid", "#{isValid,jdbcType=BIT}");
        }
        
        if (record.getSex() != null) {
            VALUES("sex", "#{sex,jdbcType=BIT}");
        }
        
        if (record.getBirthday() != null) {
            VALUES("birthday", "#{birthday,jdbcType=DATE}");
        }
        
        if (record.getNation() != null) {
            VALUES("nation", "#{nation,jdbcType=CHAR}");
        }
        
        if (record.getProvince() != null) {
            VALUES("province", "#{province,jdbcType=CHAR}");
        }
        
        if (record.getCity() != null) {
            VALUES("city", "#{city,jdbcType=CHAR}");
        }
        
        if (record.getArea() != null) {
            VALUES("area", "#{area,jdbcType=CHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getPostcode() != null) {
            VALUES("postcode", "#{postcode,jdbcType=VARCHAR}");
        }
        
        if (record.getTelphone() != null) {
            VALUES("telphone", "#{telphone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmailStandby() != null) {
            VALUES("email_standby", "#{emailStandby,jdbcType=VARCHAR}");
        }
        
        if (record.getMobileStandby() != null) {
            VALUES("mobile_standby", "#{mobileStandby,jdbcType=VARCHAR}");
        }
        
        if (record.getContactQq() != null) {
            VALUES("contact_qq", "#{contactQq,jdbcType=VARCHAR}");
        }
        
        if (record.getContactMsn() != null) {
            VALUES("contact_msn", "#{contactMsn,jdbcType=VARCHAR}");
        }
        
        if (record.getContactWeibo() != null) {
            VALUES("contact_weibo", "#{contactWeibo,jdbcType=VARCHAR}");
        }
        
        if (record.getContactOthers() != null) {
            VALUES("contact_others", "#{contactOthers,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceChannel() != null) {
            VALUES("source_channel", "#{sourceChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceActivity() != null) {
            VALUES("source_activity", "#{sourceActivity,jdbcType=VARCHAR}");
        }
        
        if (record.getAssignedDepart() != null) {
            VALUES("assigned_depart", "#{assignedDepart,jdbcType=CHAR}");
        }
        
        if (record.getAssignedUser() != null) {
            VALUES("assigned_user", "#{assignedUser,jdbcType=VARCHAR}");
        }
        
        if (record.getLastOwner() != null) {
            VALUES("last_owner", "#{lastOwner,jdbcType=VARCHAR}");
        }
        
        if (record.getJobIndustry() != null) {
            VALUES("job_industry", "#{jobIndustry,jdbcType=CHAR}");
        }
        
        if (record.getJobTitle() != null) {
            VALUES("job_title", "#{jobTitle,jdbcType=CHAR}");
        }
        
        if (record.getJobCompany() != null) {
            VALUES("job_company", "#{jobCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getJobTelphone() != null) {
            VALUES("job_telphone", "#{jobTelphone,jdbcType=VARCHAR}");
        }
        
        if (record.getJobAddress() != null) {
            VALUES("job_address", "#{jobAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getJobPostcode() != null) {
            VALUES("job_postcode", "#{jobPostcode,jdbcType=VARCHAR}");
        }
        
        if (record.getEduDegree() != null) {
            VALUES("edu_degree", "#{eduDegree,jdbcType=CHAR}");
        }
        
        if (record.getEduGraduationDate() != null) {
            VALUES("edu_graduation_date", "#{eduGraduationDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEduSchool() != null) {
            VALUES("edu_school", "#{eduSchool,jdbcType=VARCHAR}");
        }
        
        if (record.getEduSpeciality() != null) {
            VALUES("edu_speciality", "#{eduSpeciality,jdbcType=VARCHAR}");
        }
        
        if (record.getEduAddress() != null) {
            VALUES("edu_address", "#{eduAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getEduPostcode() != null) {
            VALUES("edu_postcode", "#{eduPostcode,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            VALUES("update_date", "#{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            VALUES("update_user", "#{updateUser,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(StudentExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("student_id");
        } else {
            SELECT("student_id");
        }
        SELECT("student_no");
        SELECT("name");
        SELECT("email");
        SELECT("mobile");
        SELECT("student_type");
        SELECT("student_level");
        SELECT("member_level");
        SELECT("student_status");
        SELECT("is_valid");
        SELECT("sex");
        SELECT("birthday");
        SELECT("nation");
        SELECT("province");
        SELECT("city");
        SELECT("area");
        SELECT("address");
        SELECT("postcode");
        SELECT("telphone");
        SELECT("email_standby");
        SELECT("mobile_standby");
        SELECT("contact_qq");
        SELECT("contact_msn");
        SELECT("contact_weibo");
        SELECT("contact_others");
        SELECT("source_channel");
        SELECT("source_activity");
        SELECT("assigned_depart");
        SELECT("assigned_user");
        SELECT("last_owner");
        SELECT("job_industry");
        SELECT("job_title");
        SELECT("job_company");
        SELECT("job_telphone");
        SELECT("job_address");
        SELECT("job_postcode");
        SELECT("edu_degree");
        SELECT("edu_graduation_date");
        SELECT("edu_school");
        SELECT("edu_speciality");
        SELECT("edu_address");
        SELECT("edu_postcode");
        SELECT("remark");
        SELECT("create_date");
        SELECT("create_user");
        SELECT("update_date");
        SELECT("update_user");
        FROM("student");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        String limitSQL = " ";
        if(example.getStart()!=null && example.getEnd()!=null){
        	limitSQL =  limitSQL + "limit " + example.getStart() +"," + example.getEnd();
        }
        return SQL() + limitSQL;
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Student record = (Student) parameter.get("record");
        StudentExample example = (StudentExample) parameter.get("example");
        
        BEGIN();
        UPDATE("student");
        
        if (record.getStudentId() != null) {
            SET("student_id = #{record.studentId,jdbcType=BIGINT}");
        }
        
        if (record.getStudentNo() != null) {
            SET("student_no = #{record.studentNo,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentType() != null) {
            SET("student_type = #{record.studentType,jdbcType=BIT}");
        }
        
        if (record.getStudentLevel() != null) {
            SET("student_level = #{record.studentLevel,jdbcType=BIT}");
        }
        
        if (record.getMemberLevel() != null) {
            SET("member_level = #{record.memberLevel,jdbcType=BIT}");
        }
        
        if (record.getStudentStatus() != null) {
            SET("student_status = #{record.studentStatus,jdbcType=CHAR}");
        }
        
        if (record.getIsValid() != null) {
            SET("is_valid = #{record.isValid,jdbcType=BIT}");
        }
        
        if (record.getSex() != null) {
            SET("sex = #{record.sex,jdbcType=BIT}");
        }
        
        if (record.getBirthday() != null) {
            SET("birthday = #{record.birthday,jdbcType=DATE}");
        }
        
        if (record.getNation() != null) {
            SET("nation = #{record.nation,jdbcType=CHAR}");
        }
        
        if (record.getProvince() != null) {
            SET("province = #{record.province,jdbcType=CHAR}");
        }
        
        if (record.getCity() != null) {
            SET("city = #{record.city,jdbcType=CHAR}");
        }
        
        if (record.getArea() != null) {
            SET("area = #{record.area,jdbcType=CHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getPostcode() != null) {
            SET("postcode = #{record.postcode,jdbcType=VARCHAR}");
        }
        
        if (record.getTelphone() != null) {
            SET("telphone = #{record.telphone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmailStandby() != null) {
            SET("email_standby = #{record.emailStandby,jdbcType=VARCHAR}");
        }
        
        if (record.getMobileStandby() != null) {
            SET("mobile_standby = #{record.mobileStandby,jdbcType=VARCHAR}");
        }
        
        if (record.getContactQq() != null) {
            SET("contact_qq = #{record.contactQq,jdbcType=VARCHAR}");
        }
        
        if (record.getContactMsn() != null) {
            SET("contact_msn = #{record.contactMsn,jdbcType=VARCHAR}");
        }
        
        if (record.getContactWeibo() != null) {
            SET("contact_weibo = #{record.contactWeibo,jdbcType=VARCHAR}");
        }
        
        if (record.getContactOthers() != null) {
            SET("contact_others = #{record.contactOthers,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceChannel() != null) {
            SET("source_channel = #{record.sourceChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceActivity() != null) {
            SET("source_activity = #{record.sourceActivity,jdbcType=VARCHAR}");
        }
        
        if (record.getAssignedDepart() != null) {
            SET("assigned_depart = #{record.assignedDepart,jdbcType=CHAR}");
        }
        
        if (record.getAssignedUser() != null) {
            SET("assigned_user = #{record.assignedUser,jdbcType=VARCHAR}");
        }
        
        if (record.getLastOwner() != null) {
            SET("last_owner = #{record.lastOwner,jdbcType=VARCHAR}");
        }
        
        if (record.getJobIndustry() != null) {
            SET("job_industry = #{record.jobIndustry,jdbcType=CHAR}");
        }
        
        if (record.getJobTitle() != null) {
            SET("job_title = #{record.jobTitle,jdbcType=CHAR}");
        }
        
        if (record.getJobCompany() != null) {
            SET("job_company = #{record.jobCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getJobTelphone() != null) {
            SET("job_telphone = #{record.jobTelphone,jdbcType=VARCHAR}");
        }
        
        if (record.getJobAddress() != null) {
            SET("job_address = #{record.jobAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getJobPostcode() != null) {
            SET("job_postcode = #{record.jobPostcode,jdbcType=VARCHAR}");
        }
        
        if (record.getEduDegree() != null) {
            SET("edu_degree = #{record.eduDegree,jdbcType=CHAR}");
        }
        
        if (record.getEduGraduationDate() != null) {
            SET("edu_graduation_date = #{record.eduGraduationDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEduSchool() != null) {
            SET("edu_school = #{record.eduSchool,jdbcType=VARCHAR}");
        }
        
        if (record.getEduSpeciality() != null) {
            SET("edu_speciality = #{record.eduSpeciality,jdbcType=VARCHAR}");
        }
        
        if (record.getEduAddress() != null) {
            SET("edu_address = #{record.eduAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getEduPostcode() != null) {
            SET("edu_postcode = #{record.eduPostcode,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("student");
        
        SET("student_id = #{record.studentId,jdbcType=BIGINT}");
        SET("student_no = #{record.studentNo,jdbcType=VARCHAR}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("email = #{record.email,jdbcType=VARCHAR}");
        SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        SET("student_type = #{record.studentType,jdbcType=BIT}");
        SET("student_level = #{record.studentLevel,jdbcType=BIT}");
        SET("member_level = #{record.memberLevel,jdbcType=BIT}");
        SET("student_status = #{record.studentStatus,jdbcType=CHAR}");
        SET("is_valid = #{record.isValid,jdbcType=BIT}");
        SET("sex = #{record.sex,jdbcType=BIT}");
        SET("birthday = #{record.birthday,jdbcType=DATE}");
        SET("nation = #{record.nation,jdbcType=CHAR}");
        SET("province = #{record.province,jdbcType=CHAR}");
        SET("city = #{record.city,jdbcType=CHAR}");
        SET("area = #{record.area,jdbcType=CHAR}");
        SET("address = #{record.address,jdbcType=VARCHAR}");
        SET("postcode = #{record.postcode,jdbcType=VARCHAR}");
        SET("telphone = #{record.telphone,jdbcType=VARCHAR}");
        SET("email_standby = #{record.emailStandby,jdbcType=VARCHAR}");
        SET("mobile_standby = #{record.mobileStandby,jdbcType=VARCHAR}");
        SET("contact_qq = #{record.contactQq,jdbcType=VARCHAR}");
        SET("contact_msn = #{record.contactMsn,jdbcType=VARCHAR}");
        SET("contact_weibo = #{record.contactWeibo,jdbcType=VARCHAR}");
        SET("contact_others = #{record.contactOthers,jdbcType=VARCHAR}");
        SET("source_channel = #{record.sourceChannel,jdbcType=VARCHAR}");
        SET("source_activity = #{record.sourceActivity,jdbcType=VARCHAR}");
        SET("assigned_depart = #{record.assignedDepart,jdbcType=CHAR}");
        SET("assigned_user = #{record.assignedUser,jdbcType=VARCHAR}");
        SET("last_owner = #{record.lastOwner,jdbcType=VARCHAR}");
        SET("job_industry = #{record.jobIndustry,jdbcType=CHAR}");
        SET("job_title = #{record.jobTitle,jdbcType=CHAR}");
        SET("job_company = #{record.jobCompany,jdbcType=VARCHAR}");
        SET("job_telphone = #{record.jobTelphone,jdbcType=VARCHAR}");
        SET("job_address = #{record.jobAddress,jdbcType=VARCHAR}");
        SET("job_postcode = #{record.jobPostcode,jdbcType=VARCHAR}");
        SET("edu_degree = #{record.eduDegree,jdbcType=CHAR}");
        SET("edu_graduation_date = #{record.eduGraduationDate,jdbcType=VARCHAR}");
        SET("edu_school = #{record.eduSchool,jdbcType=VARCHAR}");
        SET("edu_speciality = #{record.eduSpeciality,jdbcType=VARCHAR}");
        SET("edu_address = #{record.eduAddress,jdbcType=VARCHAR}");
        SET("edu_postcode = #{record.eduPostcode,jdbcType=VARCHAR}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        
        StudentExample example = (StudentExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Student record) {
        BEGIN();
        UPDATE("student");
        
        if (record.getStudentNo() != null) {
            SET("student_no = #{studentNo,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentType() != null) {
            SET("student_type = #{studentType,jdbcType=BIT}");
        }
        
        if (record.getStudentLevel() != null) {
            SET("student_level = #{studentLevel,jdbcType=BIT}");
        }
        
        if (record.getMemberLevel() != null) {
            SET("member_level = #{memberLevel,jdbcType=BIT}");
        }
        
        if (record.getStudentStatus() != null) {
            SET("student_status = #{studentStatus,jdbcType=CHAR}");
        }
        
        if (record.getIsValid() != null) {
            SET("is_valid = #{isValid,jdbcType=BIT}");
        }
        
        if (record.getSex() != null) {
            SET("sex = #{sex,jdbcType=BIT}");
        }
        
        if (record.getBirthday() != null) {
            SET("birthday = #{birthday,jdbcType=DATE}");
        }
        
        if (record.getNation() != null) {
            SET("nation = #{nation,jdbcType=CHAR}");
        }
        
        if (record.getProvince() != null) {
            SET("province = #{province,jdbcType=CHAR}");
        }
        
        if (record.getCity() != null) {
            SET("city = #{city,jdbcType=CHAR}");
        }
        
        if (record.getArea() != null) {
            SET("area = #{area,jdbcType=CHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getPostcode() != null) {
            SET("postcode = #{postcode,jdbcType=VARCHAR}");
        }
        
        if (record.getTelphone() != null) {
            SET("telphone = #{telphone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmailStandby() != null) {
            SET("email_standby = #{emailStandby,jdbcType=VARCHAR}");
        }
        
        if (record.getMobileStandby() != null) {
            SET("mobile_standby = #{mobileStandby,jdbcType=VARCHAR}");
        }
        
        if (record.getContactQq() != null) {
            SET("contact_qq = #{contactQq,jdbcType=VARCHAR}");
        }
        
        if (record.getContactMsn() != null) {
            SET("contact_msn = #{contactMsn,jdbcType=VARCHAR}");
        }
        
        if (record.getContactWeibo() != null) {
            SET("contact_weibo = #{contactWeibo,jdbcType=VARCHAR}");
        }
        
        if (record.getContactOthers() != null) {
            SET("contact_others = #{contactOthers,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceChannel() != null) {
            SET("source_channel = #{sourceChannel,jdbcType=VARCHAR}");
        }
        
        if (record.getSourceActivity() != null) {
            SET("source_activity = #{sourceActivity,jdbcType=VARCHAR}");
        }
        
        if (record.getAssignedDepart() != null) {
            SET("assigned_depart = #{assignedDepart,jdbcType=CHAR}");
        }
        
        if (record.getAssignedUser() != null) {
            SET("assigned_user = #{assignedUser,jdbcType=VARCHAR}");
        }
        
        if (record.getLastOwner() != null) {
            SET("last_owner = #{lastOwner,jdbcType=VARCHAR}");
        }
        
        if (record.getJobIndustry() != null) {
            SET("job_industry = #{jobIndustry,jdbcType=CHAR}");
        }
        
        if (record.getJobTitle() != null) {
            SET("job_title = #{jobTitle,jdbcType=CHAR}");
        }
        
        if (record.getJobCompany() != null) {
            SET("job_company = #{jobCompany,jdbcType=VARCHAR}");
        }
        
        if (record.getJobTelphone() != null) {
            SET("job_telphone = #{jobTelphone,jdbcType=VARCHAR}");
        }
        
        if (record.getJobAddress() != null) {
            SET("job_address = #{jobAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getJobPostcode() != null) {
            SET("job_postcode = #{jobPostcode,jdbcType=VARCHAR}");
        }
        
        if (record.getEduDegree() != null) {
            SET("edu_degree = #{eduDegree,jdbcType=CHAR}");
        }
        
        if (record.getEduGraduationDate() != null) {
            SET("edu_graduation_date = #{eduGraduationDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEduSchool() != null) {
            SET("edu_school = #{eduSchool,jdbcType=VARCHAR}");
        }
        
        if (record.getEduSpeciality() != null) {
            SET("edu_speciality = #{eduSpeciality,jdbcType=VARCHAR}");
        }
        
        if (record.getEduAddress() != null) {
            SET("edu_address = #{eduAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getEduPostcode() != null) {
            SET("edu_postcode = #{eduPostcode,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            SET("create_user = #{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            SET("update_date = #{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            SET("update_user = #{updateUser,jdbcType=VARCHAR}");
        }
        
        WHERE("student_id = #{studentId,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(StudentExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}