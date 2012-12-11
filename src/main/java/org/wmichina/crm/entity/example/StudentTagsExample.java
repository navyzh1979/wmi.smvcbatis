package org.wmichina.crm.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentTagsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentTagsExample() {
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

        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(Long value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(Long value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(Long value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(Long value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(Long value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<Long> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<Long> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(Long value1, Long value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(Long value1, Long value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoIsNull() {
            addCriterion("source_batchno is null");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoIsNotNull() {
            addCriterion("source_batchno is not null");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoEqualTo(String value) {
            addCriterion("source_batchno =", value, "sourceBatchno");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoNotEqualTo(String value) {
            addCriterion("source_batchno <>", value, "sourceBatchno");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoGreaterThan(String value) {
            addCriterion("source_batchno >", value, "sourceBatchno");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoGreaterThanOrEqualTo(String value) {
            addCriterion("source_batchno >=", value, "sourceBatchno");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoLessThan(String value) {
            addCriterion("source_batchno <", value, "sourceBatchno");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoLessThanOrEqualTo(String value) {
            addCriterion("source_batchno <=", value, "sourceBatchno");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoLike(String value) {
            addCriterion("source_batchno like", value, "sourceBatchno");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoNotLike(String value) {
            addCriterion("source_batchno not like", value, "sourceBatchno");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoIn(List<String> values) {
            addCriterion("source_batchno in", values, "sourceBatchno");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoNotIn(List<String> values) {
            addCriterion("source_batchno not in", values, "sourceBatchno");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoBetween(String value1, String value2) {
            addCriterion("source_batchno between", value1, value2, "sourceBatchno");
            return (Criteria) this;
        }

        public Criteria andSourceBatchnoNotBetween(String value1, String value2) {
            addCriterion("source_batchno not between", value1, value2, "sourceBatchno");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNull() {
            addCriterion("tag_id is null");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNotNull() {
            addCriterion("tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andTagIdEqualTo(Integer value) {
            addCriterion("tag_id =", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotEqualTo(Integer value) {
            addCriterion("tag_id <>", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThan(Integer value) {
            addCriterion("tag_id >", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag_id >=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThan(Integer value) {
            addCriterion("tag_id <", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThanOrEqualTo(Integer value) {
            addCriterion("tag_id <=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdIn(List<Integer> values) {
            addCriterion("tag_id in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotIn(List<Integer> values) {
            addCriterion("tag_id not in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdBetween(Integer value1, Integer value2) {
            addCriterion("tag_id between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tag_id not between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNull() {
            addCriterion("tag_name is null");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNotNull() {
            addCriterion("tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andTagNameEqualTo(String value) {
            addCriterion("tag_name =", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotEqualTo(String value) {
            addCriterion("tag_name <>", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThan(String value) {
            addCriterion("tag_name >", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("tag_name >=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThan(String value) {
            addCriterion("tag_name <", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThanOrEqualTo(String value) {
            addCriterion("tag_name <=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLike(String value) {
            addCriterion("tag_name like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotLike(String value) {
            addCriterion("tag_name not like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameIn(List<String> values) {
            addCriterion("tag_name in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotIn(List<String> values) {
            addCriterion("tag_name not in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameBetween(String value1, String value2) {
            addCriterion("tag_name between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotBetween(String value1, String value2) {
            addCriterion("tag_name not between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagDepartIsNull() {
            addCriterion("tag_depart is null");
            return (Criteria) this;
        }

        public Criteria andTagDepartIsNotNull() {
            addCriterion("tag_depart is not null");
            return (Criteria) this;
        }

        public Criteria andTagDepartEqualTo(String value) {
            addCriterion("tag_depart =", value, "tagDepart");
            return (Criteria) this;
        }

        public Criteria andTagDepartNotEqualTo(String value) {
            addCriterion("tag_depart <>", value, "tagDepart");
            return (Criteria) this;
        }

        public Criteria andTagDepartGreaterThan(String value) {
            addCriterion("tag_depart >", value, "tagDepart");
            return (Criteria) this;
        }

        public Criteria andTagDepartGreaterThanOrEqualTo(String value) {
            addCriterion("tag_depart >=", value, "tagDepart");
            return (Criteria) this;
        }

        public Criteria andTagDepartLessThan(String value) {
            addCriterion("tag_depart <", value, "tagDepart");
            return (Criteria) this;
        }

        public Criteria andTagDepartLessThanOrEqualTo(String value) {
            addCriterion("tag_depart <=", value, "tagDepart");
            return (Criteria) this;
        }

        public Criteria andTagDepartLike(String value) {
            addCriterion("tag_depart like", value, "tagDepart");
            return (Criteria) this;
        }

        public Criteria andTagDepartNotLike(String value) {
            addCriterion("tag_depart not like", value, "tagDepart");
            return (Criteria) this;
        }

        public Criteria andTagDepartIn(List<String> values) {
            addCriterion("tag_depart in", values, "tagDepart");
            return (Criteria) this;
        }

        public Criteria andTagDepartNotIn(List<String> values) {
            addCriterion("tag_depart not in", values, "tagDepart");
            return (Criteria) this;
        }

        public Criteria andTagDepartBetween(String value1, String value2) {
            addCriterion("tag_depart between", value1, value2, "tagDepart");
            return (Criteria) this;
        }

        public Criteria andTagDepartNotBetween(String value1, String value2) {
            addCriterion("tag_depart not between", value1, value2, "tagDepart");
            return (Criteria) this;
        }

        public Criteria andIsDefinedIsNull() {
            addCriterion("is_defined is null");
            return (Criteria) this;
        }

        public Criteria andIsDefinedIsNotNull() {
            addCriterion("is_defined is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefinedEqualTo(Integer value) {
            addCriterion("is_defined =", value, "isDefined");
            return (Criteria) this;
        }

        public Criteria andIsDefinedNotEqualTo(Integer value) {
            addCriterion("is_defined <>", value, "isDefined");
            return (Criteria) this;
        }

        public Criteria andIsDefinedGreaterThan(Integer value) {
            addCriterion("is_defined >", value, "isDefined");
            return (Criteria) this;
        }

        public Criteria andIsDefinedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_defined >=", value, "isDefined");
            return (Criteria) this;
        }

        public Criteria andIsDefinedLessThan(Integer value) {
            addCriterion("is_defined <", value, "isDefined");
            return (Criteria) this;
        }

        public Criteria andIsDefinedLessThanOrEqualTo(Integer value) {
            addCriterion("is_defined <=", value, "isDefined");
            return (Criteria) this;
        }

        public Criteria andIsDefinedIn(List<Integer> values) {
            addCriterion("is_defined in", values, "isDefined");
            return (Criteria) this;
        }

        public Criteria andIsDefinedNotIn(List<Integer> values) {
            addCriterion("is_defined not in", values, "isDefined");
            return (Criteria) this;
        }

        public Criteria andIsDefinedBetween(Integer value1, Integer value2) {
            addCriterion("is_defined between", value1, value2, "isDefined");
            return (Criteria) this;
        }

        public Criteria andIsDefinedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_defined not between", value1, value2, "isDefined");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
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