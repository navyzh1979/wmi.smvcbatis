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

import org.wmichina.crm.entity.SysNoticeRoles;
import org.wmichina.crm.entity.example.SysNoticeRolesExample;
import org.wmichina.crm.entity.example.SysNoticeRolesExample.Criteria;
import org.wmichina.crm.entity.example.SysNoticeRolesExample.Criterion;

public class SysNoticeRolesSqlProvider {

    public String countByExample(SysNoticeRolesExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sys_notice_roles");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(SysNoticeRolesExample example) {
        BEGIN();
        DELETE_FROM("sys_notice_roles");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(SysNoticeRoles record) {
        BEGIN();
        INSERT_INTO("sys_notice_roles");
        
        if (record.getNoticeRoleId() != null) {
            VALUES("notice_role_id", "#{noticeRoleId,jdbcType=INTEGER}");
        }
        
        if (record.getNoticeId() != null) {
            VALUES("notice_id", "#{noticeId,jdbcType=INTEGER}");
        }
        
        if (record.getRoleId() != null) {
            VALUES("role_id", "#{roleId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateDate() != null) {
            VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateNotice() != null) {
            VALUES("create_notice", "#{createNotice,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(SysNoticeRolesExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("notice_role_id");
        } else {
            SELECT("notice_role_id");
        }
        SELECT("notice_id");
        SELECT("role_id");
        SELECT("create_date");
        SELECT("create_notice");
        FROM("sys_notice_roles");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysNoticeRoles record = (SysNoticeRoles) parameter.get("record");
        SysNoticeRolesExample example = (SysNoticeRolesExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sys_notice_roles");
        
        if (record.getNoticeRoleId() != null) {
            SET("notice_role_id = #{record.noticeRoleId,jdbcType=INTEGER}");
        }
        
        if (record.getNoticeId() != null) {
            SET("notice_id = #{record.noticeId,jdbcType=INTEGER}");
        }
        
        if (record.getRoleId() != null) {
            SET("role_id = #{record.roleId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateNotice() != null) {
            SET("create_notice = #{record.createNotice,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sys_notice_roles");
        
        SET("notice_role_id = #{record.noticeRoleId,jdbcType=INTEGER}");
        SET("notice_id = #{record.noticeId,jdbcType=INTEGER}");
        SET("role_id = #{record.roleId,jdbcType=INTEGER}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("create_notice = #{record.createNotice,jdbcType=VARCHAR}");
        
        SysNoticeRolesExample example = (SysNoticeRolesExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(SysNoticeRoles record) {
        BEGIN();
        UPDATE("sys_notice_roles");
        
        if (record.getNoticeId() != null) {
            SET("notice_id = #{noticeId,jdbcType=INTEGER}");
        }
        
        if (record.getRoleId() != null) {
            SET("role_id = #{roleId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateNotice() != null) {
            SET("create_notice = #{createNotice,jdbcType=VARCHAR}");
        }
        
        WHERE("notice_role_id = #{noticeRoleId,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(SysNoticeRolesExample example, boolean includeExamplePhrase) {
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