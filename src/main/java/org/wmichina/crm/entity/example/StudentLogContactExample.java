package org.wmichina.crm.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentLogContactExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentLogContactExample() {
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

        public Criteria andContactIdIsNull() {
            addCriterion("contact_id is null");
            return (Criteria) this;
        }

        public Criteria andContactIdIsNotNull() {
            addCriterion("contact_id is not null");
            return (Criteria) this;
        }

        public Criteria andContactIdEqualTo(Long value) {
            addCriterion("contact_id =", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdNotEqualTo(Long value) {
            addCriterion("contact_id <>", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdGreaterThan(Long value) {
            addCriterion("contact_id >", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contact_id >=", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdLessThan(Long value) {
            addCriterion("contact_id <", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdLessThanOrEqualTo(Long value) {
            addCriterion("contact_id <=", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdIn(List<Long> values) {
            addCriterion("contact_id in", values, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdNotIn(List<Long> values) {
            addCriterion("contact_id not in", values, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdBetween(Long value1, Long value2) {
            addCriterion("contact_id between", value1, value2, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdNotBetween(Long value1, Long value2) {
            addCriterion("contact_id not between", value1, value2, "contactId");
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

        public Criteria andContactModeIsNull() {
            addCriterion("contact_mode is null");
            return (Criteria) this;
        }

        public Criteria andContactModeIsNotNull() {
            addCriterion("contact_mode is not null");
            return (Criteria) this;
        }

        public Criteria andContactModeEqualTo(Integer value) {
            addCriterion("contact_mode =", value, "contactMode");
            return (Criteria) this;
        }

        public Criteria andContactModeNotEqualTo(Integer value) {
            addCriterion("contact_mode <>", value, "contactMode");
            return (Criteria) this;
        }

        public Criteria andContactModeGreaterThan(Integer value) {
            addCriterion("contact_mode >", value, "contactMode");
            return (Criteria) this;
        }

        public Criteria andContactModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("contact_mode >=", value, "contactMode");
            return (Criteria) this;
        }

        public Criteria andContactModeLessThan(Integer value) {
            addCriterion("contact_mode <", value, "contactMode");
            return (Criteria) this;
        }

        public Criteria andContactModeLessThanOrEqualTo(Integer value) {
            addCriterion("contact_mode <=", value, "contactMode");
            return (Criteria) this;
        }

        public Criteria andContactModeIn(List<Integer> values) {
            addCriterion("contact_mode in", values, "contactMode");
            return (Criteria) this;
        }

        public Criteria andContactModeNotIn(List<Integer> values) {
            addCriterion("contact_mode not in", values, "contactMode");
            return (Criteria) this;
        }

        public Criteria andContactModeBetween(Integer value1, Integer value2) {
            addCriterion("contact_mode between", value1, value2, "contactMode");
            return (Criteria) this;
        }

        public Criteria andContactModeNotBetween(Integer value1, Integer value2) {
            addCriterion("contact_mode not between", value1, value2, "contactMode");
            return (Criteria) this;
        }

        public Criteria andContactSummaryIsNull() {
            addCriterion("contact_summary is null");
            return (Criteria) this;
        }

        public Criteria andContactSummaryIsNotNull() {
            addCriterion("contact_summary is not null");
            return (Criteria) this;
        }

        public Criteria andContactSummaryEqualTo(String value) {
            addCriterion("contact_summary =", value, "contactSummary");
            return (Criteria) this;
        }

        public Criteria andContactSummaryNotEqualTo(String value) {
            addCriterion("contact_summary <>", value, "contactSummary");
            return (Criteria) this;
        }

        public Criteria andContactSummaryGreaterThan(String value) {
            addCriterion("contact_summary >", value, "contactSummary");
            return (Criteria) this;
        }

        public Criteria andContactSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("contact_summary >=", value, "contactSummary");
            return (Criteria) this;
        }

        public Criteria andContactSummaryLessThan(String value) {
            addCriterion("contact_summary <", value, "contactSummary");
            return (Criteria) this;
        }

        public Criteria andContactSummaryLessThanOrEqualTo(String value) {
            addCriterion("contact_summary <=", value, "contactSummary");
            return (Criteria) this;
        }

        public Criteria andContactSummaryLike(String value) {
            addCriterion("contact_summary like", value, "contactSummary");
            return (Criteria) this;
        }

        public Criteria andContactSummaryNotLike(String value) {
            addCriterion("contact_summary not like", value, "contactSummary");
            return (Criteria) this;
        }

        public Criteria andContactSummaryIn(List<String> values) {
            addCriterion("contact_summary in", values, "contactSummary");
            return (Criteria) this;
        }

        public Criteria andContactSummaryNotIn(List<String> values) {
            addCriterion("contact_summary not in", values, "contactSummary");
            return (Criteria) this;
        }

        public Criteria andContactSummaryBetween(String value1, String value2) {
            addCriterion("contact_summary between", value1, value2, "contactSummary");
            return (Criteria) this;
        }

        public Criteria andContactSummaryNotBetween(String value1, String value2) {
            addCriterion("contact_summary not between", value1, value2, "contactSummary");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoIsNull() {
            addCriterion("contact_batchno is null");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoIsNotNull() {
            addCriterion("contact_batchno is not null");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoEqualTo(String value) {
            addCriterion("contact_batchno =", value, "contactBatchno");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoNotEqualTo(String value) {
            addCriterion("contact_batchno <>", value, "contactBatchno");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoGreaterThan(String value) {
            addCriterion("contact_batchno >", value, "contactBatchno");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoGreaterThanOrEqualTo(String value) {
            addCriterion("contact_batchno >=", value, "contactBatchno");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoLessThan(String value) {
            addCriterion("contact_batchno <", value, "contactBatchno");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoLessThanOrEqualTo(String value) {
            addCriterion("contact_batchno <=", value, "contactBatchno");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoLike(String value) {
            addCriterion("contact_batchno like", value, "contactBatchno");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoNotLike(String value) {
            addCriterion("contact_batchno not like", value, "contactBatchno");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoIn(List<String> values) {
            addCriterion("contact_batchno in", values, "contactBatchno");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoNotIn(List<String> values) {
            addCriterion("contact_batchno not in", values, "contactBatchno");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoBetween(String value1, String value2) {
            addCriterion("contact_batchno between", value1, value2, "contactBatchno");
            return (Criteria) this;
        }

        public Criteria andContactBatchnoNotBetween(String value1, String value2) {
            addCriterion("contact_batchno not between", value1, value2, "contactBatchno");
            return (Criteria) this;
        }

        public Criteria andContactDateIsNull() {
            addCriterion("contact_date is null");
            return (Criteria) this;
        }

        public Criteria andContactDateIsNotNull() {
            addCriterion("contact_date is not null");
            return (Criteria) this;
        }

        public Criteria andContactDateEqualTo(Date value) {
            addCriterion("contact_date =", value, "contactDate");
            return (Criteria) this;
        }

        public Criteria andContactDateNotEqualTo(Date value) {
            addCriterion("contact_date <>", value, "contactDate");
            return (Criteria) this;
        }

        public Criteria andContactDateGreaterThan(Date value) {
            addCriterion("contact_date >", value, "contactDate");
            return (Criteria) this;
        }

        public Criteria andContactDateGreaterThanOrEqualTo(Date value) {
            addCriterion("contact_date >=", value, "contactDate");
            return (Criteria) this;
        }

        public Criteria andContactDateLessThan(Date value) {
            addCriterion("contact_date <", value, "contactDate");
            return (Criteria) this;
        }

        public Criteria andContactDateLessThanOrEqualTo(Date value) {
            addCriterion("contact_date <=", value, "contactDate");
            return (Criteria) this;
        }

        public Criteria andContactDateIn(List<Date> values) {
            addCriterion("contact_date in", values, "contactDate");
            return (Criteria) this;
        }

        public Criteria andContactDateNotIn(List<Date> values) {
            addCriterion("contact_date not in", values, "contactDate");
            return (Criteria) this;
        }

        public Criteria andContactDateBetween(Date value1, Date value2) {
            addCriterion("contact_date between", value1, value2, "contactDate");
            return (Criteria) this;
        }

        public Criteria andContactDateNotBetween(Date value1, Date value2) {
            addCriterion("contact_date not between", value1, value2, "contactDate");
            return (Criteria) this;
        }

        public Criteria andIsAnsweredIsNull() {
            addCriterion("is_answered is null");
            return (Criteria) this;
        }

        public Criteria andIsAnsweredIsNotNull() {
            addCriterion("is_answered is not null");
            return (Criteria) this;
        }

        public Criteria andIsAnsweredEqualTo(Integer value) {
            addCriterion("is_answered =", value, "isAnswered");
            return (Criteria) this;
        }

        public Criteria andIsAnsweredNotEqualTo(Integer value) {
            addCriterion("is_answered <>", value, "isAnswered");
            return (Criteria) this;
        }

        public Criteria andIsAnsweredGreaterThan(Integer value) {
            addCriterion("is_answered >", value, "isAnswered");
            return (Criteria) this;
        }

        public Criteria andIsAnsweredGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_answered >=", value, "isAnswered");
            return (Criteria) this;
        }

        public Criteria andIsAnsweredLessThan(Integer value) {
            addCriterion("is_answered <", value, "isAnswered");
            return (Criteria) this;
        }

        public Criteria andIsAnsweredLessThanOrEqualTo(Integer value) {
            addCriterion("is_answered <=", value, "isAnswered");
            return (Criteria) this;
        }

        public Criteria andIsAnsweredIn(List<Integer> values) {
            addCriterion("is_answered in", values, "isAnswered");
            return (Criteria) this;
        }

        public Criteria andIsAnsweredNotIn(List<Integer> values) {
            addCriterion("is_answered not in", values, "isAnswered");
            return (Criteria) this;
        }

        public Criteria andIsAnsweredBetween(Integer value1, Integer value2) {
            addCriterion("is_answered between", value1, value2, "isAnswered");
            return (Criteria) this;
        }

        public Criteria andIsAnsweredNotBetween(Integer value1, Integer value2) {
            addCriterion("is_answered not between", value1, value2, "isAnswered");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryIsNull() {
            addCriterion("answer_summary is null");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryIsNotNull() {
            addCriterion("answer_summary is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryEqualTo(String value) {
            addCriterion("answer_summary =", value, "answerSummary");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryNotEqualTo(String value) {
            addCriterion("answer_summary <>", value, "answerSummary");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryGreaterThan(String value) {
            addCriterion("answer_summary >", value, "answerSummary");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("answer_summary >=", value, "answerSummary");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryLessThan(String value) {
            addCriterion("answer_summary <", value, "answerSummary");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryLessThanOrEqualTo(String value) {
            addCriterion("answer_summary <=", value, "answerSummary");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryLike(String value) {
            addCriterion("answer_summary like", value, "answerSummary");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryNotLike(String value) {
            addCriterion("answer_summary not like", value, "answerSummary");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryIn(List<String> values) {
            addCriterion("answer_summary in", values, "answerSummary");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryNotIn(List<String> values) {
            addCriterion("answer_summary not in", values, "answerSummary");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryBetween(String value1, String value2) {
            addCriterion("answer_summary between", value1, value2, "answerSummary");
            return (Criteria) this;
        }

        public Criteria andAnswerSummaryNotBetween(String value1, String value2) {
            addCriterion("answer_summary not between", value1, value2, "answerSummary");
            return (Criteria) this;
        }

        public Criteria andAnswerDateIsNull() {
            addCriterion("answer_date is null");
            return (Criteria) this;
        }

        public Criteria andAnswerDateIsNotNull() {
            addCriterion("answer_date is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerDateEqualTo(Date value) {
            addCriterion("answer_date =", value, "answerDate");
            return (Criteria) this;
        }

        public Criteria andAnswerDateNotEqualTo(Date value) {
            addCriterion("answer_date <>", value, "answerDate");
            return (Criteria) this;
        }

        public Criteria andAnswerDateGreaterThan(Date value) {
            addCriterion("answer_date >", value, "answerDate");
            return (Criteria) this;
        }

        public Criteria andAnswerDateGreaterThanOrEqualTo(Date value) {
            addCriterion("answer_date >=", value, "answerDate");
            return (Criteria) this;
        }

        public Criteria andAnswerDateLessThan(Date value) {
            addCriterion("answer_date <", value, "answerDate");
            return (Criteria) this;
        }

        public Criteria andAnswerDateLessThanOrEqualTo(Date value) {
            addCriterion("answer_date <=", value, "answerDate");
            return (Criteria) this;
        }

        public Criteria andAnswerDateIn(List<Date> values) {
            addCriterion("answer_date in", values, "answerDate");
            return (Criteria) this;
        }

        public Criteria andAnswerDateNotIn(List<Date> values) {
            addCriterion("answer_date not in", values, "answerDate");
            return (Criteria) this;
        }

        public Criteria andAnswerDateBetween(Date value1, Date value2) {
            addCriterion("answer_date between", value1, value2, "answerDate");
            return (Criteria) this;
        }

        public Criteria andAnswerDateNotBetween(Date value1, Date value2) {
            addCriterion("answer_date not between", value1, value2, "answerDate");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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