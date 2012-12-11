package org.wmichina.crm.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BizCourseExample {
	private Integer start,end;
    public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BizCourseExample() {
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

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNull() {
            addCriterion("course_code is null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIsNotNull() {
            addCriterion("course_code is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCodeEqualTo(String value) {
            addCriterion("course_code =", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotEqualTo(String value) {
            addCriterion("course_code <>", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThan(String value) {
            addCriterion("course_code >", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("course_code >=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThan(String value) {
            addCriterion("course_code <", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLessThanOrEqualTo(String value) {
            addCriterion("course_code <=", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeLike(String value) {
            addCriterion("course_code like", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotLike(String value) {
            addCriterion("course_code not like", value, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeIn(List<String> values) {
            addCriterion("course_code in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotIn(List<String> values) {
            addCriterion("course_code not in", values, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeBetween(String value1, String value2) {
            addCriterion("course_code between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseCodeNotBetween(String value1, String value2) {
            addCriterion("course_code not between", value1, value2, "courseCode");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryIsNull() {
            addCriterion("course_category is null");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryIsNotNull() {
            addCriterion("course_category is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryEqualTo(String value) {
            addCriterion("course_category =", value, "courseCategory");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryNotEqualTo(String value) {
            addCriterion("course_category <>", value, "courseCategory");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryGreaterThan(String value) {
            addCriterion("course_category >", value, "courseCategory");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("course_category >=", value, "courseCategory");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryLessThan(String value) {
            addCriterion("course_category <", value, "courseCategory");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryLessThanOrEqualTo(String value) {
            addCriterion("course_category <=", value, "courseCategory");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryLike(String value) {
            addCriterion("course_category like", value, "courseCategory");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryNotLike(String value) {
            addCriterion("course_category not like", value, "courseCategory");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryIn(List<String> values) {
            addCriterion("course_category in", values, "courseCategory");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryNotIn(List<String> values) {
            addCriterion("course_category not in", values, "courseCategory");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryBetween(String value1, String value2) {
            addCriterion("course_category between", value1, value2, "courseCategory");
            return (Criteria) this;
        }

        public Criteria andCourseCategoryNotBetween(String value1, String value2) {
            addCriterion("course_category not between", value1, value2, "courseCategory");
            return (Criteria) this;
        }

        public Criteria andCourseClassIsNull() {
            addCriterion("course_class is null");
            return (Criteria) this;
        }

        public Criteria andCourseClassIsNotNull() {
            addCriterion("course_class is not null");
            return (Criteria) this;
        }

        public Criteria andCourseClassEqualTo(String value) {
            addCriterion("course_class =", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassNotEqualTo(String value) {
            addCriterion("course_class <>", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassGreaterThan(String value) {
            addCriterion("course_class >", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassGreaterThanOrEqualTo(String value) {
            addCriterion("course_class >=", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassLessThan(String value) {
            addCriterion("course_class <", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassLessThanOrEqualTo(String value) {
            addCriterion("course_class <=", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassLike(String value) {
            addCriterion("course_class like", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassNotLike(String value) {
            addCriterion("course_class not like", value, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassIn(List<String> values) {
            addCriterion("course_class in", values, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassNotIn(List<String> values) {
            addCriterion("course_class not in", values, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassBetween(String value1, String value2) {
            addCriterion("course_class between", value1, value2, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseClassNotBetween(String value1, String value2) {
            addCriterion("course_class not between", value1, value2, "courseClass");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNull() {
            addCriterion("course_type is null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNotNull() {
            addCriterion("course_type is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeEqualTo(String value) {
            addCriterion("course_type =", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotEqualTo(String value) {
            addCriterion("course_type <>", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThan(String value) {
            addCriterion("course_type >", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("course_type >=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThan(String value) {
            addCriterion("course_type <", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThanOrEqualTo(String value) {
            addCriterion("course_type <=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLike(String value) {
            addCriterion("course_type like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotLike(String value) {
            addCriterion("course_type not like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIn(List<String> values) {
            addCriterion("course_type in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotIn(List<String> values) {
            addCriterion("course_type not in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeBetween(String value1, String value2) {
            addCriterion("course_type between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotBetween(String value1, String value2) {
            addCriterion("course_type not between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andLearningModeIsNull() {
            addCriterion("learning_mode is null");
            return (Criteria) this;
        }

        public Criteria andLearningModeIsNotNull() {
            addCriterion("learning_mode is not null");
            return (Criteria) this;
        }

        public Criteria andLearningModeEqualTo(String value) {
            addCriterion("learning_mode =", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeNotEqualTo(String value) {
            addCriterion("learning_mode <>", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeGreaterThan(String value) {
            addCriterion("learning_mode >", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeGreaterThanOrEqualTo(String value) {
            addCriterion("learning_mode >=", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeLessThan(String value) {
            addCriterion("learning_mode <", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeLessThanOrEqualTo(String value) {
            addCriterion("learning_mode <=", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeLike(String value) {
            addCriterion("learning_mode like", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeNotLike(String value) {
            addCriterion("learning_mode not like", value, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeIn(List<String> values) {
            addCriterion("learning_mode in", values, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeNotIn(List<String> values) {
            addCriterion("learning_mode not in", values, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeBetween(String value1, String value2) {
            addCriterion("learning_mode between", value1, value2, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningModeNotBetween(String value1, String value2) {
            addCriterion("learning_mode not between", value1, value2, "learningMode");
            return (Criteria) this;
        }

        public Criteria andLearningTimeIsNull() {
            addCriterion("learning_time is null");
            return (Criteria) this;
        }

        public Criteria andLearningTimeIsNotNull() {
            addCriterion("learning_time is not null");
            return (Criteria) this;
        }

        public Criteria andLearningTimeEqualTo(String value) {
            addCriterion("learning_time =", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeNotEqualTo(String value) {
            addCriterion("learning_time <>", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeGreaterThan(String value) {
            addCriterion("learning_time >", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeGreaterThanOrEqualTo(String value) {
            addCriterion("learning_time >=", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeLessThan(String value) {
            addCriterion("learning_time <", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeLessThanOrEqualTo(String value) {
            addCriterion("learning_time <=", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeLike(String value) {
            addCriterion("learning_time like", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeNotLike(String value) {
            addCriterion("learning_time not like", value, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeIn(List<String> values) {
            addCriterion("learning_time in", values, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeNotIn(List<String> values) {
            addCriterion("learning_time not in", values, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeBetween(String value1, String value2) {
            addCriterion("learning_time between", value1, value2, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningTimeNotBetween(String value1, String value2) {
            addCriterion("learning_time not between", value1, value2, "learningTime");
            return (Criteria) this;
        }

        public Criteria andLearningHoursIsNull() {
            addCriterion("learning_hours is null");
            return (Criteria) this;
        }

        public Criteria andLearningHoursIsNotNull() {
            addCriterion("learning_hours is not null");
            return (Criteria) this;
        }

        public Criteria andLearningHoursEqualTo(Integer value) {
            addCriterion("learning_hours =", value, "learningHours");
            return (Criteria) this;
        }

        public Criteria andLearningHoursNotEqualTo(Integer value) {
            addCriterion("learning_hours <>", value, "learningHours");
            return (Criteria) this;
        }

        public Criteria andLearningHoursGreaterThan(Integer value) {
            addCriterion("learning_hours >", value, "learningHours");
            return (Criteria) this;
        }

        public Criteria andLearningHoursGreaterThanOrEqualTo(Integer value) {
            addCriterion("learning_hours >=", value, "learningHours");
            return (Criteria) this;
        }

        public Criteria andLearningHoursLessThan(Integer value) {
            addCriterion("learning_hours <", value, "learningHours");
            return (Criteria) this;
        }

        public Criteria andLearningHoursLessThanOrEqualTo(Integer value) {
            addCriterion("learning_hours <=", value, "learningHours");
            return (Criteria) this;
        }

        public Criteria andLearningHoursIn(List<Integer> values) {
            addCriterion("learning_hours in", values, "learningHours");
            return (Criteria) this;
        }

        public Criteria andLearningHoursNotIn(List<Integer> values) {
            addCriterion("learning_hours not in", values, "learningHours");
            return (Criteria) this;
        }

        public Criteria andLearningHoursBetween(Integer value1, Integer value2) {
            addCriterion("learning_hours between", value1, value2, "learningHours");
            return (Criteria) this;
        }

        public Criteria andLearningHoursNotBetween(Integer value1, Integer value2) {
            addCriterion("learning_hours not between", value1, value2, "learningHours");
            return (Criteria) this;
        }

        public Criteria andLearningTermIsNull() {
            addCriterion("learning_term is null");
            return (Criteria) this;
        }

        public Criteria andLearningTermIsNotNull() {
            addCriterion("learning_term is not null");
            return (Criteria) this;
        }

        public Criteria andLearningTermEqualTo(String value) {
            addCriterion("learning_term =", value, "learningTerm");
            return (Criteria) this;
        }

        public Criteria andLearningTermNotEqualTo(String value) {
            addCriterion("learning_term <>", value, "learningTerm");
            return (Criteria) this;
        }

        public Criteria andLearningTermGreaterThan(String value) {
            addCriterion("learning_term >", value, "learningTerm");
            return (Criteria) this;
        }

        public Criteria andLearningTermGreaterThanOrEqualTo(String value) {
            addCriterion("learning_term >=", value, "learningTerm");
            return (Criteria) this;
        }

        public Criteria andLearningTermLessThan(String value) {
            addCriterion("learning_term <", value, "learningTerm");
            return (Criteria) this;
        }

        public Criteria andLearningTermLessThanOrEqualTo(String value) {
            addCriterion("learning_term <=", value, "learningTerm");
            return (Criteria) this;
        }

        public Criteria andLearningTermLike(String value) {
            addCriterion("learning_term like", value, "learningTerm");
            return (Criteria) this;
        }

        public Criteria andLearningTermNotLike(String value) {
            addCriterion("learning_term not like", value, "learningTerm");
            return (Criteria) this;
        }

        public Criteria andLearningTermIn(List<String> values) {
            addCriterion("learning_term in", values, "learningTerm");
            return (Criteria) this;
        }

        public Criteria andLearningTermNotIn(List<String> values) {
            addCriterion("learning_term not in", values, "learningTerm");
            return (Criteria) this;
        }

        public Criteria andLearningTermBetween(String value1, String value2) {
            addCriterion("learning_term between", value1, value2, "learningTerm");
            return (Criteria) this;
        }

        public Criteria andLearningTermNotBetween(String value1, String value2) {
            addCriterion("learning_term not between", value1, value2, "learningTerm");
            return (Criteria) this;
        }

        public Criteria andLearningCityIsNull() {
            addCriterion("learning_city is null");
            return (Criteria) this;
        }

        public Criteria andLearningCityIsNotNull() {
            addCriterion("learning_city is not null");
            return (Criteria) this;
        }

        public Criteria andLearningCityEqualTo(String value) {
            addCriterion("learning_city =", value, "learningCity");
            return (Criteria) this;
        }

        public Criteria andLearningCityNotEqualTo(String value) {
            addCriterion("learning_city <>", value, "learningCity");
            return (Criteria) this;
        }

        public Criteria andLearningCityGreaterThan(String value) {
            addCriterion("learning_city >", value, "learningCity");
            return (Criteria) this;
        }

        public Criteria andLearningCityGreaterThanOrEqualTo(String value) {
            addCriterion("learning_city >=", value, "learningCity");
            return (Criteria) this;
        }

        public Criteria andLearningCityLessThan(String value) {
            addCriterion("learning_city <", value, "learningCity");
            return (Criteria) this;
        }

        public Criteria andLearningCityLessThanOrEqualTo(String value) {
            addCriterion("learning_city <=", value, "learningCity");
            return (Criteria) this;
        }

        public Criteria andLearningCityLike(String value) {
            addCriterion("learning_city like", value, "learningCity");
            return (Criteria) this;
        }

        public Criteria andLearningCityNotLike(String value) {
            addCriterion("learning_city not like", value, "learningCity");
            return (Criteria) this;
        }

        public Criteria andLearningCityIn(List<String> values) {
            addCriterion("learning_city in", values, "learningCity");
            return (Criteria) this;
        }

        public Criteria andLearningCityNotIn(List<String> values) {
            addCriterion("learning_city not in", values, "learningCity");
            return (Criteria) this;
        }

        public Criteria andLearningCityBetween(String value1, String value2) {
            addCriterion("learning_city between", value1, value2, "learningCity");
            return (Criteria) this;
        }

        public Criteria andLearningCityNotBetween(String value1, String value2) {
            addCriterion("learning_city not between", value1, value2, "learningCity");
            return (Criteria) this;
        }

        public Criteria andCoursePriceIsNull() {
            addCriterion("course_price is null");
            return (Criteria) this;
        }

        public Criteria andCoursePriceIsNotNull() {
            addCriterion("course_price is not null");
            return (Criteria) this;
        }

        public Criteria andCoursePriceEqualTo(Double value) {
            addCriterion("course_price =", value, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceNotEqualTo(Double value) {
            addCriterion("course_price <>", value, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceGreaterThan(Double value) {
            addCriterion("course_price >", value, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceGreaterThanOrEqualTo(Double value) {
            addCriterion("course_price >=", value, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceLessThan(Double value) {
            addCriterion("course_price <", value, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceLessThanOrEqualTo(Double value) {
            addCriterion("course_price <=", value, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceIn(List<Double> values) {
            addCriterion("course_price in", values, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceNotIn(List<Double> values) {
            addCriterion("course_price not in", values, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceBetween(Double value1, Double value2) {
            addCriterion("course_price between", value1, value2, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceNotBetween(Double value1, Double value2) {
            addCriterion("course_price not between", value1, value2, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andDiscount1IsNull() {
            addCriterion("discount_1 is null");
            return (Criteria) this;
        }

        public Criteria andDiscount1IsNotNull() {
            addCriterion("discount_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDiscount1EqualTo(Double value) {
            addCriterion("discount_1 =", value, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1NotEqualTo(Double value) {
            addCriterion("discount_1 <>", value, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1GreaterThan(Double value) {
            addCriterion("discount_1 >", value, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1GreaterThanOrEqualTo(Double value) {
            addCriterion("discount_1 >=", value, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1LessThan(Double value) {
            addCriterion("discount_1 <", value, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1LessThanOrEqualTo(Double value) {
            addCriterion("discount_1 <=", value, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1In(List<Double> values) {
            addCriterion("discount_1 in", values, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1NotIn(List<Double> values) {
            addCriterion("discount_1 not in", values, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1Between(Double value1, Double value2) {
            addCriterion("discount_1 between", value1, value2, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscount1NotBetween(Double value1, Double value2) {
            addCriterion("discount_1 not between", value1, value2, "discount1");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1IsNull() {
            addCriterion("discount_reason_1 is null");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1IsNotNull() {
            addCriterion("discount_reason_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1EqualTo(String value) {
            addCriterion("discount_reason_1 =", value, "discountReason1");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1NotEqualTo(String value) {
            addCriterion("discount_reason_1 <>", value, "discountReason1");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1GreaterThan(String value) {
            addCriterion("discount_reason_1 >", value, "discountReason1");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1GreaterThanOrEqualTo(String value) {
            addCriterion("discount_reason_1 >=", value, "discountReason1");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1LessThan(String value) {
            addCriterion("discount_reason_1 <", value, "discountReason1");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1LessThanOrEqualTo(String value) {
            addCriterion("discount_reason_1 <=", value, "discountReason1");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1Like(String value) {
            addCriterion("discount_reason_1 like", value, "discountReason1");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1NotLike(String value) {
            addCriterion("discount_reason_1 not like", value, "discountReason1");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1In(List<String> values) {
            addCriterion("discount_reason_1 in", values, "discountReason1");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1NotIn(List<String> values) {
            addCriterion("discount_reason_1 not in", values, "discountReason1");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1Between(String value1, String value2) {
            addCriterion("discount_reason_1 between", value1, value2, "discountReason1");
            return (Criteria) this;
        }

        public Criteria andDiscountReason1NotBetween(String value1, String value2) {
            addCriterion("discount_reason_1 not between", value1, value2, "discountReason1");
            return (Criteria) this;
        }

        public Criteria andDiscount2IsNull() {
            addCriterion("discount_2 is null");
            return (Criteria) this;
        }

        public Criteria andDiscount2IsNotNull() {
            addCriterion("discount_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDiscount2EqualTo(Double value) {
            addCriterion("discount_2 =", value, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2NotEqualTo(Double value) {
            addCriterion("discount_2 <>", value, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2GreaterThan(Double value) {
            addCriterion("discount_2 >", value, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2GreaterThanOrEqualTo(Double value) {
            addCriterion("discount_2 >=", value, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2LessThan(Double value) {
            addCriterion("discount_2 <", value, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2LessThanOrEqualTo(Double value) {
            addCriterion("discount_2 <=", value, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2In(List<Double> values) {
            addCriterion("discount_2 in", values, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2NotIn(List<Double> values) {
            addCriterion("discount_2 not in", values, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2Between(Double value1, Double value2) {
            addCriterion("discount_2 between", value1, value2, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscount2NotBetween(Double value1, Double value2) {
            addCriterion("discount_2 not between", value1, value2, "discount2");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2IsNull() {
            addCriterion("discount_reason_2 is null");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2IsNotNull() {
            addCriterion("discount_reason_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2EqualTo(String value) {
            addCriterion("discount_reason_2 =", value, "discountReason2");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2NotEqualTo(String value) {
            addCriterion("discount_reason_2 <>", value, "discountReason2");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2GreaterThan(String value) {
            addCriterion("discount_reason_2 >", value, "discountReason2");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2GreaterThanOrEqualTo(String value) {
            addCriterion("discount_reason_2 >=", value, "discountReason2");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2LessThan(String value) {
            addCriterion("discount_reason_2 <", value, "discountReason2");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2LessThanOrEqualTo(String value) {
            addCriterion("discount_reason_2 <=", value, "discountReason2");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2Like(String value) {
            addCriterion("discount_reason_2 like", value, "discountReason2");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2NotLike(String value) {
            addCriterion("discount_reason_2 not like", value, "discountReason2");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2In(List<String> values) {
            addCriterion("discount_reason_2 in", values, "discountReason2");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2NotIn(List<String> values) {
            addCriterion("discount_reason_2 not in", values, "discountReason2");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2Between(String value1, String value2) {
            addCriterion("discount_reason_2 between", value1, value2, "discountReason2");
            return (Criteria) this;
        }

        public Criteria andDiscountReason2NotBetween(String value1, String value2) {
            addCriterion("discount_reason_2 not between", value1, value2, "discountReason2");
            return (Criteria) this;
        }

        public Criteria andDiscount3IsNull() {
            addCriterion("discount_3 is null");
            return (Criteria) this;
        }

        public Criteria andDiscount3IsNotNull() {
            addCriterion("discount_3 is not null");
            return (Criteria) this;
        }

        public Criteria andDiscount3EqualTo(Double value) {
            addCriterion("discount_3 =", value, "discount3");
            return (Criteria) this;
        }

        public Criteria andDiscount3NotEqualTo(Double value) {
            addCriterion("discount_3 <>", value, "discount3");
            return (Criteria) this;
        }

        public Criteria andDiscount3GreaterThan(Double value) {
            addCriterion("discount_3 >", value, "discount3");
            return (Criteria) this;
        }

        public Criteria andDiscount3GreaterThanOrEqualTo(Double value) {
            addCriterion("discount_3 >=", value, "discount3");
            return (Criteria) this;
        }

        public Criteria andDiscount3LessThan(Double value) {
            addCriterion("discount_3 <", value, "discount3");
            return (Criteria) this;
        }

        public Criteria andDiscount3LessThanOrEqualTo(Double value) {
            addCriterion("discount_3 <=", value, "discount3");
            return (Criteria) this;
        }

        public Criteria andDiscount3In(List<Double> values) {
            addCriterion("discount_3 in", values, "discount3");
            return (Criteria) this;
        }

        public Criteria andDiscount3NotIn(List<Double> values) {
            addCriterion("discount_3 not in", values, "discount3");
            return (Criteria) this;
        }

        public Criteria andDiscount3Between(Double value1, Double value2) {
            addCriterion("discount_3 between", value1, value2, "discount3");
            return (Criteria) this;
        }

        public Criteria andDiscount3NotBetween(Double value1, Double value2) {
            addCriterion("discount_3 not between", value1, value2, "discount3");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3IsNull() {
            addCriterion("discount_reason_3 is null");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3IsNotNull() {
            addCriterion("discount_reason_3 is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3EqualTo(String value) {
            addCriterion("discount_reason_3 =", value, "discountReason3");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3NotEqualTo(String value) {
            addCriterion("discount_reason_3 <>", value, "discountReason3");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3GreaterThan(String value) {
            addCriterion("discount_reason_3 >", value, "discountReason3");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3GreaterThanOrEqualTo(String value) {
            addCriterion("discount_reason_3 >=", value, "discountReason3");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3LessThan(String value) {
            addCriterion("discount_reason_3 <", value, "discountReason3");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3LessThanOrEqualTo(String value) {
            addCriterion("discount_reason_3 <=", value, "discountReason3");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3Like(String value) {
            addCriterion("discount_reason_3 like", value, "discountReason3");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3NotLike(String value) {
            addCriterion("discount_reason_3 not like", value, "discountReason3");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3In(List<String> values) {
            addCriterion("discount_reason_3 in", values, "discountReason3");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3NotIn(List<String> values) {
            addCriterion("discount_reason_3 not in", values, "discountReason3");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3Between(String value1, String value2) {
            addCriterion("discount_reason_3 between", value1, value2, "discountReason3");
            return (Criteria) this;
        }

        public Criteria andDiscountReason3NotBetween(String value1, String value2) {
            addCriterion("discount_reason_3 not between", value1, value2, "discountReason3");
            return (Criteria) this;
        }

        public Criteria andDiscount4IsNull() {
            addCriterion("discount_4 is null");
            return (Criteria) this;
        }

        public Criteria andDiscount4IsNotNull() {
            addCriterion("discount_4 is not null");
            return (Criteria) this;
        }

        public Criteria andDiscount4EqualTo(Double value) {
            addCriterion("discount_4 =", value, "discount4");
            return (Criteria) this;
        }

        public Criteria andDiscount4NotEqualTo(Double value) {
            addCriterion("discount_4 <>", value, "discount4");
            return (Criteria) this;
        }

        public Criteria andDiscount4GreaterThan(Double value) {
            addCriterion("discount_4 >", value, "discount4");
            return (Criteria) this;
        }

        public Criteria andDiscount4GreaterThanOrEqualTo(Double value) {
            addCriterion("discount_4 >=", value, "discount4");
            return (Criteria) this;
        }

        public Criteria andDiscount4LessThan(Double value) {
            addCriterion("discount_4 <", value, "discount4");
            return (Criteria) this;
        }

        public Criteria andDiscount4LessThanOrEqualTo(Double value) {
            addCriterion("discount_4 <=", value, "discount4");
            return (Criteria) this;
        }

        public Criteria andDiscount4In(List<Double> values) {
            addCriterion("discount_4 in", values, "discount4");
            return (Criteria) this;
        }

        public Criteria andDiscount4NotIn(List<Double> values) {
            addCriterion("discount_4 not in", values, "discount4");
            return (Criteria) this;
        }

        public Criteria andDiscount4Between(Double value1, Double value2) {
            addCriterion("discount_4 between", value1, value2, "discount4");
            return (Criteria) this;
        }

        public Criteria andDiscount4NotBetween(Double value1, Double value2) {
            addCriterion("discount_4 not between", value1, value2, "discount4");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4IsNull() {
            addCriterion("discount_reason_4 is null");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4IsNotNull() {
            addCriterion("discount_reason_4 is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4EqualTo(String value) {
            addCriterion("discount_reason_4 =", value, "discountReason4");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4NotEqualTo(String value) {
            addCriterion("discount_reason_4 <>", value, "discountReason4");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4GreaterThan(String value) {
            addCriterion("discount_reason_4 >", value, "discountReason4");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4GreaterThanOrEqualTo(String value) {
            addCriterion("discount_reason_4 >=", value, "discountReason4");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4LessThan(String value) {
            addCriterion("discount_reason_4 <", value, "discountReason4");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4LessThanOrEqualTo(String value) {
            addCriterion("discount_reason_4 <=", value, "discountReason4");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4Like(String value) {
            addCriterion("discount_reason_4 like", value, "discountReason4");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4NotLike(String value) {
            addCriterion("discount_reason_4 not like", value, "discountReason4");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4In(List<String> values) {
            addCriterion("discount_reason_4 in", values, "discountReason4");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4NotIn(List<String> values) {
            addCriterion("discount_reason_4 not in", values, "discountReason4");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4Between(String value1, String value2) {
            addCriterion("discount_reason_4 between", value1, value2, "discountReason4");
            return (Criteria) this;
        }

        public Criteria andDiscountReason4NotBetween(String value1, String value2) {
            addCriterion("discount_reason_4 not between", value1, value2, "discountReason4");
            return (Criteria) this;
        }

        public Criteria andDiscount5IsNull() {
            addCriterion("discount_5 is null");
            return (Criteria) this;
        }

        public Criteria andDiscount5IsNotNull() {
            addCriterion("discount_5 is not null");
            return (Criteria) this;
        }

        public Criteria andDiscount5EqualTo(Double value) {
            addCriterion("discount_5 =", value, "discount5");
            return (Criteria) this;
        }

        public Criteria andDiscount5NotEqualTo(Double value) {
            addCriterion("discount_5 <>", value, "discount5");
            return (Criteria) this;
        }

        public Criteria andDiscount5GreaterThan(Double value) {
            addCriterion("discount_5 >", value, "discount5");
            return (Criteria) this;
        }

        public Criteria andDiscount5GreaterThanOrEqualTo(Double value) {
            addCriterion("discount_5 >=", value, "discount5");
            return (Criteria) this;
        }

        public Criteria andDiscount5LessThan(Double value) {
            addCriterion("discount_5 <", value, "discount5");
            return (Criteria) this;
        }

        public Criteria andDiscount5LessThanOrEqualTo(Double value) {
            addCriterion("discount_5 <=", value, "discount5");
            return (Criteria) this;
        }

        public Criteria andDiscount5In(List<Double> values) {
            addCriterion("discount_5 in", values, "discount5");
            return (Criteria) this;
        }

        public Criteria andDiscount5NotIn(List<Double> values) {
            addCriterion("discount_5 not in", values, "discount5");
            return (Criteria) this;
        }

        public Criteria andDiscount5Between(Double value1, Double value2) {
            addCriterion("discount_5 between", value1, value2, "discount5");
            return (Criteria) this;
        }

        public Criteria andDiscount5NotBetween(Double value1, Double value2) {
            addCriterion("discount_5 not between", value1, value2, "discount5");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5IsNull() {
            addCriterion("discount_reason_5 is null");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5IsNotNull() {
            addCriterion("discount_reason_5 is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5EqualTo(String value) {
            addCriterion("discount_reason_5 =", value, "discountReason5");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5NotEqualTo(String value) {
            addCriterion("discount_reason_5 <>", value, "discountReason5");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5GreaterThan(String value) {
            addCriterion("discount_reason_5 >", value, "discountReason5");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5GreaterThanOrEqualTo(String value) {
            addCriterion("discount_reason_5 >=", value, "discountReason5");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5LessThan(String value) {
            addCriterion("discount_reason_5 <", value, "discountReason5");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5LessThanOrEqualTo(String value) {
            addCriterion("discount_reason_5 <=", value, "discountReason5");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5Like(String value) {
            addCriterion("discount_reason_5 like", value, "discountReason5");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5NotLike(String value) {
            addCriterion("discount_reason_5 not like", value, "discountReason5");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5In(List<String> values) {
            addCriterion("discount_reason_5 in", values, "discountReason5");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5NotIn(List<String> values) {
            addCriterion("discount_reason_5 not in", values, "discountReason5");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5Between(String value1, String value2) {
            addCriterion("discount_reason_5 between", value1, value2, "discountReason5");
            return (Criteria) this;
        }

        public Criteria andDiscountReason5NotBetween(String value1, String value2) {
            addCriterion("discount_reason_5 not between", value1, value2, "discountReason5");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNull() {
            addCriterion("is_valid is null");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNotNull() {
            addCriterion("is_valid is not null");
            return (Criteria) this;
        }

        public Criteria andIsValidEqualTo(Integer value) {
            addCriterion("is_valid =", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotEqualTo(Integer value) {
            addCriterion("is_valid <>", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThan(Integer value) {
            addCriterion("is_valid >", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_valid >=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThan(Integer value) {
            addCriterion("is_valid <", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThanOrEqualTo(Integer value) {
            addCriterion("is_valid <=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidIn(List<Integer> values) {
            addCriterion("is_valid in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotIn(List<Integer> values) {
            addCriterion("is_valid not in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidBetween(Integer value1, Integer value2) {
            addCriterion("is_valid between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotBetween(Integer value1, Integer value2) {
            addCriterion("is_valid not between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleIsNull() {
            addCriterion("is_onsale is null");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleIsNotNull() {
            addCriterion("is_onsale is not null");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleEqualTo(Integer value) {
            addCriterion("is_onsale =", value, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleNotEqualTo(Integer value) {
            addCriterion("is_onsale <>", value, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleGreaterThan(Integer value) {
            addCriterion("is_onsale >", value, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_onsale >=", value, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleLessThan(Integer value) {
            addCriterion("is_onsale <", value, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleLessThanOrEqualTo(Integer value) {
            addCriterion("is_onsale <=", value, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleIn(List<Integer> values) {
            addCriterion("is_onsale in", values, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleNotIn(List<Integer> values) {
            addCriterion("is_onsale not in", values, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleBetween(Integer value1, Integer value2) {
            addCriterion("is_onsale between", value1, value2, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andIsOnsaleNotBetween(Integer value1, Integer value2) {
            addCriterion("is_onsale not between", value1, value2, "isOnsale");
            return (Criteria) this;
        }

        public Criteria andOnDateIsNull() {
            addCriterion("on_date is null");
            return (Criteria) this;
        }

        public Criteria andOnDateIsNotNull() {
            addCriterion("on_date is not null");
            return (Criteria) this;
        }

        public Criteria andOnDateEqualTo(Date value) {
            addCriterionForJDBCDate("on_date =", value, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("on_date <>", value, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateGreaterThan(Date value) {
            addCriterionForJDBCDate("on_date >", value, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("on_date >=", value, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateLessThan(Date value) {
            addCriterionForJDBCDate("on_date <", value, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("on_date <=", value, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateIn(List<Date> values) {
            addCriterionForJDBCDate("on_date in", values, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("on_date not in", values, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("on_date between", value1, value2, "onDate");
            return (Criteria) this;
        }

        public Criteria andOnDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("on_date not between", value1, value2, "onDate");
            return (Criteria) this;
        }

        public Criteria andOffDateIsNull() {
            addCriterion("off_date is null");
            return (Criteria) this;
        }

        public Criteria andOffDateIsNotNull() {
            addCriterion("off_date is not null");
            return (Criteria) this;
        }

        public Criteria andOffDateEqualTo(Date value) {
            addCriterionForJDBCDate("off_date =", value, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("off_date <>", value, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateGreaterThan(Date value) {
            addCriterionForJDBCDate("off_date >", value, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("off_date >=", value, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateLessThan(Date value) {
            addCriterionForJDBCDate("off_date <", value, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("off_date <=", value, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateIn(List<Date> values) {
            addCriterionForJDBCDate("off_date in", values, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("off_date not in", values, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("off_date between", value1, value2, "offDate");
            return (Criteria) this;
        }

        public Criteria andOffDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("off_date not between", value1, value2, "offDate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
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