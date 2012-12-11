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

import org.wmichina.crm.entity.StudentInfoMarketing;
import org.wmichina.crm.entity.example.StudentInfoMarketingExample;
import org.wmichina.crm.entity.example.StudentInfoMarketingExample.Criteria;
import org.wmichina.crm.entity.example.StudentInfoMarketingExample.Criterion;

public class StudentInfoMarketingSqlProvider {

    public String countByExample(StudentInfoMarketingExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("student_info_marketing");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(StudentInfoMarketingExample example) {
        BEGIN();
        DELETE_FROM("student_info_marketing");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(StudentInfoMarketing record) {
        BEGIN();
        INSERT_INTO("student_info_marketing");
        
        if (record.getStudentId() != null) {
            VALUES("student_id", "#{studentId,jdbcType=BIGINT}");
        }
        
        if (record.getSourceBatchno() != null) {
            VALUES("source_batchno", "#{sourceBatchno,jdbcType=VARCHAR}");
        }
        
        if (record.getIntendType() != null) {
            VALUES("intend_type", "#{intendType,jdbcType=BIT}");
        }
        
        if (record.getIntendCourse() != null) {
            VALUES("intend_course", "#{intendCourse,jdbcType=VARCHAR}");
        }
        
        if (record.getExamDate() != null) {
            VALUES("exam_date", "#{examDate,jdbcType=VARCHAR}");
        }
        
        if (record.getContactTried() != null) {
            VALUES("contact_tried", "#{contactTried,jdbcType=INTEGER}");
        }
        
        if (record.getContactAnswered() != null) {
            VALUES("contact_answered", "#{contactAnswered,jdbcType=INTEGER}");
        }
        
        if (record.getCreateDate() != null) {
            VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(StudentInfoMarketingExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("student_id");
        } else {
            SELECT("student_id");
        }
        SELECT("source_batchno");
        SELECT("intend_type");
        SELECT("intend_course");
        SELECT("exam_date");
        SELECT("contact_tried");
        SELECT("contact_answered");
        SELECT("create_date");
        SELECT("create_user");
        FROM("student_info_marketing");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        StudentInfoMarketing record = (StudentInfoMarketing) parameter.get("record");
        StudentInfoMarketingExample example = (StudentInfoMarketingExample) parameter.get("example");
        
        BEGIN();
        UPDATE("student_info_marketing");
        
        if (record.getStudentId() != null) {
            SET("student_id = #{record.studentId,jdbcType=BIGINT}");
        }
        
        if (record.getSourceBatchno() != null) {
            SET("source_batchno = #{record.sourceBatchno,jdbcType=VARCHAR}");
        }
        
        if (record.getIntendType() != null) {
            SET("intend_type = #{record.intendType,jdbcType=BIT}");
        }
        
        if (record.getIntendCourse() != null) {
            SET("intend_course = #{record.intendCourse,jdbcType=VARCHAR}");
        }
        
        if (record.getExamDate() != null) {
            SET("exam_date = #{record.examDate,jdbcType=VARCHAR}");
        }
        
        if (record.getContactTried() != null) {
            SET("contact_tried = #{record.contactTried,jdbcType=INTEGER}");
        }
        
        if (record.getContactAnswered() != null) {
            SET("contact_answered = #{record.contactAnswered,jdbcType=INTEGER}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("student_info_marketing");
        
        SET("student_id = #{record.studentId,jdbcType=BIGINT}");
        SET("source_batchno = #{record.sourceBatchno,jdbcType=VARCHAR}");
        SET("intend_type = #{record.intendType,jdbcType=BIT}");
        SET("intend_course = #{record.intendCourse,jdbcType=VARCHAR}");
        SET("exam_date = #{record.examDate,jdbcType=VARCHAR}");
        SET("contact_tried = #{record.contactTried,jdbcType=INTEGER}");
        SET("contact_answered = #{record.contactAnswered,jdbcType=INTEGER}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        
        StudentInfoMarketingExample example = (StudentInfoMarketingExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    protected void applyWhere(StudentInfoMarketingExample example, boolean includeExamplePhrase) {
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