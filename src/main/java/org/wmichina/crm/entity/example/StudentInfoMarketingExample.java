package org.wmichina.crm.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentInfoMarketingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentInfoMarketingExample() {
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

        public Criteria andIntendTypeIsNull() {
            addCriterion("intend_type is null");
            return (Criteria) this;
        }

        public Criteria andIntendTypeIsNotNull() {
            addCriterion("intend_type is not null");
            return (Criteria) this;
        }

        public Criteria andIntendTypeEqualTo(Integer value) {
            addCriterion("intend_type =", value, "intendType");
            return (Criteria) this;
        }

        public Criteria andIntendTypeNotEqualTo(Integer value) {
            addCriterion("intend_type <>", value, "intendType");
            return (Criteria) this;
        }

        public Criteria andIntendTypeGreaterThan(Integer value) {
            addCriterion("intend_type >", value, "intendType");
            return (Criteria) this;
        }

        public Criteria andIntendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("intend_type >=", value, "intendType");
            return (Criteria) this;
        }

        public Criteria andIntendTypeLessThan(Integer value) {
            addCriterion("intend_type <", value, "intendType");
            return (Criteria) this;
        }

        public Criteria andIntendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("intend_type <=", value, "intendType");
            return (Criteria) this;
        }

        public Criteria andIntendTypeIn(List<Integer> values) {
            addCriterion("intend_type in", values, "intendType");
            return (Criteria) this;
        }

        public Criteria andIntendTypeNotIn(List<Integer> values) {
            addCriterion("intend_type not in", values, "intendType");
            return (Criteria) this;
        }

        public Criteria andIntendTypeBetween(Integer value1, Integer value2) {
            addCriterion("intend_type between", value1, value2, "intendType");
            return (Criteria) this;
        }

        public Criteria andIntendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("intend_type not between", value1, value2, "intendType");
            return (Criteria) this;
        }

        public Criteria andIntendCourseIsNull() {
            addCriterion("intend_course is null");
            return (Criteria) this;
        }

        public Criteria andIntendCourseIsNotNull() {
            addCriterion("intend_course is not null");
            return (Criteria) this;
        }

        public Criteria andIntendCourseEqualTo(String value) {
            addCriterion("intend_course =", value, "intendCourse");
            return (Criteria) this;
        }

        public Criteria andIntendCourseNotEqualTo(String value) {
            addCriterion("intend_course <>", value, "intendCourse");
            return (Criteria) this;
        }

        public Criteria andIntendCourseGreaterThan(String value) {
            addCriterion("intend_course >", value, "intendCourse");
            return (Criteria) this;
        }

        public Criteria andIntendCourseGreaterThanOrEqualTo(String value) {
            addCriterion("intend_course >=", value, "intendCourse");
            return (Criteria) this;
        }

        public Criteria andIntendCourseLessThan(String value) {
            addCriterion("intend_course <", value, "intendCourse");
            return (Criteria) this;
        }

        public Criteria andIntendCourseLessThanOrEqualTo(String value) {
            addCriterion("intend_course <=", value, "intendCourse");
            return (Criteria) this;
        }

        public Criteria andIntendCourseLike(String value) {
            addCriterion("intend_course like", value, "intendCourse");
            return (Criteria) this;
        }

        public Criteria andIntendCourseNotLike(String value) {
            addCriterion("intend_course not like", value, "intendCourse");
            return (Criteria) this;
        }

        public Criteria andIntendCourseIn(List<String> values) {
            addCriterion("intend_course in", values, "intendCourse");
            return (Criteria) this;
        }

        public Criteria andIntendCourseNotIn(List<String> values) {
            addCriterion("intend_course not in", values, "intendCourse");
            return (Criteria) this;
        }

        public Criteria andIntendCourseBetween(String value1, String value2) {
            addCriterion("intend_course between", value1, value2, "intendCourse");
            return (Criteria) this;
        }

        public Criteria andIntendCourseNotBetween(String value1, String value2) {
            addCriterion("intend_course not between", value1, value2, "intendCourse");
            return (Criteria) this;
        }

        public Criteria andExamDateIsNull() {
            addCriterion("exam_date is null");
            return (Criteria) this;
        }

        public Criteria andExamDateIsNotNull() {
            addCriterion("exam_date is not null");
            return (Criteria) this;
        }

        public Criteria andExamDateEqualTo(String value) {
            addCriterion("exam_date =", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateNotEqualTo(String value) {
            addCriterion("exam_date <>", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateGreaterThan(String value) {
            addCriterion("exam_date >", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateGreaterThanOrEqualTo(String value) {
            addCriterion("exam_date >=", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateLessThan(String value) {
            addCriterion("exam_date <", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateLessThanOrEqualTo(String value) {
            addCriterion("exam_date <=", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateLike(String value) {
            addCriterion("exam_date like", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateNotLike(String value) {
            addCriterion("exam_date not like", value, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateIn(List<String> values) {
            addCriterion("exam_date in", values, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateNotIn(List<String> values) {
            addCriterion("exam_date not in", values, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateBetween(String value1, String value2) {
            addCriterion("exam_date between", value1, value2, "examDate");
            return (Criteria) this;
        }

        public Criteria andExamDateNotBetween(String value1, String value2) {
            addCriterion("exam_date not between", value1, value2, "examDate");
            return (Criteria) this;
        }

        public Criteria andContactTriedIsNull() {
            addCriterion("contact_tried is null");
            return (Criteria) this;
        }

        public Criteria andContactTriedIsNotNull() {
            addCriterion("contact_tried is not null");
            return (Criteria) this;
        }

        public Criteria andContactTriedEqualTo(Integer value) {
            addCriterion("contact_tried =", value, "contactTried");
            return (Criteria) this;
        }

        public Criteria andContactTriedNotEqualTo(Integer value) {
            addCriterion("contact_tried <>", value, "contactTried");
            return (Criteria) this;
        }

        public Criteria andContactTriedGreaterThan(Integer value) {
            addCriterion("contact_tried >", value, "contactTried");
            return (Criteria) this;
        }

        public Criteria andContactTriedGreaterThanOrEqualTo(Integer value) {
            addCriterion("contact_tried >=", value, "contactTried");
            return (Criteria) this;
        }

        public Criteria andContactTriedLessThan(Integer value) {
            addCriterion("contact_tried <", value, "contactTried");
            return (Criteria) this;
        }

        public Criteria andContactTriedLessThanOrEqualTo(Integer value) {
            addCriterion("contact_tried <=", value, "contactTried");
            return (Criteria) this;
        }

        public Criteria andContactTriedIn(List<Integer> values) {
            addCriterion("contact_tried in", values, "contactTried");
            return (Criteria) this;
        }

        public Criteria andContactTriedNotIn(List<Integer> values) {
            addCriterion("contact_tried not in", values, "contactTried");
            return (Criteria) this;
        }

        public Criteria andContactTriedBetween(Integer value1, Integer value2) {
            addCriterion("contact_tried between", value1, value2, "contactTried");
            return (Criteria) this;
        }

        public Criteria andContactTriedNotBetween(Integer value1, Integer value2) {
            addCriterion("contact_tried not between", value1, value2, "contactTried");
            return (Criteria) this;
        }

        public Criteria andContactAnsweredIsNull() {
            addCriterion("contact_answered is null");
            return (Criteria) this;
        }

        public Criteria andContactAnsweredIsNotNull() {
            addCriterion("contact_answered is not null");
            return (Criteria) this;
        }

        public Criteria andContactAnsweredEqualTo(Integer value) {
            addCriterion("contact_answered =", value, "contactAnswered");
            return (Criteria) this;
        }

        public Criteria andContactAnsweredNotEqualTo(Integer value) {
            addCriterion("contact_answered <>", value, "contactAnswered");
            return (Criteria) this;
        }

        public Criteria andContactAnsweredGreaterThan(Integer value) {
            addCriterion("contact_answered >", value, "contactAnswered");
            return (Criteria) this;
        }

        public Criteria andContactAnsweredGreaterThanOrEqualTo(Integer value) {
            addCriterion("contact_answered >=", value, "contactAnswered");
            return (Criteria) this;
        }

        public Criteria andContactAnsweredLessThan(Integer value) {
            addCriterion("contact_answered <", value, "contactAnswered");
            return (Criteria) this;
        }

        public Criteria andContactAnsweredLessThanOrEqualTo(Integer value) {
            addCriterion("contact_answered <=", value, "contactAnswered");
            return (Criteria) this;
        }

        public Criteria andContactAnsweredIn(List<Integer> values) {
            addCriterion("contact_answered in", values, "contactAnswered");
            return (Criteria) this;
        }

        public Criteria andContactAnsweredNotIn(List<Integer> values) {
            addCriterion("contact_answered not in", values, "contactAnswered");
            return (Criteria) this;
        }

        public Criteria andContactAnsweredBetween(Integer value1, Integer value2) {
            addCriterion("contact_answered between", value1, value2, "contactAnswered");
            return (Criteria) this;
        }

        public Criteria andContactAnsweredNotBetween(Integer value1, Integer value2) {
            addCriterion("contact_answered not between", value1, value2, "contactAnswered");
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