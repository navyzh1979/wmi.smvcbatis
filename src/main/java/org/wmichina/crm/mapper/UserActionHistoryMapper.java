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
import org.wmichina.crm.entity.UserActionHistory;
import org.wmichina.crm.entity.example.UserActionHistoryExample;
import org.wmichina.crm.provider.UserActionHistorySqlProvider;

@Repository(value="userActionHistoryMapper")
public interface UserActionHistoryMapper {
    @SelectProvider(type=UserActionHistorySqlProvider.class, method="countByExample")
    int countByExample(UserActionHistoryExample example);

    @DeleteProvider(type=UserActionHistorySqlProvider.class, method="deleteByExample")
    int deleteByExample(UserActionHistoryExample example);

    @Delete({
        "delete from user_action_history",
        "where history_id = #{historyId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long historyId);

    @Insert({
        "insert into user_action_history (history_id, user_id, ",
        "user_name, action, ",
        "action_desc, optime, ",
        "mac_addr, ip)",
        "values (#{historyId,jdbcType=BIGINT}, #{userId,jdbcType=INTEGER}, ",
        "#{userName,jdbcType=VARCHAR}, #{action,jdbcType=VARCHAR}, ",
        "#{actionDesc,jdbcType=VARCHAR}, #{optime,jdbcType=TIMESTAMP}, ",
        "#{macAddr,jdbcType=VARCHAR}, #{ip,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="historyId")
    int insert(UserActionHistory record);

    @InsertProvider(type=UserActionHistorySqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="historyId")
    int insertSelective(UserActionHistory record);

    @SelectProvider(type=UserActionHistorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="history_id", property="historyId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="action_desc", property="actionDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="optime", property="optime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mac_addr", property="macAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR)
    })
    List<UserActionHistory> selectByExample(UserActionHistoryExample example);

    @Select({
        "select",
        "history_id, user_id, user_name, action, action_desc, optime, mac_addr, ip",
        "from user_action_history",
        "where history_id = #{historyId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="history_id", property="historyId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="action_desc", property="actionDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="optime", property="optime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="mac_addr", property="macAddr", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR)
    })
    UserActionHistory selectByPrimaryKey(Long historyId);

    @UpdateProvider(type=UserActionHistorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserActionHistory record, @Param("example") UserActionHistoryExample example);

    @UpdateProvider(type=UserActionHistorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserActionHistory record, @Param("example") UserActionHistoryExample example);

    @UpdateProvider(type=UserActionHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserActionHistory record);

    @Update({
        "update user_action_history",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "action = #{action,jdbcType=VARCHAR},",
          "action_desc = #{actionDesc,jdbcType=VARCHAR},",
          "optime = #{optime,jdbcType=TIMESTAMP},",
          "mac_addr = #{macAddr,jdbcType=VARCHAR},",
          "ip = #{ip,jdbcType=VARCHAR}",
        "where history_id = #{historyId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserActionHistory record);
}