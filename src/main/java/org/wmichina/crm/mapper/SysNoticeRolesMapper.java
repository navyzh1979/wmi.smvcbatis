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
import org.wmichina.crm.entity.SysNoticeRoles;
import org.wmichina.crm.entity.example.SysNoticeRolesExample;
import org.wmichina.crm.provider.SysNoticeRolesSqlProvider;

@Repository(value="sysNoticeRolesMapper")
public interface SysNoticeRolesMapper {
    @SelectProvider(type=SysNoticeRolesSqlProvider.class, method="countByExample")
    int countByExample(SysNoticeRolesExample example);

    @DeleteProvider(type=SysNoticeRolesSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysNoticeRolesExample example);

    @Delete({
        "delete from sys_notice_roles",
        "where notice_role_id = #{noticeRoleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer noticeRoleId);

    @Insert({
        "insert into sys_notice_roles (notice_role_id, notice_id, ",
        "role_id, create_date, ",
        "create_notice)",
        "values (#{noticeRoleId,jdbcType=INTEGER}, #{noticeId,jdbcType=INTEGER}, ",
        "#{roleId,jdbcType=INTEGER}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{createNotice,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="noticeRoleId")
    int insert(SysNoticeRoles record);

    @InsertProvider(type=SysNoticeRolesSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="noticeRoleId")
    int insertSelective(SysNoticeRoles record);

    @SelectProvider(type=SysNoticeRolesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="notice_role_id", property="noticeRoleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_notice", property="createNotice", jdbcType=JdbcType.VARCHAR)
    })
    List<SysNoticeRoles> selectByExample(SysNoticeRolesExample example);

    @Select({
        "select",
        "notice_role_id, notice_id, role_id, create_date, create_notice",
        "from sys_notice_roles",
        "where notice_role_id = #{noticeRoleId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="notice_role_id", property="noticeRoleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_id", property="noticeId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_notice", property="createNotice", jdbcType=JdbcType.VARCHAR)
    })
    SysNoticeRoles selectByPrimaryKey(Integer noticeRoleId);

    @UpdateProvider(type=SysNoticeRolesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysNoticeRoles record, @Param("example") SysNoticeRolesExample example);

    @UpdateProvider(type=SysNoticeRolesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysNoticeRoles record, @Param("example") SysNoticeRolesExample example);

    @UpdateProvider(type=SysNoticeRolesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysNoticeRoles record);

    @Update({
        "update sys_notice_roles",
        "set notice_id = #{noticeId,jdbcType=INTEGER},",
          "role_id = #{roleId,jdbcType=INTEGER},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_notice = #{createNotice,jdbcType=VARCHAR}",
        "where notice_role_id = #{noticeRoleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysNoticeRoles record);
}