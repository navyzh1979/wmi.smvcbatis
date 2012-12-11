package org.wmichina.crm.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentLogAssignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentLogAssignExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAssignIdIsNull() {
            addCriterion("assign_id is null");
            return (Criteria) this;
        }

        public Criteria andAssignIdIsNotNull() {
            addCriterion("assign_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssignIdEqualTo(Long value) {
            addCriterion("assign_id =", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdNotEqualTo(Long value) {
            addCriterion("assign_id <>", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdGreaterThan(Long value) {
            addCriterion("assign_id >", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdGreaterThanOrEqualTo(Long value) {
            addCriterion("assign_id >=", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdLessThan(Long value) {
            addCriterion("assign_id <", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdLessThanOrEqualTo(Long value) {
            addCriterion("assign_id <=", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdIn(List<Long> values) {
            addCriterion("assign_id in", values, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdNotIn(List<Long> values) {
            addCriterion("assign_id not in", values, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdBetween(Long value1, Long value2) {
            addCriterion("assign_id between", value1, value2, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdNotBetween(Long value1, Long value2) {
            addCriterion("assign_id not between", value1, value2, "assignId");
            return (Criteria) this;
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

        public Criteria andDepartCodeIsNull() {
            addCriterion("depart_code is null");
            return (Criteria) this;
        }

        public Criteria andDepartCodeIsNotNull() {
            addCriterion("depart_code is not null");
            return (Criteria) this;
        }

        public Criteria andDepartCodeEqualTo(String value) {
            addCriterion("depart_code =", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeNotEqualTo(String value) {
            addCriterion("depart_code <>", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeGreaterThan(String value) {
            addCriterion("depart_code >", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeGreaterThanOrEqualTo(String value) {
            addCriterion("depart_code >=", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeLessThan(String value) {
            addCriterion("depart_code <", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeLessThanOrEqualTo(String value) {
            addCriterion("depart_code <=", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeLike(String value) {
            addCriterion("depart_code like", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeNotLike(String value) {
            addCriterion("depart_code not like", value, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeIn(List<String> values) {
            addCriterion("depart_code in", values, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeNotIn(List<String> values) {
            addCriterion("depart_code not in", values, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeBetween(String value1, String value2) {
            addCriterion("depart_code between", value1, value2, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartCodeNotBetween(String value1, String value2) {
            addCriterion("depart_code not between", value1, value2, "departCode");
            return (Criteria) this;
        }

        public Criteria andDepartNameIsNull() {
            addCriterion("depart_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartNameIsNotNull() {
            addCriterion("depart_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartNameEqualTo(String value) {
            addCriterion("depart_name =", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotEqualTo(String value) {
            addCriterion("depart_name <>", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameGreaterThan(String value) {
            addCriterion("depart_name >", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameGreaterThanOrEqualTo(String value) {
            addCriterion("depart_name >=", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLessThan(String value) {
            addCriterion("depart_name <", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLessThanOrEqualTo(String value) {
            addCriterion("depart_name <=", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLike(String value) {
            addCriterion("depart_name like", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotLike(String value) {
            addCriterion("depart_name not like", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameIn(List<String> values) {
            addCriterion("depart_name in", values, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotIn(List<String> values) {
            addCriterion("depart_name not in", values, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameBetween(String value1, String value2) {
            addCriterion("depart_name between", value1, value2, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotBetween(String value1, String value2) {
            addCriterion("depart_name not between", value1, value2, "departName");
            return (Criteria) this;
        }

        public Criteria andJobCodeIsNull() {
            addCriterion("job_code is null");
            return (Criteria) this;
        }

        public Criteria andJobCodeIsNotNull() {
            addCriterion("job_code is not null");
            return (Criteria) this;
        }

        public Criteria andJobCodeEqualTo(String value) {
            addCriterion("job_code =", value, "jobCode");
            return (Criteria) this;
        }

        public Criteria andJobCodeNotEqualTo(String value) {
            addCriterion("job_code <>", value, "jobCode");
            return (Criteria) this;
        }

        public Criteria andJobCodeGreaterThan(String value) {
            addCriterion("job_code >", value, "jobCode");
            return (Criteria) this;
        }

        public Criteria andJobCodeGreaterThanOrEqualTo(String value) {
            addCriterion("job_code >=", value, "jobCode");
            return (Criteria) this;
        }

        public Criteria andJobCodeLessThan(String value) {
            addCriterion("job_code <", value, "jobCode");
            return (Criteria) this;
        }

        public Criteria andJobCodeLessThanOrEqualTo(String value) {
            addCriterion("job_code <=", value, "jobCode");
            return (Criteria) this;
        }

        public Criteria andJobCodeLike(String value) {
            addCriterion("job_code like", value, "jobCode");
            return (Criteria) this;
        }

        public Criteria andJobCodeNotLike(String value) {
            addCriterion("job_code not like", value, "jobCode");
            return (Criteria) this;
        }

        public Criteria andJobCodeIn(List<String> values) {
            addCriterion("job_code in", values, "jobCode");
            return (Criteria) this;
        }

        public Criteria andJobCodeNotIn(List<String> values) {
            addCriterion("job_code not in", values, "jobCode");
            return (Criteria) this;
        }

        public Criteria andJobCodeBetween(String value1, String value2) {
            addCriterion("job_code between", value1, value2, "jobCode");
            return (Criteria) this;
        }

        public Criteria andJobCodeNotBetween(String value1, String value2) {
            addCriterion("job_code not between", value1, value2, "jobCode");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobDaysIsNull() {
            addCriterion("job_days is null");
            return (Criteria) this;
        }

        public Criteria andJobDaysIsNotNull() {
            addCriterion("job_days is not null");
            return (Criteria) this;
        }

        public Criteria andJobDaysEqualTo(Integer value) {
            addCriterion("job_days =", value, "jobDays");
            return (Criteria) this;
        }

        public Criteria andJobDaysNotEqualTo(Integer value) {
            addCriterion("job_days <>", value, "jobDays");
            return (Criteria) this;
        }

        public Criteria andJobDaysGreaterThan(Integer value) {
            addCriterion("job_days >", value, "jobDays");
            return (Criteria) this;
        }

        public Criteria andJobDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_days >=", value, "jobDays");
            return (Criteria) this;
        }

        public Criteria andJobDaysLessThan(Integer value) {
            addCriterion("job_days <", value, "jobDays");
            return (Criteria) this;
        }

        public Criteria andJobDaysLessThanOrEqualTo(Integer value) {
            addCriterion("job_days <=", value, "jobDays");
            return (Criteria) this;
        }

        public Criteria andJobDaysIn(List<Integer> values) {
            addCriterion("job_days in", values, "jobDays");
            return (Criteria) this;
        }

        public Criteria andJobDaysNotIn(List<Integer> values) {
            addCriterion("job_days not in", values, "jobDays");
            return (Criteria) this;
        }

        public Criteria andJobDaysBetween(Integer value1, Integer value2) {
            addCriterion("job_days between", value1, value2, "jobDays");
            return (Criteria) this;
        }

        public Criteria andJobDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("job_days not between", value1, value2, "jobDays");
            return (Criteria) this;
        }

        public Criteria andJobDeadlineIsNull() {
            addCriterion("job_deadline is null");
            return (Criteria) this;
        }

        public Criteria andJobDeadlineIsNotNull() {
            addCriterion("job_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andJobDeadlineEqualTo(Date value) {
            addCriterionForJDBCDate("job_deadline =", value, "jobDeadline");
            return (Criteria) this;
        }

        public Criteria andJobDeadlineNotEqualTo(Date value) {
            addCriterionForJDBCDate("job_deadline <>", value, "jobDeadline");
            return (Criteria) this;
        }

        public Criteria andJobDeadlineGreaterThan(Date value) {
            addCriterionForJDBCDate("job_deadline >", value, "jobDeadline");
            return (Criteria) this;
        }

        public Criteria andJobDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("job_deadline >=", value, "jobDeadline");
            return (Criteria) this;
        }

        public Criteria andJobDeadlineLessThan(Date value) {
            addCriterionForJDBCDate("job_deadline <", value, "jobDeadline");
            return (Criteria) this;
        }

        public Criteria andJobDeadlineLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("job_deadline <=", value, "jobDeadline");
            return (Criteria) this;
        }

        public Criteria andJobDeadlineIn(List<Date> values) {
            addCriterionForJDBCDate("job_deadline in", values, "jobDeadline");
            return (Criteria) this;
        }

        public Criteria andJobDeadlineNotIn(List<Date> values) {
            addCriterionForJDBCDate("job_deadline not in", values, "jobDeadline");
            return (Criteria) this;
        }

        public Criteria andJobDeadlineBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("job_deadline between", value1, value2, "jobDeadline");
            return (Criteria) this;
        }

        public Criteria andJobDeadlineNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("job_deadline not between", value1, value2, "jobDeadline");
            return (Criteria) this;
        }

        public Criteria andAssignedToIsNull() {
            addCriterion("assigned_to is null");
            return (Criteria) this;
        }

        public Criteria andAssignedToIsNotNull() {
            addCriterion("assigned_to is not null");
            return (Criteria) this;
        }

        public Criteria andAssignedToEqualTo(String value) {
            addCriterion("assigned_to =", value, "assignedTo");
            return (Criteria) this;
        }

        public Criteria andAssignedToNotEqualTo(String value) {
            addCriterion("assigned_to <>", value, "assignedTo");
            return (Criteria) this;
        }

        public Criteria andAssignedToGreaterThan(String value) {
            addCriterion("assigned_to >", value, "assignedTo");
            return (Criteria) this;
        }

        public Criteria andAssignedToGreaterThanOrEqualTo(String value) {
            addCriterion("assigned_to >=", value, "assignedTo");
            return (Criteria) this;
        }

        public Criteria andAssignedToLessThan(String value) {
            addCriterion("assigned_to <", value, "assignedTo");
            return (Criteria) this;
        }

        public Criteria andAssignedToLessThanOrEqualTo(String value) {
            addCriterion("assigned_to <=", value, "assignedTo");
            return (Criteria) this;
        }

        public Criteria andAssignedToLike(String value) {
            addCriterion("assigned_to like", value, "assignedTo");
            return (Criteria) this;
        }

        public Criteria andAssignedToNotLike(String value) {
            addCriterion("assigned_to not like", value, "assignedTo");
            return (Criteria) this;
        }

        public Criteria andAssignedToIn(List<String> values) {
            addCriterion("assigned_to in", values, "assignedTo");
            return (Criteria) this;
        }

        public Criteria andAssignedToNotIn(List<String> values) {
            addCriterion("assigned_to not in", values, "assignedTo");
            return (Criteria) this;
        }

        public Criteria andAssignedToBetween(String value1, String value2) {
            addCriterion("assigned_to between", value1, value2, "assignedTo");
            return (Criteria) this;
        }

        public Criteria andAssignedToNotBetween(String value1, String value2) {
            addCriterion("assigned_to not between", value1, value2, "assignedTo");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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