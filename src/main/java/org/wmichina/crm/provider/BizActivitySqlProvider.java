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

import org.wmichina.crm.entity.BizActivity;
import org.wmichina.crm.entity.example.BizActivityExample;
import org.wmichina.crm.entity.example.BizActivityExample.Criteria;
import org.wmichina.crm.entity.example.BizActivityExample.Criterion;

public class BizActivitySqlProvider {

    public String countByExample(BizActivityExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("biz_activity");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(BizActivityExample example) {
        BEGIN();
        DELETE_FROM("biz_activity");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(BizActivity record) {
        BEGIN();
        INSERT_INTO("biz_activity");
        
        if (record.getActivityId() != null) {
            VALUES("activity_id", "#{activityId,jdbcType=INTEGER}");
        }
        
        if (record.getActivityCode() != null) {
            VALUES("activity_code", "#{activityCode,jdbcType=VARCHAR}");
        }
        
        if (record.getActivityName() != null) {
            VALUES("activity_name", "#{activityName,jdbcType=VARCHAR}");
        }
        
        if (record.getActivityClass1() != null) {
            VALUES("activity_class_1", "#{activityClass1,jdbcType=VARCHAR}");
        }
        
        if (record.getActivityClass2() != null) {
            VALUES("activity_class_2", "#{activityClass2,jdbcType=VARCHAR}");
        }
        
        if (record.getActivityClass3() != null) {
            VALUES("activity_class_3", "#{activityClass3,jdbcType=VARCHAR}");
        }
        
        if (record.getIsValid() != null) {
            VALUES("is_valid", "#{isValid,jdbcType=BIT}");
        }
        
        if (record.getStartDate() != null) {
            VALUES("start_date", "#{startDate,jdbcType=DATE}");
        }
        
        if (record.getEndDate() != null) {
            VALUES("end_date", "#{endDate,jdbcType=DATE}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
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
        
        return SQL();
    }

    public String selectByExample(BizActivityExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("activity_id");
        } else {
            SELECT("activity_id");
        }
        SELECT("activity_code");
        SELECT("activity_name");
        SELECT("activity_class_1");
        SELECT("activity_class_2");
        SELECT("activity_class_3");
        SELECT("is_valid");
        SELECT("start_date");
        SELECT("end_date");
        SELECT("description");
        SELECT("create_date");
        SELECT("create_user");
        SELECT("update_date");
        SELECT("update_user");
        FROM("biz_activity");
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
        BizActivity record = (BizActivity) parameter.get("record");
        BizActivityExample example = (BizActivityExample) parameter.get("example");
        
        BEGIN();
        UPDATE("biz_activity");
        
        if (record.getActivityId() != null) {
            SET("activity_id = #{record.activityId,jdbcType=INTEGER}");
        }
        
        if (record.getActivityCode() != null) {
            SET("activity_code = #{record.activityCode,jdbcType=VARCHAR}");
        }
        
        if (record.getActivityName() != null) {
            SET("activity_name = #{record.activityName,jdbcType=VARCHAR}");
        }
        
        if (record.getActivityClass1() != null) {
            SET("activity_class_1 = #{record.activityClass1,jdbcType=VARCHAR}");
        }
        
        if (record.getActivityClass2() != null) {
            SET("activity_class_2 = #{record.activityClass2,jdbcType=VARCHAR}");
        }
        
        if (record.getActivityClass3() != null) {
            SET("activity_class_3 = #{record.activityClass3,jdbcType=VARCHAR}");
        }
        
        if (record.getIsValid() != null) {
            SET("is_valid = #{record.isValid,jdbcType=BIT}");
        }
        
        if (record.getStartDate() != null) {
            SET("start_date = #{record.startDate,jdbcType=DATE}");
        }
        
        if (record.getEndDate() != null) {
            SET("end_date = #{record.endDate,jdbcType=DATE}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=VARCHAR}");
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
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("biz_activity");
        
        SET("activity_id = #{record.activityId,jdbcType=INTEGER}");
        SET("activity_code = #{record.activityCode,jdbcType=VARCHAR}");
        SET("activity_name = #{record.activityName,jdbcType=VARCHAR}");
        SET("activity_class_1 = #{record.activityClass1,jdbcType=VARCHAR}");
        SET("activity_class_2 = #{record.activityClass2,jdbcType=VARCHAR}");
        SET("activity_class_3 = #{record.activityClass3,jdbcType=VARCHAR}");
        SET("is_valid = #{record.isValid,jdbcType=BIT}");
        SET("start_date = #{record.startDate,jdbcType=DATE}");
        SET("end_date = #{record.endDate,jdbcType=DATE}");
        SET("description = #{record.description,jdbcType=VARCHAR}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        
        BizActivityExample example = (BizActivityExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(BizActivity record) {
        BEGIN();
        UPDATE("biz_activity");
        
        if (record.getActivityCode() != null) {
            SET("activity_code = #{activityCode,jdbcType=VARCHAR}");
        }
        
        if (record.getActivityName() != null) {
            SET("activity_name = #{activityName,jdbcType=VARCHAR}");
        }
        
        if (record.getActivityClass1() != null) {
            SET("activity_class_1 = #{activityClass1,jdbcType=VARCHAR}");
        }
        
        if (record.getActivityClass2() != null) {
            SET("activity_class_2 = #{activityClass2,jdbcType=VARCHAR}");
        }
        
        if (record.getActivityClass3() != null) {
            SET("activity_class_3 = #{activityClass3,jdbcType=VARCHAR}");
        }
        
        if (record.getIsValid() != null) {
            SET("is_valid = #{isValid,jdbcType=BIT}");
        }
        
        if (record.getStartDate() != null) {
            SET("start_date = #{startDate,jdbcType=DATE}");
        }
        
        if (record.getEndDate() != null) {
            SET("end_date = #{endDate,jdbcType=DATE}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
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
        
        WHERE("activity_id = #{activityId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(BizActivityExample example, boolean includeExamplePhrase) {
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