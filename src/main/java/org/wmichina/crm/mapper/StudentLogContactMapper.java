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
import org.wmichina.crm.entity.StudentLogContact;
import org.wmichina.crm.entity.example.StudentLogContactExample;
import org.wmichina.crm.provider.StudentLogContactSqlProvider;

@Repository(value="studentLogContactMapper")
public interface StudentLogContactMapper {
    @SelectProvider(type=StudentLogContactSqlProvider.class, method="countByExample")
    int countByExample(StudentLogContactExample example);

    @DeleteProvider(type=StudentLogContactSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentLogContactExample example);

    @Delete({
        "delete from student_log_contact",
        "where contact_id = #{contactId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long contactId);

    @Insert({
        "insert into student_log_contact (contact_id, student_id, ",
        "contact_mode, contact_summary, ",
        "contact_batchno, contact_date, ",
        "is_answered, answer_summary, ",
        "answer_date, create_date, ",
        "create_user, update_time, ",
        "update_user)",
        "values (#{contactId,jdbcType=BIGINT}, #{studentId,jdbcType=BIGINT}, ",
        "#{contactMode,jdbcType=BIT}, #{contactSummary,jdbcType=VARCHAR}, ",
        "#{contactBatchno,jdbcType=VARCHAR}, #{contactDate,jdbcType=TIMESTAMP}, ",
        "#{isAnswered,jdbcType=BIT}, #{answerSummary,jdbcType=VARCHAR}, ",
        "#{answerDate,jdbcType=TIMESTAMP}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{updateUser,jdbcType=VARCHAR})"
    })
    int insert(StudentLogContact record);

    @InsertProvider(type=StudentLogContactSqlProvider.class, method="insertSelective")
    int insertSelective(StudentLogContact record);

    @SelectProvider(type=StudentLogContactSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="contact_id", property="contactId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.BIGINT),
        @Result(column="contact_mode", property="contactMode", jdbcType=JdbcType.BIT),
        @Result(column="contact_summary", property="contactSummary", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_batchno", property="contactBatchno", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_date", property="contactDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_answered", property="isAnswered", jdbcType=JdbcType.BIT),
        @Result(column="answer_summary", property="answerSummary", jdbcType=JdbcType.VARCHAR),
        @Result(column="answer_date", property="answerDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    List<StudentLogContact> selectByExample(StudentLogContactExample example);

    @Select({
        "select",
        "contact_id, student_id, contact_mode, contact_summary, contact_batchno, contact_date, ",
        "is_answered, answer_summary, answer_date, create_date, create_user, update_time, ",
        "update_user",
        "from student_log_contact",
        "where contact_id = #{contactId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="contact_id", property="contactId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.BIGINT),
        @Result(column="contact_mode", property="contactMode", jdbcType=JdbcType.BIT),
        @Result(column="contact_summary", property="contactSummary", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_batchno", property="contactBatchno", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_date", property="contactDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_answered", property="isAnswered", jdbcType=JdbcType.BIT),
        @Result(column="answer_summary", property="answerSummary", jdbcType=JdbcType.VARCHAR),
        @Result(column="answer_date", property="answerDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    StudentLogContact selectByPrimaryKey(Long contactId);

    @UpdateProvider(type=StudentLogContactSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StudentLogContact record, @Param("example") StudentLogContactExample example);

    @UpdateProvider(type=StudentLogContactSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StudentLogContact record, @Param("example") StudentLogContactExample example);

    @UpdateProvider(type=StudentLogContactSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StudentLogContact record);

    @Update({
        "update student_log_contact",
        "set student_id = #{studentId,jdbcType=BIGINT},",
          "contact_mode = #{contactMode,jdbcType=BIT},",
          "contact_summary = #{contactSummary,jdbcType=VARCHAR},",
          "contact_batchno = #{contactBatchno,jdbcType=VARCHAR},",
          "contact_date = #{contactDate,jdbcType=TIMESTAMP},",
          "is_answered = #{isAnswered,jdbcType=BIT},",
          "answer_summary = #{answerSummary,jdbcType=VARCHAR},",
          "answer_date = #{answerDate,jdbcType=TIMESTAMP},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR}",
        "where contact_id = #{contactId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(StudentLogContact record);
}