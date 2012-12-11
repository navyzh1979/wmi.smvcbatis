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

import org.wmichina.crm.entity.StudentLogContact;
import org.wmichina.crm.entity.example.StudentLogContactExample;
import org.wmichina.crm.entity.example.StudentLogContactExample.Criteria;
import org.wmichina.crm.entity.example.StudentLogContactExample.Criterion;

public class StudentLogContactSqlProvider {

    public String countByExample(StudentLogContactExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("student_log_contact");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(StudentLogContactExample example) {
        BEGIN();
        DELETE_FROM("student_log_contact");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(StudentLogContact record) {
        BEGIN();
        INSERT_INTO("student_log_contact");
        
        if (record.getContactId() != null) {
            VALUES("contact_id", "#{contactId,jdbcType=BIGINT}");
        }
        
        if (record.getStudentId() != null) {
            VALUES("student_id", "#{studentId,jdbcType=BIGINT}");
        }
        
        if (record.getContactMode() != null) {
            VALUES("contact_mode", "#{contactMode,jdbcType=BIT}");
        }
        
        if (record.getContactSummary() != null) {
            VALUES("contact_summary", "#{contactSummary,jdbcType=VARCHAR}");
        }
        
        if (record.getContactBatchno() != null) {
            VALUES("contact_batchno", "#{contactBatchno,jdbcType=VARCHAR}");
        }
        
        if (record.getContactDate() != null) {
            VALUES("contact_date", "#{contactDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsAnswered() != null) {
            VALUES("is_answered", "#{isAnswered,jdbcType=BIT}");
        }
        
        if (record.getAnswerSummary() != null) {
            VALUES("answer_summary", "#{answerSummary,jdbcType=VARCHAR}");
        }
        
        if (record.getAnswerDate() != null) {
            VALUES("answer_date", "#{answerDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateDate() != null) {
            VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            VALUES("update_user", "#{updateUser,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(StudentLogContactExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("contact_id");
        } else {
            SELECT("contact_id");
        }
        SELECT("student_id");
        SELECT("contact_mode");
        SELECT("contact_summary");
        SELECT("contact_batchno");
        SELECT("contact_date");
        SELECT("is_answered");
        SELECT("answer_summary");
        SELECT("answer_date");
        SELECT("create_date");
        SELECT("create_user");
        SELECT("update_time");
        SELECT("update_user");
        FROM("student_log_contact");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        StudentLogContact record = (StudentLogContact) parameter.get("record");
        StudentLogContactExample example = (StudentLogContactExample) parameter.get("example");
        
        BEGIN();
        UPDATE("student_log_contact");
        
        if (record.getContactId() != null) {
            SET("contact_id = #{record.contactId,jdbcType=BIGINT}");
        }
        
        if (record.getStudentId() != null) {
            SET("student_id = #{record.studentId,jdbcType=BIGINT}");
        }
        
        if (record.getContactMode() != null) {
            SET("contact_mode = #{record.contactMode,jdbcType=BIT}");
        }
        
        if (record.getContactSummary() != null) {
            SET("contact_summary = #{record.contactSummary,jdbcType=VARCHAR}");
        }
        
        if (record.getContactBatchno() != null) {
            SET("contact_batchno = #{record.contactBatchno,jdbcType=VARCHAR}");
        }
        
        if (record.getContactDate() != null) {
            SET("contact_date = #{record.contactDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsAnswered() != null) {
            SET("is_answered = #{record.isAnswered,jdbcType=BIT}");
        }
        
        if (record.getAnswerSummary() != null) {
            SET("answer_summary = #{record.answerSummary,jdbcType=VARCHAR}");
        }
        
        if (record.getAnswerDate() != null) {
            SET("answer_date = #{record.answerDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("student_log_contact");
        
        SET("contact_id = #{record.contactId,jdbcType=BIGINT}");
        SET("student_id = #{record.studentId,jdbcType=BIGINT}");
        SET("contact_mode = #{record.contactMode,jdbcType=BIT}");
        SET("contact_summary = #{record.contactSummary,jdbcType=VARCHAR}");
        SET("contact_batchno = #{record.contactBatchno,jdbcType=VARCHAR}");
        SET("contact_date = #{record.contactDate,jdbcType=TIMESTAMP}");
        SET("is_answered = #{record.isAnswered,jdbcType=BIT}");
        SET("answer_summary = #{record.answerSummary,jdbcType=VARCHAR}");
        SET("answer_date = #{record.answerDate,jdbcType=TIMESTAMP}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        
        StudentLogContactExample example = (StudentLogContactExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(StudentLogContact record) {
        BEGIN();
        UPDATE("student_log_contact");
        
        if (record.getStudentId() != null) {
            SET("student_id = #{studentId,jdbcType=BIGINT}");
        }
        
        if (record.getContactMode() != null) {
            SET("contact_mode = #{contactMode,jdbcType=BIT}");
        }
        
        if (record.getContactSummary() != null) {
            SET("contact_summary = #{contactSummary,jdbcType=VARCHAR}");
        }
        
        if (record.getContactBatchno() != null) {
            SET("contact_batchno = #{contactBatchno,jdbcType=VARCHAR}");
        }
        
        if (record.getContactDate() != null) {
            SET("contact_date = #{contactDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsAnswered() != null) {
            SET("is_answered = #{isAnswered,jdbcType=BIT}");
        }
        
        if (record.getAnswerSummary() != null) {
            SET("answer_summary = #{answerSummary,jdbcType=VARCHAR}");
        }
        
        if (record.getAnswerDate() != null) {
            SET("answer_date = #{answerDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            SET("create_user = #{createUser,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateUser() != null) {
            SET("update_user = #{updateUser,jdbcType=VARCHAR}");
        }
        
        WHERE("contact_id = #{contactId,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(StudentLogContactExample example, boolean includeExamplePhrase) {
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