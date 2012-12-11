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
import org.wmichina.crm.entity.BizActivity;
import org.wmichina.crm.entity.example.BizActivityExample;
import org.wmichina.crm.provider.BizActivitySqlProvider;

@Repository(value="bizActivityMapper")
public interface BizActivityMapper {
    @SelectProvider(type=BizActivitySqlProvider.class, method="countByExample")
    int countByExample(BizActivityExample example);

    @DeleteProvider(type=BizActivitySqlProvider.class, method="deleteByExample")
    int deleteByExample(BizActivityExample example);

    @Delete({
        "delete from biz_activity",
        "where activity_id = #{activityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer activityId);

    @Insert({
        "insert into biz_activity (activity_id, activity_code, ",
        "activity_name, activity_class_1, ",
        "activity_class_2, activity_class_3, ",
        "is_valid, start_date, end_date, ",
        "description, create_date, ",
        "create_user, update_date, ",
        "update_user)",
        "values (#{activityId,jdbcType=INTEGER}, #{activityCode,jdbcType=VARCHAR}, ",
        "#{activityName,jdbcType=VARCHAR}, #{activityClass1,jdbcType=VARCHAR}, ",
        "#{activityClass2,jdbcType=VARCHAR}, #{activityClass3,jdbcType=VARCHAR}, ",
        "#{isValid,jdbcType=BIT}, #{startDate,jdbcType=DATE}, #{endDate,jdbcType=DATE}, ",
        "#{description,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{updateUser,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="activityId")
    int insert(BizActivity record);

    @InsertProvider(type=BizActivitySqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="activityId")
    int insertSelective(BizActivity record);

    @SelectProvider(type=BizActivitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="activity_code", property="activityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="activity_name", property="activityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="activity_class_1", property="activityClass1", jdbcType=JdbcType.VARCHAR),
        @Result(column="activity_class_2", property="activityClass2", jdbcType=JdbcType.VARCHAR),
        @Result(column="activity_class_3", property="activityClass3", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    List<BizActivity> selectByExample(BizActivityExample example);

    @Select({
        "select",
        "activity_id, activity_code, activity_name, activity_class_1, activity_class_2, ",
        "activity_class_3, is_valid, start_date, end_date, description, create_date, ",
        "create_user, update_date, update_user",
        "from biz_activity",
        "where activity_id = #{activityId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="activity_id", property="activityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="activity_code", property="activityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="activity_name", property="activityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="activity_class_1", property="activityClass1", jdbcType=JdbcType.VARCHAR),
        @Result(column="activity_class_2", property="activityClass2", jdbcType=JdbcType.VARCHAR),
        @Result(column="activity_class_3", property="activityClass3", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    BizActivity selectByPrimaryKey(Integer activityId);

    @UpdateProvider(type=BizActivitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BizActivity record, @Param("example") BizActivityExample example);

    @UpdateProvider(type=BizActivitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BizActivity record, @Param("example") BizActivityExample example);

    @UpdateProvider(type=BizActivitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BizActivity record);

    @Update({
        "update biz_activity",
        "set activity_code = #{activityCode,jdbcType=VARCHAR},",
          "activity_name = #{activityName,jdbcType=VARCHAR},",
          "activity_class_1 = #{activityClass1,jdbcType=VARCHAR},",
          "activity_class_2 = #{activityClass2,jdbcType=VARCHAR},",
          "activity_class_3 = #{activityClass3,jdbcType=VARCHAR},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "start_date = #{startDate,jdbcType=DATE},",
          "end_date = #{endDate,jdbcType=DATE},",
          "description = #{description,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR}",
        "where activity_id = #{activityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BizActivity record);
}