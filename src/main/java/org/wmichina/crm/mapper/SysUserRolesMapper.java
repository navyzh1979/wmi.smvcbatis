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
import org.wmichina.crm.entity.SysUserRoles;
import org.wmichina.crm.entity.example.SysUserRolesExample;
import org.wmichina.crm.provider.SysUserRolesSqlProvider;

@Repository(value="sysUserRolesMapper")
public interface SysUserRolesMapper {
    @SelectProvider(type=SysUserRolesSqlProvider.class, method="countByExample")
    int countByExample(SysUserRolesExample example);

    @DeleteProvider(type=SysUserRolesSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysUserRolesExample example);

    @Delete({
        "delete from sys_user_roles",
        "where user_role_id = #{userRoleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userRoleId);

    @Insert({
        "insert into sys_user_roles (user_role_id, user_id, ",
        "role_id, create_date, ",
        "create_user)",
        "values (#{userRoleId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{roleId,jdbcType=INTEGER}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true, keyProperty="userRoleId")
    int insert(SysUserRoles record);

    @InsertProvider(type=SysUserRolesSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="userRoleId")
    int insertSelective(SysUserRoles record);

    @SelectProvider(type=SysUserRolesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_role_id", property="userRoleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR)
    })
    List<SysUserRoles> selectByExample(SysUserRolesExample example);

    @Select({
        "select",
        "user_role_id, user_id, role_id, create_date, create_user",
        "from sys_user_roles",
        "where user_role_id = #{userRoleId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_role_id", property="userRoleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR)
    })
    SysUserRoles selectByPrimaryKey(Integer userRoleId);

    @UpdateProvider(type=SysUserRolesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysUserRoles record, @Param("example") SysUserRolesExample example);

    @UpdateProvider(type=SysUserRolesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysUserRoles record, @Param("example") SysUserRolesExample example);

    @UpdateProvider(type=SysUserRolesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysUserRoles record);

    @Update({
        "update sys_user_roles",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "role_id = #{roleId,jdbcType=INTEGER},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR}",
        "where user_role_id = #{userRoleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysUserRoles record);
}