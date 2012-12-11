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
import org.wmichina.crm.entity.BizMaterial;
import org.wmichina.crm.entity.example.BizMaterialExample;
import org.wmichina.crm.provider.BizMaterialSqlProvider;

@Repository(value="bizMaterialMapper")
public interface BizMaterialMapper {
    @SelectProvider(type=BizMaterialSqlProvider.class, method="countByExample")
    int countByExample(BizMaterialExample example);

    @DeleteProvider(type=BizMaterialSqlProvider.class, method="deleteByExample")
    int deleteByExample(BizMaterialExample example);

    @Delete({
        "delete from biz_material",
        "where material_id = #{materialId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer materialId);

    @Insert({
        "insert into biz_material (material_id, material_code, ",
        "material_name, material_category, ",
        "material_class, material_type, ",
        "material_price, discount_1, ",
        "discount_reason_1, discount_2, ",
        "discount_reason_2, discount_3, ",
        "discount_reason_3, discount_4, ",
        "discount_reason_4, discount_5, ",
        "discount_reason_5, is_valid, ",
        "is_onsale, stock, on_date, ",
        "off_date, remark, create_date, ",
        "create_user, update_date, ",
        "update_user, description)",
        "values (#{materialId,jdbcType=INTEGER}, #{materialCode,jdbcType=VARCHAR}, ",
        "#{materialName,jdbcType=VARCHAR}, #{materialCategory,jdbcType=VARCHAR}, ",
        "#{materialClass,jdbcType=VARCHAR}, #{materialType,jdbcType=VARCHAR}, ",
        "#{materialPrice,jdbcType=DOUBLE}, #{discount1,jdbcType=DOUBLE}, ",
        "#{discountReason1,jdbcType=VARCHAR}, #{discount2,jdbcType=DOUBLE}, ",
        "#{discountReason2,jdbcType=VARCHAR}, #{discount3,jdbcType=DOUBLE}, ",
        "#{discountReason3,jdbcType=VARCHAR}, #{discount4,jdbcType=DOUBLE}, ",
        "#{discountReason4,jdbcType=VARCHAR}, #{discount5,jdbcType=DOUBLE}, ",
        "#{discountReason5,jdbcType=VARCHAR}, #{isValid,jdbcType=BIT}, ",
        "#{isOnsale,jdbcType=BIT}, #{stock,jdbcType=INTEGER}, #{onDate,jdbcType=DATE}, ",
        "#{offDate,jdbcType=DATE}, #{remark,jdbcType=VARCHAR}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{createUser,jdbcType=VARCHAR}, #{updateDate,jdbcType=TIMESTAMP}, ",
        "#{updateUser,jdbcType=VARCHAR}, #{description,jdbcType=LONGVARBINARY})"
    })
    @Options(useGeneratedKeys=true,keyProperty="materialId")
    int insert(BizMaterial record);

    @InsertProvider(type=BizMaterialSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="materialId")
    int insertSelective(BizMaterial record);

    @SelectProvider(type=BizMaterialSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="material_id", property="materialId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="material_code", property="materialCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_name", property="materialName", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_category", property="materialCategory", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_class", property="materialClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_type", property="materialType", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_price", property="materialPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_1", property="discount1", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_1", property="discountReason1", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_2", property="discount2", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_2", property="discountReason2", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_3", property="discount3", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_3", property="discountReason3", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_4", property="discount4", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_4", property="discountReason4", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_5", property="discount5", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_5", property="discountReason5", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="is_onsale", property="isOnsale", jdbcType=JdbcType.BIT),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="on_date", property="onDate", jdbcType=JdbcType.DATE),
        @Result(column="off_date", property="offDate", jdbcType=JdbcType.DATE),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<BizMaterial> selectByExampleWithBLOBs(BizMaterialExample example);

    @SelectProvider(type=BizMaterialSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="material_id", property="materialId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="material_code", property="materialCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_name", property="materialName", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_category", property="materialCategory", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_class", property="materialClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_type", property="materialType", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_price", property="materialPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_1", property="discount1", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_1", property="discountReason1", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_2", property="discount2", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_2", property="discountReason2", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_3", property="discount3", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_3", property="discountReason3", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_4", property="discount4", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_4", property="discountReason4", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_5", property="discount5", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_5", property="discountReason5", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="is_onsale", property="isOnsale", jdbcType=JdbcType.BIT),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="on_date", property="onDate", jdbcType=JdbcType.DATE),
        @Result(column="off_date", property="offDate", jdbcType=JdbcType.DATE),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR)
    })
    List<BizMaterial> selectByExample(BizMaterialExample example);

    @Select({
        "select",
        "material_id, material_code, material_name, material_category, material_class, ",
        "material_type, material_price, discount_1, discount_reason_1, discount_2, discount_reason_2, ",
        "discount_3, discount_reason_3, discount_4, discount_reason_4, discount_5, discount_reason_5, ",
        "is_valid, is_onsale, stock, on_date, off_date, remark, create_date, create_user, ",
        "update_date, update_user, description",
        "from biz_material",
        "where material_id = #{materialId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="material_id", property="materialId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="material_code", property="materialCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_name", property="materialName", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_category", property="materialCategory", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_class", property="materialClass", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_type", property="materialType", jdbcType=JdbcType.VARCHAR),
        @Result(column="material_price", property="materialPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_1", property="discount1", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_1", property="discountReason1", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_2", property="discount2", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_2", property="discountReason2", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_3", property="discount3", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_3", property="discountReason3", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_4", property="discount4", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_4", property="discountReason4", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_5", property="discount5", jdbcType=JdbcType.DOUBLE),
        @Result(column="discount_reason_5", property="discountReason5", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.BIT),
        @Result(column="is_onsale", property="isOnsale", jdbcType=JdbcType.BIT),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="on_date", property="onDate", jdbcType=JdbcType.DATE),
        @Result(column="off_date", property="offDate", jdbcType=JdbcType.DATE),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARBINARY)
    })
    BizMaterial selectByPrimaryKey(Integer materialId);

    @UpdateProvider(type=BizMaterialSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BizMaterial record, @Param("example") BizMaterialExample example);

    @UpdateProvider(type=BizMaterialSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") BizMaterial record, @Param("example") BizMaterialExample example);

    @UpdateProvider(type=BizMaterialSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BizMaterial record, @Param("example") BizMaterialExample example);

    @UpdateProvider(type=BizMaterialSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BizMaterial record);

    @Update({
        "update biz_material",
        "set material_code = #{materialCode,jdbcType=VARCHAR},",
          "material_name = #{materialName,jdbcType=VARCHAR},",
          "material_category = #{materialCategory,jdbcType=VARCHAR},",
          "material_class = #{materialClass,jdbcType=VARCHAR},",
          "material_type = #{materialType,jdbcType=VARCHAR},",
          "material_price = #{materialPrice,jdbcType=DOUBLE},",
          "discount_1 = #{discount1,jdbcType=DOUBLE},",
          "discount_reason_1 = #{discountReason1,jdbcType=VARCHAR},",
          "discount_2 = #{discount2,jdbcType=DOUBLE},",
          "discount_reason_2 = #{discountReason2,jdbcType=VARCHAR},",
          "discount_3 = #{discount3,jdbcType=DOUBLE},",
          "discount_reason_3 = #{discountReason3,jdbcType=VARCHAR},",
          "discount_4 = #{discount4,jdbcType=DOUBLE},",
          "discount_reason_4 = #{discountReason4,jdbcType=VARCHAR},",
          "discount_5 = #{discount5,jdbcType=DOUBLE},",
          "discount_reason_5 = #{discountReason5,jdbcType=VARCHAR},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "is_onsale = #{isOnsale,jdbcType=BIT},",
          "stock = #{stock,jdbcType=INTEGER},",
          "on_date = #{onDate,jdbcType=DATE},",
          "off_date = #{offDate,jdbcType=DATE},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=LONGVARBINARY}",
        "where material_id = #{materialId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(BizMaterial record);

    @Update({
        "update biz_material",
        "set material_code = #{materialCode,jdbcType=VARCHAR},",
          "material_name = #{materialName,jdbcType=VARCHAR},",
          "material_category = #{materialCategory,jdbcType=VARCHAR},",
          "material_class = #{materialClass,jdbcType=VARCHAR},",
          "material_type = #{materialType,jdbcType=VARCHAR},",
          "material_price = #{materialPrice,jdbcType=DOUBLE},",
          "discount_1 = #{discount1,jdbcType=DOUBLE},",
          "discount_reason_1 = #{discountReason1,jdbcType=VARCHAR},",
          "discount_2 = #{discount2,jdbcType=DOUBLE},",
          "discount_reason_2 = #{discountReason2,jdbcType=VARCHAR},",
          "discount_3 = #{discount3,jdbcType=DOUBLE},",
          "discount_reason_3 = #{discountReason3,jdbcType=VARCHAR},",
          "discount_4 = #{discount4,jdbcType=DOUBLE},",
          "discount_reason_4 = #{discountReason4,jdbcType=VARCHAR},",
          "discount_5 = #{discount5,jdbcType=DOUBLE},",
          "discount_reason_5 = #{discountReason5,jdbcType=VARCHAR},",
          "is_valid = #{isValid,jdbcType=BIT},",
          "is_onsale = #{isOnsale,jdbcType=BIT},",
          "stock = #{stock,jdbcType=INTEGER},",
          "on_date = #{onDate,jdbcType=DATE},",
          "off_date = #{offDate,jdbcType=DATE},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "create_user = #{createUser,jdbcType=VARCHAR},",
          "update_date = #{updateDate,jdbcType=TIMESTAMP},",
          "update_user = #{updateUser,jdbcType=VARCHAR}",
        "where material_id = #{materialId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BizMaterial record);
}