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

import org.wmichina.crm.entity.StudentLogAssign;
import org.wmichina.crm.entity.example.StudentLogAssignExample;
import org.wmichina.crm.entity.example.StudentLogAssignExample.Criteria;
import org.wmichina.crm.entity.example.StudentLogAssignExample.Criterion;

public class StudentLogAssignSqlProvider {

    public String countByExample(StudentLogAssignExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("student_log_assign");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(StudentLogAssignExample example) {
        BEGIN();
        DELETE_FROM("student_log_assign");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(StudentLogAssign record) {
        BEGIN();
        INSERT_INTO("student_log_assign");
        
        if (record.getAssignId() != null) {
            VALUES("assign_id", "#{assignId,jdbcType=BIGINT}");
        }
        
        if (record.getStudentId() != null) {
            VALUES("student_id", "#{studentId,jdbcType=BIGINT}");
        }
        
        if (record.getDepartCode() != null) {
            VALUES("depart_code", "#{departCode,jdbcType=CHAR}");
        }
        
        if (record.getDepartName() != null) {
            VALUES("depart_name", "#{departName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobCode() != null) {
            VALUES("job_code", "#{jobCode,jdbcType=CHAR}");
        }
        
        if (record.getJobName() != null) {
            VALUES("job_name", "#{jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobDays() != null) {
            VALUES("job_days", "#{jobDays,jdbcType=INTEGER}");
        }
        
        if (record.getJobDeadline() != null) {
            VALUES("job_deadline", "#{jobDeadline,jdbcType=DATE}");
        }
        
        if (record.getAssignedTo() != null) {
            VALUES("assigned_to", "#{assignedTo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(StudentLogAssignExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("assign_id");
        } else {
            SELECT("assign_id");
        }
        SELECT("student_id");
        SELECT("depart_code");
        SELECT("depart_name");
        SELECT("job_code");
        SELECT("job_name");
        SELECT("job_days");
        SELECT("job_deadline");
        SELECT("assigned_to");
        SELECT("create_time");
        SELECT("create_user");
        FROM("student_log_assign");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        StudentLogAssign record = (StudentLogAssign) parameter.get("record");
        StudentLogAssignExample example = (StudentLogAssignExample) parameter.get("example");
        
        BEGIN();
        UPDATE("student_log_assign");
        
        if (record.getAssignId() != null) {
            SET("assign_id = #{record.assignId,jdbcType=BIGINT}");
        }
        
        if (record.getStudentId() != null) {
            SET("student_id = #{record.studentId,jdbcType=BIGINT}");
        }
        
        if (record.getDepartCode() != null) {
            SET("depart_code = #{record.departCode,jdbcType=CHAR}");
        }
        
        if (record.getDepartName() != null) {
            SET("depart_name = #{record.departName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobCode() != null) {
            SET("job_code = #{record.jobCode,jdbcType=CHAR}");
        }
        
        if (record.getJobName() != null) {
            SET("job_name = #{record.jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobDays() != null) {
            SET("job_days = #{record.jobDays,jdbcType=INTEGER}");
        }
        
        if (record.getJobDeadline() != null) {
            SET("job_deadline = #{record.jobDeadline,jdbcType=DATE}");
        }
        
        if (record.getAssignedTo() != null) {
            SET("assigned_to = #{record.assignedTo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUser() != null) {
            SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("student_log_assign");
        
        SET("assign_id = #{record.assignId,jdbcType=BIGINT}");
        SET("student_id = #{record.studentId,jdbcType=BIGINT}");
        SET("depart_code = #{record.departCode,jdbcType=CHAR}");
        SET("depart_name = #{record.departName,jdbcType=VARCHAR}");
        SET("job_code = #{record.jobCode,jdbcType=CHAR}");
        SET("job_name = #{record.jobName,jdbcType=VARCHAR}");
        SET("job_days = #{record.jobDays,jdbcType=INTEGER}");
        SET("job_deadline = #{record.jobDeadline,jdbcType=DATE}");
        SET("assigned_to = #{record.assignedTo,jdbcType=VARCHAR}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        
        StudentLogAssignExample example = (StudentLogAssignExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    protected void applyWhere(StudentLogAssignExample example, boolean includeExamplePhrase) {
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