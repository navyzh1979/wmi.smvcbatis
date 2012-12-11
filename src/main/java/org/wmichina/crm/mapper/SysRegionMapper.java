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
import org.wmichina.crm.entity.SysRegion;
import org.wmichina.crm.entity.example.SysRegionExample;
import org.wmichina.crm.provider.SysRegionSqlProvider;

@Repository(value="sysRegionMapper")

public interface SysRegionMapper {
    @SelectProvider(type = SysRegionSqlProvider.class, method = "countByExample")
	int countByExample(SysRegionExample example);

	@DeleteProvider(type = SysRegionSqlProvider.class, method = "deleteByExample")
	int deleteByExample(SysRegionExample example);

	@Delete({ "delete from sys_region", "where region_id = #{regionId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer regionId);

	@Insert({ "insert into sys_region (region_id, region_code, ", "region_name, region_level, ", "region_division, parent_code, ",
			"parent_name, is_valid, ", "create_date, create_user, ", "update_date, update_user, ", "remark)",
			"values (#{regionId,jdbcType=INTEGER}, #{regionCode,jdbcType=CHAR}, ", "#{regionName,jdbcType=VARCHAR}, #{regionLevel,jdbcType=BIT}, ",
			"#{regionDivision,jdbcType=VARCHAR}, #{parentCode,jdbcType=CHAR}, ", "#{parentName,jdbcType=VARCHAR}, #{isValid,jdbcType=BIT}, ",
			"#{createDate,jdbcType=TIMESTAMP}, #{createUser,jdbcType=VARCHAR}, ",
			"#{updateDate,jdbcType=TIMESTAMP}, #{updateUser,jdbcType=VARCHAR}, ", "#{remark,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys=true,keyProperty="regionId")
	int insert(SysRegion record);

	@InsertProvider(type = SysRegionSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="regionId")
	int insertSelective(SysRegion record);

	@SelectProvider(type = SysRegionSqlProvider.class, method = "selectByExample")
	@Results({ @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "region_code", property = "regionCode", jdbcType = JdbcType.CHAR),
			@Result(column = "region_name", property = "regionName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "region_level", property = "regionLevel", jdbcType = JdbcType.BIT),
			@Result(column = "region_division", property = "regionDivision", jdbcType = JdbcType.VARCHAR),
			@Result(column = "parent_code", property = "parentCode", jdbcType = JdbcType.CHAR),
			@Result(column = "parent_name", property = "parentName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_valid", property = "isValid", jdbcType = JdbcType.BIT),
			@Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "create_user", property = "createUser", jdbcType = JdbcType.VARCHAR),
			@Result(column = "update_date", property = "updateDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "update_user", property = "updateUser", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	List<SysRegion> selectByExample(SysRegionExample example);

	@Select({ "select", "region_id, region_code, region_name, region_level, region_division, parent_code, ",
			"parent_name, is_valid, create_date, create_user, update_date, update_user, remark", "from sys_region",
			"where region_id = #{regionId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "region_id", property = "regionId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "region_code", property = "regionCode", jdbcType = JdbcType.CHAR),
			@Result(column = "region_name", property = "regionName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "region_level", property = "regionLevel", jdbcType = JdbcType.BIT),
			@Result(column = "region_division", property = "regionDivision", jdbcType = JdbcType.VARCHAR),
			@Result(column = "parent_code", property = "parentCode", jdbcType = JdbcType.CHAR),
			@Result(column = "parent_name", property = "parentName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_valid", property = "isValid", jdbcType = JdbcType.BIT),
			@Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "create_user", property = "createUser", jdbcType = JdbcType.VARCHAR),
			@Result(column = "update_date", property = "updateDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "update_user", property = "updateUser", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	SysRegion selectByPrimaryKey(Integer regionId);

	@UpdateProvider(type = SysRegionSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") SysRegion record, @Param("example") SysRegionExample example);

	@UpdateProvider(type = SysRegionSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") SysRegion record, @Param("example") SysRegionExample example);

	@UpdateProvider(type = SysRegionSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(SysRegion record);

	@Update({ "update sys_region", "set region_code = #{regionCode,jdbcType=CHAR},", "region_name = #{regionName,jdbcType=VARCHAR},",
			"region_level = #{regionLevel,jdbcType=BIT},", "region_division = #{regionDivision,jdbcType=VARCHAR},",
			"parent_code = #{parentCode,jdbcType=CHAR},", "parent_name = #{parentName,jdbcType=VARCHAR},", "is_valid = #{isValid,jdbcType=BIT},",
			"create_date = #{createDate,jdbcType=TIMESTAMP},", "create_user = #{createUser,jdbcType=VARCHAR},",
			"update_date = #{updateDate,jdbcType=TIMESTAMP},", "update_user = #{updateUser,jdbcType=VARCHAR},",
			"remark = #{remark,jdbcType=VARCHAR}", "where region_id = #{regionId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(SysRegion record);


}