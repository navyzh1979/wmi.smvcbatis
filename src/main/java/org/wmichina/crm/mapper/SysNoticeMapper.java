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
import org.wmichina.crm.entity.SysNotice;
import org.wmichina.crm.entity.SysRole;
import org.wmichina.crm.entity.example.SysNoticeExample;
import org.wmichina.crm.provider.SysNoticeSqlProvider;

@Repository(value="sysNoticeMapper")
public interface SysNoticeMapper {
    @SelectProvider(type=SysNoticeSqlProvider.class, method="countByExample")
    int countByExample(SysNoticeExample example);

    @DeleteProvider(type=SysNoticeSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysNoticeExample example);

    @Delete({
        "delete from sys_notice",
        "where notice_id = #{noticeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer noticeId);

    @Insert({
        "insert into sys_notice (notice_id, notice_name, ",
        "is_valid, start_date, end_date, ",
        "create_date, create_user, ",
        "update_date, update_user, ",
        "description)",
        "values (#{noticeId,jdbcType=INTEGER}, #{noticeName,jdbcType=VARCHAR}, ",
        "#{isValid,jdbcType=BIT}, #{startDate,jdbcType=DATE}, #{endDate,jdbcType=DATE}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{createUser,jdbcType=VARCHAR}, ",
        "#{updateDate,jdbcType=TIMESTAMP}, #{updateUser,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=LONGVARBINARY})"
    })
    @Options(useGeneratedKeys=true,keyProperty="noticeId")
    int insert(SysNotice record);

    @InsertProvider(type=SysNoticeSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="noticeId")
    int insertSelective(SysNotice record);

    @SelectProvider(type=SysNoticeSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_name", property="noticeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<SysNotice> selectByExampleWithBLOBs(SysNoticeExample example);

    @SelectProvider(type=SysNoticeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_name", property="noticeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    List<SysNotice> selectByExample(SysNoticeExample example);

    @Select({
        "select",
        "notice_id, notice_name, is_valid, start_date, end_date, create_date, create_user, ",
        "update_date, update_user, description",
        "from sys_notice",
        "where notice_id = #{noticeId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_name", property="noticeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARBINARY)
    })
    SysNotice selectByPrimaryKey(Integer noticeId);

    @UpdateProvider(type=SysNoticeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    @UpdateProvider(type=SysNoticeSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    @UpdateProvider(type=SysNoticeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    @UpdateProvider(type=SysNoticeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysNotice record);

    @Update({
        "update sys_notice",
        "set notice_name = #{noticeName,jdbcType=VARCHAR},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "start_date = #{startDate,jdbcType=DATE},",
          "end_date = #{endDate,jdbcType=DATE},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=LONGVARBINARY}",
        "where notice_id = #{noticeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(SysNotice record);

    @Update({
        "update sys_notice",
        "set notice_name = #{noticeName,jdbcType=VARCHAR},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "start_date = #{startDate,jdbcType=DATE},",
          "end_date = #{endDate,jdbcType=DATE},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR}",
        "where notice_id = #{noticeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysNotice record);
    
    @Select(value="select r.* from sys_role r, sys_notice_roles nr where r.role_id=nr.role_id and nr.notice_id=#{noticeId}")
    @Results(value={@Result(property="roleId",column="role_id"),
    		@Result(property="roleName",column="role_name"),
    		@Result(property="auditStatus",column="audit_status"),
    		@Result(property="isValid",column="is_valid"),
    		@Result(property="createDate",column="create_date"),
    		@Result(property="createUser",column="create_user"),
    		@Result(property="updateDate",column="update_date"),
    		@Result(property="updateUser",column="update_user")
    		})
	public List<SysRole> findRolesByNoticeId(@Param(value="noticeId")Integer noticeId);
    
    @Select(value="select n.* from sys_notice n, sys_notice_roles nr where n.notice_id=nr.notice_id and nr.role_id in #{roleIds }")
    @Results({
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_name", property="noticeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.DATE),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.DATE),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARBINARY)
    })
	public List<SysNotice> findNoticesByRoleIds(@Param(value="roleIds")String roleIds);

}