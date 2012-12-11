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
import org.wmichina.crm.entity.StudentInfoMarketing;
import org.wmichina.crm.entity.example.StudentInfoMarketingExample;
import org.wmichina.crm.provider.StudentInfoMarketingSqlProvider;

@Repository(value="studentInfoMarketingMapper")
public interface StudentInfoMarketingMapper {
    @SelectProvider(type=StudentInfoMarketingSqlProvider.class, method="countByExample")
    int countByExample(StudentInfoMarketingExample example);

    @DeleteProvider(type=StudentInfoMarketingSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentInfoMarketingExample example);

    @Insert({
        "insert into student_info_marketing (student_id, source_batchno, ",
        "intend_type, intend_course, ",
        "exam_date, contact_tried, ",
        "contact_answered, create_date, ",
        "create_user)",
        "values (#{studentId,jdbcType=BIGINT}, #{sourceBatchno,jdbcType=VARCHAR}, ",
        "#{intendType,jdbcType=BIT}, #{intendCourse,jdbcType=VARCHAR}, ",
        "#{examDate,jdbcType=VARCHAR}, #{contactTried,jdbcType=INTEGER}, ",
        "#{contactAnswered,jdbcType=INTEGER}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR})"
    })
    int insert(StudentInfoMarketing record);

    @InsertProvider(type=StudentInfoMarketingSqlProvider.class, method="insertSelective")
    int insertSelective(StudentInfoMarketing record);

    @SelectProvider(type=StudentInfoMarketingSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.BIGINT),
        @Result(column="source_batchno", property="sourceBatchno", jdbcType=JdbcType.VARCHAR),
        @Result(column="intend_type", property="intendType", jdbcType=JdbcType.BIT),
        @Result(column="intend_course", property="intendCourse", jdbcType=JdbcType.VARCHAR),
        @Result(column="exam_date", property="examDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_tried", property="contactTried", jdbcType=JdbcType.INTEGER),
        @Result(column="contact_answered", property="contactAnswered", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR)
    })
    List<StudentInfoMarketing> selectByExample(StudentInfoMarketingExample example);

    @UpdateProvider(type=StudentInfoMarketingSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StudentInfoMarketing record, @Param("example") StudentInfoMarketingExample example);

    @UpdateProvider(type=StudentInfoMarketingSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StudentInfoMarketing record, @Param("example") StudentInfoMarketingExample example);
}