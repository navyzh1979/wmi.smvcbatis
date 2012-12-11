package org.wmichina.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;
import org.wmichina.crm.entity.SysDailyJob;
import org.wmichina.crm.entity.example.SysDailyJobExample;
import org.wmichina.crm.provider.SysDailyJobSqlProvider;

@Repository(value="sysDailyJobMapper")
public interface SysDailyJobMapper {
    @SelectProvider(type=SysDailyJobSqlProvider.class, method="countByExample")
    int countByExample(SysDailyJobExample example);

    @DeleteProvider(type=SysDailyJobSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDailyJobExample example);

    @Delete({
        "delete from sys_daily_job",
        "where job_id = #{jobId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer jobId);

    @Insert({
        "insert into sys_daily_job (job_id, job_department, ",
        "job_code, job_name, ",
        "job_version, job_score, ",
        "is_valid, start_date, end_date, ",
        "remark, create_date, ",
        "create_user, update_date, ",
        "update_user, description)",
        "values (#{jobId,jdbcType=INTEGER}, #{jobDepartment,jdbcType=VARCHAR}, ",
        "#{jobCode,jdbcType=VARCHAR}, #{jobName,jdbcType=VARCHAR}, ",
        "#{jobVersion,jdbcType=VARCHAR}, #{jobScore,jdbcType=INTEGER}, ",
        "#{isValid,jdbcType=BIT}, #{startDate,jdbcType=DATE}, #{endDate,jdbcType=DATE}, ",
        "#{remark,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{updateUser,jdbcType=VARCHAR}, #{description,jdbcType=LONGVARBINARY})"
    })
    @Options(useGeneratedKeys=true,keyProperty="jobId")
    int insert(SysDailyJob record);

    @InsertProvider(type=SysDailyJobSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="jobId")
    int insertSelective(SysDailyJob record);

    @SelectProvider(type=SysDailyJobSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="job_id", property="jobId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="job_department", property="jobDepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_code", property="jobCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_version", property="jobVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_score", property="jobScore", jdbcType=JdbcType.INTEGER),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<SysDailyJob> selectByExampleWithBLOBs(SysDailyJobExample example);

    @SelectProvider(type=SysDailyJobSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="job_id", property="jobId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="job_department", property="jobDepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_code", property="jobCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_version", property="jobVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_score", property="jobScore", jdbcType=JdbcType.INTEGER),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    List<SysDailyJob> selectByExample(SysDailyJobExample example);

    @Select({
        "select",
        "job_id, job_department, job_code, job_name, job_version, job_score, is_valid, ",
        "start_date, end_date, remark, create_date, create_user, update_date, update_user, ",
        "description",
        "from sys_daily_job",
        "where job_id = #{jobId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="job_id", property="jobId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="job_department", property="jobDepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_code", property="jobCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_name", property="jobName", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_version", property="jobVersion", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_score", property="jobScore", jdbcType=JdbcType.INTEGER),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARBINARY)
    })
    SysDailyJob selectByPrimaryKey(Integer jobId);

    @UpdateProvider(type=SysDailyJobSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDailyJob record, @Param("example") SysDailyJobExample example);

    @UpdateProvider(type=SysDailyJobSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") SysDailyJob record, @Param("example") SysDailyJobExample example);

    @UpdateProvider(type=SysDailyJobSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDailyJob record, @Param("example") SysDailyJobExample example);

    @UpdateProvider(type=SysDailyJobSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDailyJob record);

    @Update({
        "update sys_daily_job",
        "set job_department = #{jobDepartment,jdbcType=VARCHAR},",
          "job_code = #{jobCode,jdbcType=VARCHAR},",
          "job_name = #{jobName,jdbcType=VARCHAR},",
          "job_version = #{jobVersion,jdbcType=VARCHAR},",
          "job_score = #{jobScore,jdbcType=INTEGER},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "start_date = #{startDate,jdbcType=DATE},",
          "end_date = #{endDate,jdbcType=DATE},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=LONGVARBINARY}",
        "where job_id = #{jobId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(SysDailyJob record);

    @Update({
        "update sys_daily_job",
        "set job_department = #{jobDepartment,jdbcType=VARCHAR},",
          "job_code = #{jobCode,jdbcType=VARCHAR},",
          "job_name = #{jobName,jdbcType=VARCHAR},",
          "job_version = #{jobVersion,jdbcType=VARCHAR},",
          "job_score = #{jobScore,jdbcType=INTEGER},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "start_date = #{startDate,jdbcType=DATE},",
          "end_date = #{endDate,jdbcType=DATE},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR}",
        "where job_id = #{jobId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysDailyJob record);
}