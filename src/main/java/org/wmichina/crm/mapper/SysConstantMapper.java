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
import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.entity.SysConstantOption;
import org.wmichina.crm.entity.example.SysConstantExample;
import org.wmichina.crm.provider.SysConstantSqlProvider;

@Repository(value="sysConstantMapper")
public interface SysConstantMapper {
	
	@Select(value="select  c.constant_id as optionId,c.constant_code as optionCode, c.constant_name as optionName," +
			" b.constant_code as attrCode, b.constant_name as attrName, a.constant_code as entityCode, a.constant_name as entityName," +
			" c.is_predefined as isPredefined, c.is_valid as isValid, c.create_user as createUser, c.create_date as createDate," +
			" c.update_user as updateUser, c.update_date as updateDate, c.remark" +
			" from sys_constant c " +
			"right join sys_constant b  on c.parent_code=b.constant_code " +
			"right join sys_constant a  on b.parent_code=a.constant_code " +
			"where c.constant_level=3 and c.is_predefined=0 order by optionId desc " +
			"limit #{start}, #{end}")
	@Results(value={@Result(property="optionId"),
			@Result(property="optionCode"),
			@Result(property="optionName"),
			@Result(property="attrCode"),
			@Result(property="attrName"),
			@Result(property="entityCode"),
			@Result(property="entityName"),
			@Result(property="isPredefined"),
			@Result(property="isValid"),
			@Result(property="createUser"),
			@Result(property="createDate"),
			@Result(property="updateUser"),
			@Result(property="updateDate"),
			@Result(property="remark")})
	public List<SysConstantOption> loadOptions(@Param(value="start")int start,@Param(value="end")int end);
	
	@Select(value="select * from sys_constant")
	@Results(value={@Result(property="constantId",column="constant_id"),
    		@Result(property="constantCode",column="constant_code"),
    		@Result(property="constantName",column="constant_name"),
    		@Result(property="constantLevel",column="constant_level"),
    		@Result(property="parentCode",column="parent_code"),
    		@Result(property="parentName",column="parent_name"),
    		@Result(property="isPredefined",column="is_predefined"),
    		@Result(property="isValid",column="is_valid"),
    		@Result(property="createDate",column="create_date"),
    		@Result(property="createUser",column="create_user"),
    		@Result(property="updateDate",column="update_date"),
    		@Result(property="updateUser",column="update_user"),
    		@Result(property="remark",column="remark")})
	public List<SysConstant> loadConstants();
	
	@Select(value="select * from sys_constant where constant_level=#{constantLevel}")
	@Results(value={@Result(property="constantId",column="constant_id"),
    		@Result(property="constantCode",column="constant_code"),
    		@Result(property="constantName",column="constant_name"),
    		@Result(property="constantLevel",column="constant_level"),
    		@Result(property="parentCode",column="parent_code"),
    		@Result(property="parentName",column="parent_name"),
    		@Result(property="isPredefined",column="is_predefined"),
    		@Result(property="isValid",column="is_valid"),
    		@Result(property="createDate",column="create_date"),
    		@Result(property="createUser",column="create_user"),
    		@Result(property="updateDate",column="update_date"),
    		@Result(property="updateUser",column="update_user"),
    		@Result(property="remark",column="remark")})
	public List<SysConstant> queryByLevel(@Param(value="constantLevel")int level);
	

	@Select(value="select * from sys_constant where constant_code=#{constantCode}")
	@Results(value={@Result(property="constantId",column="constant_id"),
    		@Result(property="constantCode",column="constant_code"),
    		@Result(property="constantName",column="constant_name"),
    		@Result(property="constantLevel",column="constant_level"),
    		@Result(property="parentCode",column="parent_code"),
    		@Result(property="parentName",column="parent_name"),
    		@Result(property="isPredefined",column="is_predefined"),
    		@Result(property="isValid",column="is_valid"),
    		@Result(property="createDate",column="create_date"),
    		@Result(property="createUser",column="create_user"),
    		@Result(property="updateDate",column="update_date"),
    		@Result(property="updateUser",column="update_user"),
    		@Result(property="remark",column="remark")})
	public SysConstant selectOneConstant(@Param(value="constantCode")String constantCode);
	
	@Select(value="select * from sys_constant where parent_code=#{parentCode}")
	@Results(value={@Result(property="constantId",column="constant_id"),
    		@Result(property="constantCode",column="constant_code"),
    		@Result(property="constantName",column="constant_name"),
    		@Result(property="constantLevel",column="constant_level"),
    		@Result(property="parentCode",column="parent_code"),
    		@Result(property="parentName",column="parent_name"),
    		@Result(property="isPredefined",column="is_predefined"),
    		@Result(property="isValid",column="is_valid"),
    		@Result(property="createDate",column="create_date"),
    		@Result(property="createUser",column="create_user"),
    		@Result(property="updateDate",column="update_date"),
    		@Result(property="updateUser",column="update_user"),
    		@Result(property="remark",column="remark")})
	public List<SysConstant> queryByParentCode(@Param(value="parentCode")String parentCode);
	
	@Select(value="select max(constant_code) from sys_constant where parent_code=#{parentCode}")
	public String getMaxCode(@Param(value="parentCode")String parentCode);
	
	@Insert(value="insert into sys_constant(constant_id,constant_code,constant_name,constant_level,parent_code,parent_name,is_predefined,is_valid,create_user,remark) " +
			"values(#{constantId},#{constantCode},#{constantName},#{constantLevel},#{parentCode},#{parentName},#{isPredefined},#{isValid},#{createUser},#{remark})")
	@Options(useGeneratedKeys = true, keyProperty = "constantId")
	public void insertOneConstant(SysConstant constant);


    @SelectProvider(type=SysConstantSqlProvider.class, method="countByExample")
    int countByExample(SysConstantExample example);

    @DeleteProvider(type=SysConstantSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysConstantExample example);

    @Delete({
        "delete from sys_constant",
        "where constant_id = #{constantId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer constantId);

    @Insert({
        "insert into sys_constant (constant_id, constant_code, ",
        "constant_name, constant_level, ",
        "parent_code, parent_name, ",
        "is_predefined, is_valid, create_date, ",
        "create_user, update_date, ",
        "update_user, remark)",
        "values (#{constantId,jdbcType=INTEGER}, #{constantCode,jdbcType=CHAR}, ",
        "#{constantName,jdbcType=VARCHAR}, #{constantLevel,jdbcType=BIT}, ",
        "#{parentCode,jdbcType=CHAR}, #{parentName,jdbcType=VARCHAR}, ",
        "#{isPredefined,jdbcType=BIT}, #{isValid,jdbcType=BIT}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{updateUser,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(SysConstant record);

    @InsertProvider(type=SysConstantSqlProvider.class, method="insertSelective")
    int insertSelective(SysConstant record);

    @SelectProvider(type=SysConstantSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="constant_id", property="constantId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="constant_code", property="constantCode", jdbcType=JdbcType.CHAR),
        @Result(column="constant_name", property="constantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="constant_level", property="constantLevel", jdbcType=JdbcType.BIT),
        @Result(column="parent_code", property="parentCode", jdbcType=JdbcType.CHAR),
        @Result(column="parent_name", property="parentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_predefined", property="isPredefined", jdbcType=JdbcType.BIT),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<SysConstant> selectByExample(SysConstantExample example);

    @Select({
        "select",
        "constant_id, constant_code, constant_name, constant_level, parent_code, parent_name, ",
        "is_predefined, is_valid, create_date, create_user, update_date, update_user, ",
        "remark",
        "from sys_constant",
        "where constant_id = #{constantId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="constant_id", property="constantId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="constant_code", property="constantCode", jdbcType=JdbcType.CHAR),
        @Result(column="constant_name", property="constantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="constant_level", property="constantLevel", jdbcType=JdbcType.BIT),
        @Result(column="parent_code", property="parentCode", jdbcType=JdbcType.CHAR),
        @Result(column="parent_name", property="parentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_predefined", property="isPredefined", jdbcType=JdbcType.BIT),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    SysConstant selectByPrimaryKey(Integer constantId);

    @UpdateProvider(type=SysConstantSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysConstant record, @Param("example") SysConstantExample example);

    @UpdateProvider(type=SysConstantSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysConstant record, @Param("example") SysConstantExample example);

    @UpdateProvider(type=SysConstantSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysConstant record);

    @Update({
        "update sys_constant",
        "set constant_code = #{constantCode,jdbcType=CHAR},",
          "constant_name = #{constantName,jdbcType=VARCHAR},",
          "constant_level = #{constantLevel,jdbcType=BIT},",
          "parent_code = #{parentCode,jdbcType=CHAR},",
          "parent_name = #{parentName,jdbcType=VARCHAR},",
          "is_predefined = #{isPredefined,jdbcType=BIT},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where constant_id = #{constantId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysConstant record);
}
