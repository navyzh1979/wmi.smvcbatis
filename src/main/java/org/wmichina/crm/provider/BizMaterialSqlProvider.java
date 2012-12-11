package org.wmichina.crm.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;
import java.util.Map;

import org.wmichina.crm.entity.BizMaterial;
import org.wmichina.crm.entity.example.BizMaterialExample;
import org.wmichina.crm.entity.example.BizMaterialExample.Criteria;
import org.wmichina.crm.entity.example.BizMaterialExample.Criterion;

public class BizMaterialSqlProvider {

    public String countByExample(BizMaterialExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("biz_material");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(BizMaterialExample example) {
        BEGIN();
        DELETE_FROM("biz_material");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(BizMaterial record) {
        BEGIN();
        INSERT_INTO("biz_material");
        
        if (record.getMaterialId() != null) {
            VALUES("material_id", "#{materialId,jdbcType=INTEGER}");
        }
        
        if (record.getMaterialCode() != null) {
            VALUES("material_code", "#{materialCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialName() != null) {
            VALUES("material_name", "#{materialName,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialCategory() != null) {
            VALUES("material_category", "#{materialCategory,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialClass() != null) {
            VALUES("material_class", "#{materialClass,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialType() != null) {
            VALUES("material_type", "#{materialType,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialPrice() != null) {
            VALUES("material_price", "#{materialPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscount1() != null) {
            VALUES("discount_1", "#{discount1,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason1() != null) {
            VALUES("discount_reason_1", "#{discountReason1,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount2() != null) {
            VALUES("discount_2", "#{discount2,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason2() != null) {
            VALUES("discount_reason_2", "#{discountReason2,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount3() != null) {
            VALUES("discount_3", "#{discount3,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason3() != null) {
            VALUES("discount_reason_3", "#{discountReason3,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount4() != null) {
            VALUES("discount_4", "#{discount4,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason4() != null) {
            VALUES("discount_reason_4", "#{discountReason4,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount5() != null) {
            VALUES("discount_5", "#{discount5,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason5() != null) {
            VALUES("discount_reason_5", "#{discountReason5,jdbcType=VARCHAR}");
        }
        
        if (record.getIsValid() != null) {
            VALUES("is_valid", "#{isValid,jdbcType=BIT}");
        }
        
        if (record.getIsOnsale() != null) {
            VALUES("is_onsale", "#{isOnsale,jdbcType=BIT}");
        }
        
        if (record.getStock() != null) {
            VALUES("stock", "#{stock,jdbcType=INTEGER}");
        }
        
        if (record.getOnDate() != null) {
            VALUES("on_date", "#{onDate,jdbcType=DATE}");
        }
        
        if (record.getOffDate() != null) {
            VALUES("off_date", "#{offDate,jdbcType=DATE}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            VALUES("update_date", "#{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            VALUES("update_user", "#{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=LONGVARBINARY}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(BizMaterialExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("material_id");
        } else {
            SELECT("material_id");
        }
        SELECT("material_code");
        SELECT("material_name");
        SELECT("material_category");
        SELECT("material_class");
        SELECT("material_type");
        SELECT("material_price");
        SELECT("discount_1");
        SELECT("discount_reason_1");
        SELECT("discount_2");
        SELECT("discount_reason_2");
        SELECT("discount_3");
        SELECT("discount_reason_3");
        SELECT("discount_4");
        SELECT("discount_reason_4");
        SELECT("discount_5");
        SELECT("discount_reason_5");
        SELECT("is_valid");
        SELECT("is_onsale");
        SELECT("stock");
        SELECT("on_date");
        SELECT("off_date");
        SELECT("remark");
        SELECT("create_date");
        SELECT("create_user");
        SELECT("update_date");
        SELECT("update_user");
        SELECT("description");
        FROM("biz_material");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        String limitSQL = " ";
        if(example.getStart()!=null && example.getEnd()!=null){
        	limitSQL =  limitSQL + "limit " + example.getStart() +"," + example.getEnd();
        }
        return SQL() + limitSQL;
    }

    public String selectByExample(BizMaterialExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("material_id");
        } else {
            SELECT("material_id");
        }
        SELECT("material_code");
        SELECT("material_name");
        SELECT("material_category");
        SELECT("material_class");
        SELECT("material_type");
        SELECT("material_price");
        SELECT("discount_1");
        SELECT("discount_reason_1");
        SELECT("discount_2");
        SELECT("discount_reason_2");
        SELECT("discount_3");
        SELECT("discount_reason_3");
        SELECT("discount_4");
        SELECT("discount_reason_4");
        SELECT("discount_5");
        SELECT("discount_reason_5");
        SELECT("is_valid");
        SELECT("is_onsale");
        SELECT("stock");
        SELECT("on_date");
        SELECT("off_date");
        SELECT("remark");
        SELECT("create_date");
        SELECT("create_user");
        SELECT("update_date");
        SELECT("update_user");
        FROM("biz_material");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        String limitSQL = " ";
        if(example.getStart()!=null && example.getEnd()!=null){
        	limitSQL =  limitSQL + "limit " + example.getStart() +"," + example.getEnd();
        }
        return SQL() + limitSQL;
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BizMaterial record = (BizMaterial) parameter.get("record");
        BizMaterialExample example = (BizMaterialExample) parameter.get("example");
        
        BEGIN();
        UPDATE("biz_material");
        
        if (record.getMaterialId() != null) {
            SET("material_id = #{record.materialId,jdbcType=INTEGER}");
        }
        
        if (record.getMaterialCode() != null) {
            SET("material_code = #{record.materialCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialName() != null) {
            SET("material_name = #{record.materialName,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialCategory() != null) {
            SET("material_category = #{record.materialCategory,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialClass() != null) {
            SET("material_class = #{record.materialClass,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialType() != null) {
            SET("material_type = #{record.materialType,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialPrice() != null) {
            SET("material_price = #{record.materialPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscount1() != null) {
            SET("discount_1 = #{record.discount1,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason1() != null) {
            SET("discount_reason_1 = #{record.discountReason1,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount2() != null) {
            SET("discount_2 = #{record.discount2,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason2() != null) {
            SET("discount_reason_2 = #{record.discountReason2,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount3() != null) {
            SET("discount_3 = #{record.discount3,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason3() != null) {
            SET("discount_reason_3 = #{record.discountReason3,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount4() != null) {
            SET("discount_4 = #{record.discount4,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason4() != null) {
            SET("discount_reason_4 = #{record.discountReason4,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount5() != null) {
            SET("discount_5 = #{record.discount5,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason5() != null) {
            SET("discount_reason_5 = #{record.discountReason5,jdbcType=VARCHAR}");
        }
        
        if (record.getIsValid() != null) {
            SET("is_valid = #{record.isValid,jdbcType=BIT}");
        }
        
        if (record.getIsOnsale() != null) {
            SET("is_onsale = #{record.isOnsale,jdbcType=BIT}");
        }
        
        if (record.getStock() != null) {
            SET("stock = #{record.stock,jdbcType=INTEGER}");
        }
        
        if (record.getOnDate() != null) {
            SET("on_date = #{record.onDate,jdbcType=DATE}");
        }
        
        if (record.getOffDate() != null) {
            SET("off_date = #{record.offDate,jdbcType=DATE}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=LONGVARBINARY}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("biz_material");
        
        SET("material_id = #{record.materialId,jdbcType=INTEGER}");
        SET("material_code = #{record.materialCode,jdbcType=VARCHAR}");
        SET("material_name = #{record.materialName,jdbcType=VARCHAR}");
        SET("material_category = #{record.materialCategory,jdbcType=VARCHAR}");
        SET("material_class = #{record.materialClass,jdbcType=VARCHAR}");
        SET("material_type = #{record.materialType,jdbcType=VARCHAR}");
        SET("material_price = #{record.materialPrice,jdbcType=DOUBLE}");
        SET("discount_1 = #{record.discount1,jdbcType=DOUBLE}");
        SET("discount_reason_1 = #{record.discountReason1,jdbcType=VARCHAR}");
        SET("discount_2 = #{record.discount2,jdbcType=DOUBLE}");
        SET("discount_reason_2 = #{record.discountReason2,jdbcType=VARCHAR}");
        SET("discount_3 = #{record.discount3,jdbcType=DOUBLE}");
        SET("discount_reason_3 = #{record.discountReason3,jdbcType=VARCHAR}");
        SET("discount_4 = #{record.discount4,jdbcType=DOUBLE}");
        SET("discount_reason_4 = #{record.discountReason4,jdbcType=VARCHAR}");
        SET("discount_5 = #{record.discount5,jdbcType=DOUBLE}");
        SET("discount_reason_5 = #{record.discountReason5,jdbcType=VARCHAR}");
        SET("is_valid = #{record.isValid,jdbcType=BIT}");
        SET("is_onsale = #{record.isOnsale,jdbcType=BIT}");
        SET("stock = #{record.stock,jdbcType=INTEGER}");
        SET("on_date = #{record.onDate,jdbcType=DATE}");
        SET("off_date = #{record.offDate,jdbcType=DATE}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        SET("description = #{record.description,jdbcType=LONGVARBINARY}");
        
        BizMaterialExample example = (BizMaterialExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("biz_material");
        
        SET("material_id = #{record.materialId,jdbcType=INTEGER}");
        SET("material_code = #{record.materialCode,jdbcType=VARCHAR}");
        SET("material_name = #{record.materialName,jdbcType=VARCHAR}");
        SET("material_category = #{record.materialCategory,jdbcType=VARCHAR}");
        SET("material_class = #{record.materialClass,jdbcType=VARCHAR}");
        SET("material_type = #{record.materialType,jdbcType=VARCHAR}");
        SET("material_price = #{record.materialPrice,jdbcType=DOUBLE}");
        SET("discount_1 = #{record.discount1,jdbcType=DOUBLE}");
        SET("discount_reason_1 = #{record.discountReason1,jdbcType=VARCHAR}");
        SET("discount_2 = #{record.discount2,jdbcType=DOUBLE}");
        SET("discount_reason_2 = #{record.discountReason2,jdbcType=VARCHAR}");
        SET("discount_3 = #{record.discount3,jdbcType=DOUBLE}");
        SET("discount_reason_3 = #{record.discountReason3,jdbcType=VARCHAR}");
        SET("discount_4 = #{record.discount4,jdbcType=DOUBLE}");
        SET("discount_reason_4 = #{record.discountReason4,jdbcType=VARCHAR}");
        SET("discount_5 = #{record.discount5,jdbcType=DOUBLE}");
        SET("discount_reason_5 = #{record.discountReason5,jdbcType=VARCHAR}");
        SET("is_valid = #{record.isValid,jdbcType=BIT}");
        SET("is_onsale = #{record.isOnsale,jdbcType=BIT}");
        SET("stock = #{record.stock,jdbcType=INTEGER}");
        SET("on_date = #{record.onDate,jdbcType=DATE}");
        SET("off_date = #{record.offDate,jdbcType=DATE}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        
        BizMaterialExample example = (BizMaterialExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(BizMaterial record) {
        BEGIN();
        UPDATE("biz_material");
        
        if (record.getMaterialCode() != null) {
            SET("material_code = #{materialCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialName() != null) {
            SET("material_name = #{materialName,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialCategory() != null) {
            SET("material_category = #{materialCategory,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialClass() != null) {
            SET("material_class = #{materialClass,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialType() != null) {
            SET("material_type = #{materialType,jdbcType=VARCHAR}");
        }
        
        if (record.getMaterialPrice() != null) {
            SET("material_price = #{materialPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscount1() != null) {
            SET("discount_1 = #{discount1,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason1() != null) {
            SET("discount_reason_1 = #{discountReason1,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount2() != null) {
            SET("discount_2 = #{discount2,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason2() != null) {
            SET("discount_reason_2 = #{discountReason2,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount3() != null) {
            SET("discount_3 = #{discount3,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason3() != null) {
            SET("discount_reason_3 = #{discountReason3,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount4() != null) {
            SET("discount_4 = #{discount4,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason4() != null) {
            SET("discount_reason_4 = #{discountReason4,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount5() != null) {
            SET("discount_5 = #{discount5,jdbcType=DOUBLE}");
        }
        
        if (record.getDiscountReason5() != null) {
            SET("discount_reason_5 = #{discountReason5,jdbcType=VARCHAR}");
        }
        
        if (record.getIsValid() != null) {
            SET("is_valid = #{isValid,jdbcType=BIT}");
        }
        
        if (record.getIsOnsale() != null) {
            SET("is_onsale = #{isOnsale,jdbcType=BIT}");
        }
        
        if (record.getStock() != null) {
            SET("stock = #{stock,jdbcType=INTEGER}");
        }
        
        if (record.getOnDate() != null) {
            SET("on_date = #{onDate,jdbcType=DATE}");
        }
        
        if (record.getOffDate() != null) {
            SET("off_date = #{offDate,jdbcType=DATE}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            SET("create_user = #{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            SET("update_date = #{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            SET("update_user = #{updateUser,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=LONGVARBINARY}");
        }
        
        WHERE("material_id = #{materialId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(BizMaterialExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}