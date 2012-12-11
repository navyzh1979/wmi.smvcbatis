package org.wmichina.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import org.wmichina.crm.entity.StudentLogAssign;
import org.wmichina.crm.entity.example.StudentLogAssignExample;
import org.wmichina.crm.provider.StudentLogAssignSqlProvider;

@Repository(value="studentLogAssignMapper")
public interface StudentLogAssignMapper {
    @SelectProvider(type=StudentLogAssignSqlProvider.class, method="countByExample")
    int countByExample(StudentLogAssignExample example);

    @DeleteProvider(type=StudentLogAssignSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentLogAssignExample example);

    @Insert({
        "insert into student_log_assign (assign_id, student_id, ",
        "depart_code, depart_name, ",
        "job_code, job_name, job_days, ",
        "job_deadline, assigned_to, ",
        "create_time, create_user)",
        "values (#{assignId,jdbcType=BIGINT}, #{studentId,jdbcType=BIGINT}, ",
        "#{departCode,jdbcType=CHAR}, #{departName,jdbcType=VARCHAR}, ",
        "#{jobCode,jdbcType=CHAR}, #{jobName,jdbcType=VARCHAR}, #{jobDays,jdbcType=INTEGER}, ",
        "#{jobDeadline,jdbcType=DATE}, #{assignedTo,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createUser,jdbcType=VARCHAR})"
    })
    int insert(StudentLogAssign record);

    @InsertProvider(type=StudentLogAssignSqlProvider.class, method="insertSelective")
    int insertSelective(StudentLogAssign record);

    @SelectProvider(type=StudentLogAssignSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="assign_id", property="assignId", jdbcType=JdbcType.BIGINT),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.BIGINT),
        @Result(column="depart_code", property="departCode", jdbcType=JdbcType.CHAR),
        @Result(column="depart_name", property="departName", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_code", property="jobCode", jdbcType=JdbcType.CHAR),
        @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_days", property="jobDays", jdbcType=JdbcType.INTEGER),
        @Result(column="job_deadline", property="jobDeadline", jdbcType=JdbcType.DATE),
        @Result(column="assigned_to", property="assignedTo", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR)
    })
    List<StudentLogAssign> selectByExample(StudentLogAssignExample example);

    @UpdateProvider(type=StudentLogAssignSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StudentLogAssign record, @Param("example") StudentLogAssignExample example);

    @UpdateProvider(type=StudentLogAssignSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StudentLogAssign record, @Param("example") StudentLogAssignExample example);
}