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

import org.wmichina.crm.entity.SysConstant;
import org.wmichina.crm.entity.example.SysConstantExample;
import org.wmichina.crm.entity.example.SysConstantExample.Criteria;
import org.wmichina.crm.entity.example.SysConstantExample.Criterion;

public class SysConstantSqlProvider {

    public String countByExample(SysConstantExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sys_constant");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(SysConstantExample example) {
        BEGIN();
        DELETE_FROM("sys_constant");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(SysConstant record) {
        BEGIN();
        INSERT_INTO("sys_constant");
        
        if (record.getConstantId() != null) {
            VALUES("constant_id", "#{constantId,jdbcType=INTEGER}");
        }
        
        if (record.getConstantCode() != null) {
            VALUES("constant_code", "#{constantCode,jdbcType=CHAR}");
        }
        
        if (record.getConstantName() != null) {
            VALUES("constant_name", "#{constantName,jdbcType=VARCHAR}");
        }
        
        if (record.getConstantLevel() != null) {
            VALUES("constant_level", "#{constantLevel,jdbcType=BIT}");
        }
        
        if (record.getParentCode() != null) {
            VALUES("parent_code", "#{parentCode,jdbcType=CHAR}");
        }
        
        if (record.getParentName() != null) {
            VALUES("parent_name", "#{parentName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPredefined() != null) {
            VALUES("is_predefined", "#{isPredefined,jdbcType=BIT}");
        }
        
        if (record.getIsValid() != null) {
            VALUES("is_valid", "#{isValid,jdbcType=BIT}");
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
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(SysConstantExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("constant_id");
        } else {
            SELECT("constant_id");
        }
        SELECT("constant_code");
        SELECT("constant_name");
        SELECT("constant_level");
        SELECT("parent_code");
        SELECT("parent_name");
        SELECT("is_predefined");
        SELECT("is_valid");
        SELECT("create_date");
        SELECT("create_user");
        SELECT("update_date");
        SELECT("update_user");
        SELECT("remark");
        FROM("sys_constant");
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
        SysConstant record = (SysConstant) parameter.get("record");
        SysConstantExample example = (SysConstantExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sys_constant");
        
        if (record.getConstantId() != null) {
            SET("constant_id = #{record.constantId,jdbcType=INTEGER}");
        }
        
        if (record.getConstantCode() != null) {
            SET("constant_code = #{record.constantCode,jdbcType=CHAR}");
        }
        
        if (record.getConstantName() != null) {
            SET("constant_name = #{record.constantName,jdbcType=VARCHAR}");
        }
        
        if (record.getConstantLevel() != null) {
            SET("constant_level = #{record.constantLevel,jdbcType=BIT}");
        }
        
        if (record.getParentCode() != null) {
            SET("parent_code = #{record.parentCode,jdbcType=CHAR}");
        }
        
        if (record.getParentName() != null) {
            SET("parent_name = #{record.parentName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPredefined() != null) {
            SET("is_predefined = #{record.isPredefined,jdbcType=BIT}");
        }
        
        if (record.getIsValid() != null) {
            SET("is_valid = #{record.isValid,jdbcType=BIT}");
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
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sys_constant");
        
        SET("constant_id = #{record.constantId,jdbcType=INTEGER}");
        SET("constant_code = #{record.constantCode,jdbcType=CHAR}");
        SET("constant_name = #{record.constantName,jdbcType=VARCHAR}");
        SET("constant_level = #{record.constantLevel,jdbcType=BIT}");
        SET("parent_code = #{record.parentCode,jdbcType=CHAR}");
        SET("parent_name = #{record.parentName,jdbcType=VARCHAR}");
        SET("is_predefined = #{record.isPredefined,jdbcType=BIT}");
        SET("is_valid = #{record.isValid,jdbcType=BIT}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        
        SysConstantExample example = (SysConstantExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(SysConstant record) {
        BEGIN();
        UPDATE("sys_constant");
        
        if (record.getConstantCode() != null) {
            SET("constant_code = #{constantCode,jdbcType=CHAR}");
        }
        
        if (record.getConstantName() != null) {
            SET("constant_name = #{constantName,jdbcType=VARCHAR}");
        }
        
        if (record.getConstantLevel() != null) {
            SET("constant_level = #{constantLevel,jdbcType=BIT}");
        }
        
        if (record.getParentCode() != null) {
            SET("parent_code = #{parentCode,jdbcType=CHAR}");
        }
        
        if (record.getParentName() != null) {
            SET("parent_name = #{parentName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPredefined() != null) {
            SET("is_predefined = #{isPredefined,jdbcType=BIT}");
        }
        
        if (record.getIsValid() != null) {
            SET("is_valid = #{isValid,jdbcType=BIT}");
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
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        WHERE("constant_id = #{constantId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(SysConstantExample example, boolean includeExamplePhrase) {
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