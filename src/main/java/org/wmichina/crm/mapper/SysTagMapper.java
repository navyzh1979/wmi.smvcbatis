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
import org.wmichina.crm.entity.SysTag;
import org.wmichina.crm.entity.example.SysTagExample;
import org.wmichina.crm.provider.SysTagSqlProvider;

@Repository(value="sysTagMapper")
public interface SysTagMapper {
    @SelectProvider(type=SysTagSqlProvider.class, method="countByExample")
    int countByExample(SysTagExample example);

    @DeleteProvider(type=SysTagSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysTagExample example);

    @Delete({
        "delete from sys_tag",
        "where tag_id = #{tagId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tagId);

    @Insert({
        "insert into sys_tag (tag_id, tag_department, ",
        "tag_code, tag_name, ",
        "is_valid, start_date, end_date, ",
        "description, create_date, ",
        "create_user, update_date, ",
        "update_user)",
        "values (#{tagId,jdbcType=INTEGER}, #{tagDepartment,jdbcType=VARCHAR}, ",
        "#{tagCode,jdbcType=VARCHAR}, #{tagName,jdbcType=VARCHAR}, ",
        "#{isValid,jdbcType=BIT}, #{startDate,jdbcType=DATE}, #{endDate,jdbcType=DATE}, ",
        "#{description,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{updateUser,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="tagId")
    int insert(SysTag record);

    @InsertProvider(type=SysTagSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="tagId")
    int insertSelective(SysTag record);

    @SelectProvider(type=SysTagSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tag_department", property="tagDepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_code", property="tagCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_name", property="tagName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    List<SysTag> selectByExample(SysTagExample example);

    @Select({
        "select",
        "tag_id, tag_department, tag_code, tag_name, is_valid, start_date, end_date, ",
        "description, create_date, create_user, update_date, update_user",
        "from sys_tag",
        "where tag_id = #{tagId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tag_id", property="tagId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tag_department", property="tagDepartment", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_code", property="tagCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_name", property="tagName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    SysTag selectByPrimaryKey(Integer tagId);

    @UpdateProvider(type=SysTagSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysTag record, @Param("example") SysTagExample example);

    @UpdateProvider(type=SysTagSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysTag record, @Param("example") SysTagExample example);

    @UpdateProvider(type=SysTagSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysTag record);

    @Update({
        "update sys_tag",
        "set tag_department = #{tagDepartment,jdbcType=VARCHAR},",
          "tag_code = #{tagCode,jdbcType=VARCHAR},",
          "tag_name = #{tagName,jdbcType=VARCHAR},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "start_date = #{startDate,jdbcType=DATE},",
          "end_date = #{endDate,jdbcType=DATE},",
          "description = #{description,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR}",
        "where tag_id = #{tagId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysTag record);
}