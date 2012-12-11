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

import org.wmichina.crm.entity.SysDailyJob;
import org.wmichina.crm.entity.example.SysDailyJobExample;
import org.wmichina.crm.entity.example.SysDailyJobExample.Criteria;
import org.wmichina.crm.entity.example.SysDailyJobExample.Criterion;

public class SysDailyJobSqlProvider {

    public String countByExample(SysDailyJobExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sys_daily_job");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(SysDailyJobExample example) {
        BEGIN();
        DELETE_FROM("sys_daily_job");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(SysDailyJob record) {
        BEGIN();
        INSERT_INTO("sys_daily_job");
        
        if (record.getJobId() != null) {
            VALUES("job_id", "#{jobId,jdbcType=INTEGER}");
        }
        
        if (record.getJobDepartment() != null) {
            VALUES("job_department", "#{jobDepartment,jdbcType=VARCHAR}");
        }
        
        if (record.getJobCode() != null) {
            VALUES("job_code", "#{jobCode,jdbcType=VARCHAR}");
        }
        
        if (record.getJobName() != null) {
            VALUES("job_name", "#{jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobVersion() != null) {
            VALUES("job_version", "#{jobVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getJobScore() != null) {
            VALUES("job_score", "#{jobScore,jdbcType=INTEGER}");
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

    public String selectByExampleWithBLOBs(SysDailyJobExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("job_id");
        } else {
            SELECT("job_id");
        }
        SELECT("job_department");
        SELECT("job_code");
        SELECT("job_name");
        SELECT("job_version");
        SELECT("job_score");
        SELECT("is_valid");
        SELECT("start_date");
        SELECT("end_date");
        SELECT("remark");
        SELECT("create_date");
        SELECT("create_user");
        SELECT("update_date");
        SELECT("update_user");
        SELECT("description");
        FROM("sys_daily_job");
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

    public String selectByExample(SysDailyJobExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("job_id");
        } else {
            SELECT("job_id");
        }
        SELECT("job_department");
        SELECT("job_code");
        SELECT("job_name");
        SELECT("job_version");
        SELECT("job_score");
        SELECT("is_valid");
        SELECT("start_date");
        SELECT("end_date");
        SELECT("remark");
        SELECT("create_date");
        SELECT("create_user");
        SELECT("update_date");
        SELECT("update_user");
        FROM("sys_daily_job");
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
        SysDailyJob record = (SysDailyJob) parameter.get("record");
        SysDailyJobExample example = (SysDailyJobExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sys_daily_job");
        
        if (record.getJobId() != null) {
            SET("job_id = #{record.jobId,jdbcType=INTEGER}");
        }
        
        if (record.getJobDepartment() != null) {
            SET("job_department = #{record.jobDepartment,jdbcType=VARCHAR}");
        }
        
        if (record.getJobCode() != null) {
            SET("job_code = #{record.jobCode,jdbcType=VARCHAR}");
        }
        
        if (record.getJobName() != null) {
            SET("job_name = #{record.jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobVersion() != null) {
            SET("job_version = #{record.jobVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getJobScore() != null) {
            SET("job_score = #{record.jobScore,jdbcType=INTEGER}");
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
        UPDATE("sys_daily_job");
        
        SET("job_id = #{record.jobId,jdbcType=INTEGER}");
        SET("job_department = #{record.jobDepartment,jdbcType=VARCHAR}");
        SET("job_code = #{record.jobCode,jdbcType=VARCHAR}");
        SET("job_name = #{record.jobName,jdbcType=VARCHAR}");
        SET("job_version = #{record.jobVersion,jdbcType=VARCHAR}");
        SET("job_score = #{record.jobScore,jdbcType=INTEGER}");
        SET("is_valid = #{record.isValid,jdbcType=BIT}");
        SET("start_date = #{record.startDate,jdbcType=DATE}");
        SET("end_date = #{record.endDate,jdbcType=DATE}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        SET("description = #{record.description,jdbcType=LONGVARBINARY}");
        
        SysDailyJobExample example = (SysDailyJobExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sys_daily_job");
        
        SET("job_id = #{record.jobId,jdbcType=INTEGER}");
        SET("job_department = #{record.jobDepartment,jdbcType=VARCHAR}");
        SET("job_code = #{record.jobCode,jdbcType=VARCHAR}");
        SET("job_name = #{record.jobName,jdbcType=VARCHAR}");
        SET("job_version = #{record.jobVersion,jdbcType=VARCHAR}");
        SET("job_score = #{record.jobScore,jdbcType=INTEGER}");
        SET("is_valid = #{record.isValid,jdbcType=BIT}");
        SET("start_date = #{record.startDate,jdbcType=DATE}");
        SET("end_date = #{record.endDate,jdbcType=DATE}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        SET("update_user = #{record.updateUser,jdbcType=VARCHAR}");
        
        SysDailyJobExample example = (SysDailyJobExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(SysDailyJob record) {
        BEGIN();
        UPDATE("sys_daily_job");
        
        if (record.getJobDepartment() != null) {
            SET("job_department = #{jobDepartment,jdbcType=VARCHAR}");
        }
        
        if (record.getJobCode() != null) {
            SET("job_code = #{jobCode,jdbcType=VARCHAR}");
        }
        
        if (record.getJobName() != null) {
            SET("job_name = #{jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getJobVersion() != null) {
            SET("job_version = #{jobVersion,jdbcType=VARCHAR}");
        }
        
        if (record.getJobScore() != null) {
            SET("job_score = #{jobScore,jdbcType=INTEGER}");
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
        
        WHERE("job_id = #{jobId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(SysDailyJobExample example, boolean includeExamplePhrase) {
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