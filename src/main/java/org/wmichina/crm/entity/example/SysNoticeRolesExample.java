package org.wmichina.crm.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysNoticeRolesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysNoticeRolesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNoticeRoleIdIsNull() {
            addCriterion("notice_role_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticeRoleIdIsNotNull() {
            addCriterion("notice_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeRoleIdEqualTo(Integer value) {
            addCriterion("notice_role_id =", value, "noticeRoleId");
            return (Criteria) this;
        }

        public Criteria andNoticeRoleIdNotEqualTo(Integer value) {
            addCriterion("notice_role_id <>", value, "noticeRoleId");
            return (Criteria) this;
        }

        public Criteria andNoticeRoleIdGreaterThan(Integer value) {
            addCriterion("notice_role_id >", value, "noticeRoleId");
            return (Criteria) this;
        }

        public Criteria andNoticeRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_role_id >=", value, "noticeRoleId");
            return (Criteria) this;
        }

        public Criteria andNoticeRoleIdLessThan(Integer value) {
            addCriterion("notice_role_id <", value, "noticeRoleId");
            return (Criteria) this;
        }

        public Criteria andNoticeRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("notice_role_id <=", value, "noticeRoleId");
            return (Criteria) this;
        }

        public Criteria andNoticeRoleIdIn(List<Integer> values) {
            addCriterion("notice_role_id in", values, "noticeRoleId");
            return (Criteria) this;
        }

        public Criteria andNoticeRoleIdNotIn(List<Integer> values) {
            addCriterion("notice_role_id not in", values, "noticeRoleId");
            return (Criteria) this;
        }

        public Criteria andNoticeRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("notice_role_id between", value1, value2, "noticeRoleId");
            return (Criteria) this;
        }

        public Criteria andNoticeRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_role_id not between", value1, value2, "noticeRoleId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIsNull() {
            addCriterion("notice_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIsNotNull() {
            addCriterion("notice_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdEqualTo(Integer value) {
            addCriterion("notice_id =", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotEqualTo(Integer value) {
            addCriterion("notice_id <>", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThan(Integer value) {
            addCriterion("notice_id >", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_id >=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThan(Integer value) {
            addCriterion("notice_id <", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThanOrEqualTo(Integer value) {
            addCriterion("notice_id <=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIn(List<Integer> values) {
            addCriterion("notice_id in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotIn(List<Integer> values) {
            addCriterion("notice_id not in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdBetween(Integer value1, Integer value2) {
            addCriterion("notice_id between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_id not between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeIsNull() {
            addCriterion("create_notice is null");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeIsNotNull() {
            addCriterion("create_notice is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeEqualTo(String value) {
            addCriterion("create_notice =", value, "createNotice");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeNotEqualTo(String value) {
            addCriterion("create_notice <>", value, "createNotice");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeGreaterThan(String value) {
            addCriterion("create_notice >", value, "createNotice");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("create_notice >=", value, "createNotice");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeLessThan(String value) {
            addCriterion("create_notice <", value, "createNotice");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeLessThanOrEqualTo(String value) {
            addCriterion("create_notice <=", value, "createNotice");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeLike(String value) {
            addCriterion("create_notice like", value, "createNotice");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeNotLike(String value) {
            addCriterion("create_notice not like", value, "createNotice");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeIn(List<String> values) {
            addCriterion("create_notice in", values, "createNotice");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeNotIn(List<String> values) {
            addCriterion("create_notice not in", values, "createNotice");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeBetween(String value1, String value2) {
            addCriterion("create_notice between", value1, value2, "createNotice");
            return (Criteria) this;
        }

        public Criteria andCreateNoticeNotBetween(String value1, String value2) {
            addCriterion("create_notice not between", value1, value2, "createNotice");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}