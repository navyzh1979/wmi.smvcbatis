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
import org.wmichina.crm.entity.BizChannel;
import org.wmichina.crm.entity.example.BizChannelExample;
import org.wmichina.crm.provider.BizChannelSqlProvider;

@Repository(value="bizChannelMapper")
public interface BizChannelMapper {
    @SelectProvider(type=BizChannelSqlProvider.class, method="countByExample")
    int countByExample(BizChannelExample example);

    @DeleteProvider(type=BizChannelSqlProvider.class, method="deleteByExample")
    int deleteByExample(BizChannelExample example);

    @Delete({
        "delete from biz_channel",
        "where channel_id = #{channelId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer channelId);

    @Insert({
        "insert into biz_channel (channel_id, channel_code, ",
        "channel_name, channel_class_1, ",
        "channel_class_2, channel_class_3, ",
        "channel_class_4, channel_class_5, ",
        "is_valid, description, ",
        "create_date, create_user, ",
        "update_date, update_user)",
        "values (#{channelId,jdbcType=INTEGER}, #{channelCode,jdbcType=VARCHAR}, ",
        "#{channelName,jdbcType=VARCHAR}, #{channelClass1,jdbcType=VARCHAR}, ",
        "#{channelClass2,jdbcType=VARCHAR}, #{channelClass3,jdbcType=VARCHAR}, ",
        "#{channelClass4,jdbcType=VARCHAR}, #{channelClass5,jdbcType=VARCHAR}, ",
        "#{isValid,jdbcType=BIT}, #{description,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{createUser,jdbcType=VARCHAR}, ",
        "#{updateDate,jdbcType=TIMESTAMP}, #{updateUser,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="channelId")
    int insert(BizChannel record);

    @InsertProvider(type=BizChannelSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="channelId")
    int insertSelective(BizChannel record);

    @SelectProvider(type=BizChannelSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="channel_id", property="channelId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="channel_code", property="channelCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_name", property="channelName", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_class_1", property="channelClass1", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_class_2", property="channelClass2", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_class_3", property="channelClass3", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_class_4", property="channelClass4", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_class_5", property="channelClass5", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    List<BizChannel> selectByExample(BizChannelExample example);

    @Select({
        "select",
        "channel_id, channel_code, channel_name, channel_class_1, channel_class_2, channel_class_3, ",
        "channel_class_4, channel_class_5, is_valid, description, create_date, create_user, ",
        "update_date, update_user",
        "from biz_channel",
        "where channel_id = #{channelId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="channel_id", property="channelId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="channel_code", property="channelCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_name", property="channelName", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_class_1", property="channelClass1", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_class_2", property="channelClass2", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_class_3", property="channelClass3", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_class_4", property="channelClass4", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_class_5", property="channelClass5", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    BizChannel selectByPrimaryKey(Integer channelId);

    @UpdateProvider(type=BizChannelSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BizChannel record, @Param("example") BizChannelExample example);

    @UpdateProvider(type=BizChannelSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BizChannel record, @Param("example") BizChannelExample example);

    @UpdateProvider(type=BizChannelSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BizChannel record);

    @Update({
        "update biz_channel",
        "set channel_code = #{channelCode,jdbcType=VARCHAR},",
          "channel_name = #{channelName,jdbcType=VARCHAR},",
          "channel_class_1 = #{channelClass1,jdbcType=VARCHAR},",
          "channel_class_2 = #{channelClass2,jdbcType=VARCHAR},",
          "channel_class_3 = #{channelClass3,jdbcType=VARCHAR},",
          "channel_class_4 = #{channelClass4,jdbcType=VARCHAR},",
          "channel_class_5 = #{channelClass5,jdbcType=VARCHAR},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "description = #{description,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR}",
        "where channel_id = #{channelId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BizChannel record);
}