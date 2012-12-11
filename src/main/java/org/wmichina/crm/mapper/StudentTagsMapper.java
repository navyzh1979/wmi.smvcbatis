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
import org.wmichina.crm.entity.StudentTags;
import org.wmichina.crm.entity.example.StudentTagsExample;
import org.wmichina.crm.provider.StudentTagsSqlProvider;

@Repository(value="studentTagsMapper")
public interface StudentTagsMapper {
    @SelectProvider(type=StudentTagsSqlProvider.class, method="countByExample")
    int countByExample(StudentTagsExample example);

    @DeleteProvider(type=StudentTagsSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentTagsExample example);

    @Insert({
        "insert into student_tags (student_id, source_batchno, ",
        "tag_id, tag_name, ",
        "tag_depart, is_defined, ",
        "create_date, create_user)",
        "values (#{studentId,jdbcType=BIGINT}, #{sourceBatchno,jdbcType=VARCHAR}, ",
        "#{tagId,jdbcType=INTEGER}, #{tagName,jdbcType=VARCHAR}, ",
        "#{tagDepart,jdbcType=VARCHAR}, #{isDefined,jdbcType=BIT}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{createUser,jdbcType=VARCHAR})"
    })
    int insert(StudentTags record);

    @InsertProvider(type=StudentTagsSqlProvider.class, method="insertSelective")
    int insertSelective(StudentTags record);

    @SelectProvider(type=StudentTagsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.BIGINT),
        @Result(column="source_batchno", property="sourceBatchno", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.INTEGER),
        @Result(column="tag_name", property="tagName", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_depart", property="tagDepart", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_defined", property="isDefined", jdbcType=JdbcType.BIT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR)
    })
    List<StudentTags> selectByExample(StudentTagsExample example);

    @UpdateProvider(type=StudentTagsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StudentTags record, @Param("example") StudentTagsExample example);

    @UpdateProvider(type=StudentTagsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StudentTags record, @Param("example") StudentTagsExample example);
}