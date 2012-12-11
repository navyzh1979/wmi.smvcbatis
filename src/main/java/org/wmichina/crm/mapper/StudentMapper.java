package org.wmichina.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import org.wmichina.crm.entity.Student;
import org.wmichina.crm.entity.example.StudentExample;
import org.wmichina.crm.provider.StudentSqlProvider;

@Repository(value="studentMapper")
public interface StudentMapper {
    @SelectProvider(type=StudentSqlProvider.class, method="countByExample")
    int countByExample(StudentExample example);

    @DeleteProvider(type=StudentSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentExample example);

    @Delete({
        "delete from student",
        "where student_id = #{studentId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long studentId);

    @Insert({
        "insert into student (student_id, student_no, ",
        "name, email, mobile, ",
        "student_type, student_level, ",
        "member_level, student_status, ",
        "is_valid, sex, birthday, ",
        "nation, province, city, ",
        "area, address, postcode, ",
        "telphone, email_standby, ",
        "mobile_standby, contact_qq, ",
        "contact_msn, contact_weibo, ",
        "contact_others, source_channel, ",
        "source_activity, assigned_depart, ",
        "assigned_user, last_owner, ",
        "job_industry, job_title, ",
        "job_company, job_telphone, ",
        "job_address, job_postcode, ",
        "edu_degree, edu_graduation_date, ",
        "edu_school, edu_speciality, ",
        "edu_address, edu_postcode, ",
        "remark, create_date, ",
        "create_user, update_date, ",
        "update_user)",
        "values (#{studentId,jdbcType=BIGINT}, #{studentNo,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{studentType,jdbcType=BIT}, #{studentLevel,jdbcType=BIT}, ",
        "#{memberLevel,jdbcType=BIT}, #{studentStatus,jdbcType=CHAR}, ",
        "#{isValid,jdbcType=BIT}, #{sex,jdbcType=BIT}, #{birthday,jdbcType=DATE}, ",
        "#{nation,jdbcType=CHAR}, #{province,jdbcType=CHAR}, #{city,jdbcType=CHAR}, ",
        "#{area,jdbcType=CHAR}, #{address,jdbcType=VARCHAR}, #{postcode,jdbcType=VARCHAR}, ",
        "#{telphone,jdbcType=VARCHAR}, #{emailStandby,jdbcType=VARCHAR}, ",
        "#{mobileStandby,jdbcType=VARCHAR}, #{contactQq,jdbcType=VARCHAR}, ",
        "#{contactMsn,jdbcType=VARCHAR}, #{contactWeibo,jdbcType=VARCHAR}, ",
        "#{contactOthers,jdbcType=VARCHAR}, #{sourceChannel,jdbcType=VARCHAR}, ",
        "#{sourceActivity,jdbcType=VARCHAR}, #{assignedDepart,jdbcType=CHAR}, ",
        "#{assignedUser,jdbcType=VARCHAR}, #{lastOwner,jdbcType=VARCHAR}, ",
        "#{jobIndustry,jdbcType=CHAR}, #{jobTitle,jdbcType=CHAR}, ",
        "#{jobCompany,jdbcType=VARCHAR}, #{jobTelphone,jdbcType=VARCHAR}, ",
        "#{jobAddress,jdbcType=VARCHAR}, #{jobPostcode,jdbcType=VARCHAR}, ",
        "#{eduDegree,jdbcType=CHAR}, #{eduGraduationDate,jdbcType=VARCHAR}, ",
        "#{eduSchool,jdbcType=VARCHAR}, #{eduSpeciality,jdbcType=VARCHAR}, ",
        "#{eduAddress,jdbcType=VARCHAR}, #{eduPostcode,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{updateUser,jdbcType=VARCHAR})"
    })
    int insert(Student record);

    @InsertProvider(type=StudentSqlProvider.class, method="insertSelective")
    int insertSelective(Student record);

    @SelectProvider(type=StudentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="student_no", property="studentNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_type", property="studentType", jdbcType=JdbcType.BIT),
        @Result(column="student_level", property="studentLevel", jdbcType=JdbcType.BIT),
        @Result(column="member_level", property="memberLevel", jdbcType=JdbcType.BIT),
        @Result(column="student_status", property="studentStatus", jdbcType=JdbcType.CHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="sex", property="sex", jdbcType=JdbcType.BIT),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="nation", property="nation", jdbcType=JdbcType.CHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.CHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.CHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.CHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="postcode", property="postcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="telphone", property="telphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email_standby", property="emailStandby", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile_standby", property="mobileStandby", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_qq", property="contactQq", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_msn", property="contactMsn", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_weibo", property="contactWeibo", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_others", property="contactOthers", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_channel", property="sourceChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_activity", property="sourceActivity", jdbcType=JdbcType.VARCHAR),
        @Result(column="assigned_depart", property="assignedDepart", jdbcType=JdbcType.CHAR),
        @Result(column="assigned_user", property="assignedUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_owner", property="lastOwner", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_industry", property="jobIndustry", jdbcType=JdbcType.CHAR),
        @Result(column="job_title", property="jobTitle", jdbcType=JdbcType.CHAR),
        @Result(column="job_company", property="jobCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_telphone", property="jobTelphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_address", property="jobAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_postcode", property="jobPostcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_degree", property="eduDegree", jdbcType=JdbcType.CHAR),
        @Result(column="edu_graduation_date", property="eduGraduationDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_school", property="eduSchool", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_speciality", property="eduSpeciality", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_address", property="eduAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_postcode", property="eduPostcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    List<Student> selectByExample(StudentExample example);

    @Select({
        "select",
        "student_id, student_no, name, email, mobile, student_type, student_level, member_level, ",
        "student_status, is_valid, sex, birthday, nation, province, city, area, address, ",
        "postcode, telphone, email_standby, mobile_standby, contact_qq, contact_msn, ",
        "contact_weibo, contact_others, source_channel, source_activity, assigned_depart, ",
        "assigned_user, last_owner, job_industry, job_title, job_company, job_telphone, ",
        "job_address, job_postcode, edu_degree, edu_graduation_date, edu_school, edu_speciality, ",
        "edu_address, edu_postcode, remark, create_date, create_user, update_date, update_user",
        "from student",
        "where student_id = #{studentId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="student_no", property="studentNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_type", property="studentType", jdbcType=JdbcType.BIT),
        @Result(column="student_level", property="studentLevel", jdbcType=JdbcType.BIT),
        @Result(column="member_level", property="memberLevel", jdbcType=JdbcType.BIT),
        @Result(column="student_status", property="studentStatus", jdbcType=JdbcType.CHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="sex", property="sex", jdbcType=JdbcType.BIT),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="nation", property="nation", jdbcType=JdbcType.CHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.CHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.CHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.CHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="postcode", property="postcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="telphone", property="telphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email_standby", property="emailStandby", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile_standby", property="mobileStandby", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_qq", property="contactQq", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_msn", property="contactMsn", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_weibo", property="contactWeibo", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_others", property="contactOthers", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_channel", property="sourceChannel", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_activity", property="sourceActivity", jdbcType=JdbcType.VARCHAR),
        @Result(column="assigned_depart", property="assignedDepart", jdbcType=JdbcType.CHAR),
        @Result(column="assigned_user", property="assignedUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_owner", property="lastOwner", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_industry", property="jobIndustry", jdbcType=JdbcType.CHAR),
        @Result(column="job_title", property="jobTitle", jdbcType=JdbcType.CHAR),
        @Result(column="job_company", property="jobCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_telphone", property="jobTelphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_address", property="jobAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_postcode", property="jobPostcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_degree", property="eduDegree", jdbcType=JdbcType.CHAR),
        @Result(column="edu_graduation_date", property="eduGraduationDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_school", property="eduSchool", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_speciality", property="eduSpeciality", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_address", property="eduAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="edu_postcode", property="eduPostcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    Student selectByPrimaryKey(Long studentId);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Student record);

    @Update({
        "update student",
        "set student_no = #{studentNo,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "student_type = #{studentType,jdbcType=BIT},",
          "student_level = #{studentLevel,jdbcType=BIT},",
          "member_level = #{memberLevel,jdbcType=BIT},",
          "student_status = #{studentStatus,jdbcType=CHAR},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "sex = #{sex,jdbcType=BIT},",
          "birthday = #{birthday,jdbcType=DATE},",
          "nation = #{nation,jdbcType=CHAR},",
          "province = #{province,jdbcType=CHAR},",
          "city = #{city,jdbcType=CHAR},",
          "area = #{area,jdbcType=CHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "postcode = #{postcode,jdbcType=VARCHAR},",
          "telphone = #{telphone,jdbcType=VARCHAR},",
          "email_standby = #{emailStandby,jdbcType=VARCHAR},",
          "mobile_standby = #{mobileStandby,jdbcType=VARCHAR},",
          "contact_qq = #{contactQq,jdbcType=VARCHAR},",
          "contact_msn = #{contactMsn,jdbcType=VARCHAR},",
          "contact_weibo = #{contactWeibo,jdbcType=VARCHAR},",
          "contact_others = #{contactOthers,jdbcType=VARCHAR},",
          "source_channel = #{sourceChannel,jdbcType=VARCHAR},",
          "source_activity = #{sourceActivity,jdbcType=VARCHAR},",
          "assigned_depart = #{assignedDepart,jdbcType=CHAR},",
          "assigned_user = #{assignedUser,jdbcType=VARCHAR},",
          "last_owner = #{lastOwner,jdbcType=VARCHAR},",
          "job_industry = #{jobIndustry,jdbcType=CHAR},",
          "job_title = #{jobTitle,jdbcType=CHAR},",
          "job_company = #{jobCompany,jdbcType=VARCHAR},",
          "job_telphone = #{jobTelphone,jdbcType=VARCHAR},",
          "job_address = #{jobAddress,jdbcType=VARCHAR},",
          "job_postcode = #{jobPostcode,jdbcType=VARCHAR},",
          "edu_degree = #{eduDegree,jdbcType=CHAR},",
          "edu_graduation_date = #{eduGraduationDate,jdbcType=VARCHAR},",
          "edu_school = #{eduSchool,jdbcType=VARCHAR},",
          "edu_speciality = #{eduSpeciality,jdbcType=VARCHAR},",
          "edu_address = #{eduAddress,jdbcType=VARCHAR},",
          "edu_postcode = #{eduPostcode,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR}",
        "where student_id = #{studentId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Student record);
}