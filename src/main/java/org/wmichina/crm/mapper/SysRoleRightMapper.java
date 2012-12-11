package org.wmichina.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.wmichina.crm.entity.SysRight;
import org.wmichina.crm.entity.SysRole;
import org.wmichina.crm.entity.SysRoleRight;
import org.wmichina.crm.provider.SysRoleRightProvider;

@Repository(value="sysRoleRightMapper")
public interface SysRoleRightMapper {

	@Select(value="${querySQL}")
    @Results(value={@Result(property="rightId",column="right_id"),
    		@Result(property="rightCode",column="right_code"),
    		@Result(property="rightName",column="right_name"),
    		@Result(property="rightURL",column="right_url"),
    		@Result(property="rightLevel",column="right_level"),
    		@Result(property="parentRight",column="parent_right"),
    		@Result(property="isValid",column="is_valid"),
    		@Result(property="createDate",column="create_date"),
    		@Result(property="createUser",column="create_user"),
    		@Result(property="updateDate",column="update_date"),
    		@Result(property="updateUser",column="update_user"),
    		@Result(property="remark",column="remark")})
	public List<SysRight> loadRights(@Param(value="querySQL")String querySQL);
	
	@Select(value="${querySQL}")
    @Results(value={@Result(property="roleId",column="role_id"),
    		@Result(property="roleName",column="role_name"),
    		@Result(property="auditStatus",column="audit_status"),
    		@Result(property="isValid",column="is_valid"),
    		@Result(property="createDate",column="create_date"),
    		@Result(property="createUser",column="create_user"),
    		@Result(property="updateDate",column="update_date"),
    		@Result(property="updateUser",column="update_user")
    		})
	public List<SysRole> loadRoles(@Param(value="querySQL")String querySQL);

	@Select(value="${querySQL}")
	public int count(@Param(value="querySQL")String querySQL);
	
	/**
	 * select one role by role_id
	 * @param roleId
	 * @return
	 */
	@Select(value="select * from sys_role where role_id=#{roleId}")
    @Results(value={@Result(property="roleId",column="role_id"),
    		@Result(property="roleName",column="role_name"),
    		@Result(property="auditStatus",column="audit_status"),
    		@Result(property="isValid",column="is_valid"),
    		@Result(property="createDate",column="create_date"),
    		@Result(property="createUser",column="create_user"),
    		@Result(property="updateDate",column="update_date"),
    		@Result(property="updateUser",column="update_user")
    		})
	public SysRole selectOneRole(@Param(value="roleId")int roleId);
	
	/**
	 * select one role by roleName
	 * @param roleId
	 * @return
	 */
	@Select(value="select * from sys_role where role_name=#{roleName}")
    @Results(value={@Result(property="roleId",column="role_id"),
    		@Result(property="roleName",column="role_name"),
    		@Result(property="auditStatus",column="audit_status"),
    		@Result(property="isValid",column="is_valid"),
    		@Result(property="createDate",column="create_date"),
    		@Result(property="createUser",column="create_user"),
    		@Result(property="updateDate",column="update_date"),
    		@Result(property="updateUser",column="update_user")
    		})
	public SysRole selectByRoleName(@Param(value="roleName")String roleName);
	
	/**
	 * insert one role record to sys_role.
	 * @param role
	 */
	@Insert(value="insert into sys_role(role_id,role_name,audit_status,is_valid) values(#{roleId},#{roleName},#{auditStatus},#{isValid})")
	@Options(useGeneratedKeys = true, keyProperty = "roleId")
	public void insertOneRole(SysRole role);
	
	/**
	 * update role by role_id
	 * @param role
	 */
	@Update(value="update sys_role " +
			"set audit_status=#{auditStatus}," +
			"is_valid=#{isValid}, role_name=#{roleName}, " +
			"update_date=current_timestamp, update_user=#{updateUser} " +
			"where role_id=#{roleId}")
	public void updateRole(SysRole role);
	
	/**
	 * batch insert data to table sys_role_right.
	 * @param roleRights
	 */
	@InsertProvider(type=SysRoleRightProvider.class,method="batchInsertSysRoleRight")
	public void batchInsertRoleRights(List<SysRoleRight> roleRights);
	
	/**
	 * delete sys_role_rights by role_id;
	 * @param roleId
	 */
	@Delete(value="delete from sys_role_rights where role_id=#{roleId}")
	public void deleteRoleRights(@Param(value="roleId")int roleId);
	
	
}
