package org.wmichina.crm.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentExample {

	private Integer start, end;

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

	public StudentExample() {
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

		public Criteria andStudentNoIsNull() {
			addCriterion("student_no is null");
			return (Criteria) this;
		}

		public Criteria andStudentNoIsNotNull() {
			addCriterion("student_no is not null");
			return (Criteria) this;
		}

		public Criteria andStudentNoEqualTo(String value) {
			addCriterion("student_no =", value, "studentNo");
			return (Criteria) this;
		}

		public Criteria andStudentNoNotEqualTo(String value) {
			addCriterion("student_no <>", value, "studentNo");
			return (Criteria) this;
		}

		public Criteria andStudentNoGreaterThan(String value) {
			addCriterion("student_no >", value, "studentNo");
			return (Criteria) this;
		}

		public Criteria andStudentNoGreaterThanOrEqualTo(String value) {
			addCriterion("student_no >=", value, "studentNo");
			return (Criteria) this;
		}

		public Criteria andStudentNoLessThan(String value) {
			addCriterion("student_no <", value, "studentNo");
			return (Criteria) this;
		}

		public Criteria andStudentNoLessThanOrEqualTo(String value) {
			addCriterion("student_no <=", value, "studentNo");
			return (Criteria) this;
		}

		public Criteria andStudentNoLike(String value) {
			addCriterion("student_no like", value, "studentNo");
			return (Criteria) this;
		}

		public Criteria andStudentNoNotLike(String value) {
			addCriterion("student_no not like", value, "studentNo");
			return (Criteria) this;
		}

		public Criteria andStudentNoIn(List<String> values) {
			addCriterion("student_no in", values, "studentNo");
			return (Criteria) this;
		}

		public Criteria andStudentNoNotIn(List<String> values) {
			addCriterion("student_no not in", values, "studentNo");
			return (Criteria) this;
		}

		public Criteria andStudentNoBetween(String value1, String value2) {
			addCriterion("student_no between", value1, value2, "studentNo");
			return (Criteria) this;
		}

		public Criteria andStudentNoNotBetween(String value1, String value2) {
			addCriterion("student_no not between", value1, value2, "studentNo");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andMobileIsNull() {
			addCriterion("mobile is null");
			return (Criteria) this;
		}

		public Criteria andMobileIsNotNull() {
			addCriterion("mobile is not null");
			return (Criteria) this;
		}

		public Criteria andMobileEqualTo(String value) {
			addCriterion("mobile =", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotEqualTo(String value) {
			addCriterion("mobile <>", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThan(String value) {
			addCriterion("mobile >", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThanOrEqualTo(String value) {
			addCriterion("mobile >=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThan(String value) {
			addCriterion("mobile <", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThanOrEqualTo(String value) {
			addCriterion("mobile <=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLike(String value) {
			addCriterion("mobile like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotLike(String value) {
			addCriterion("mobile not like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileIn(List<String> values) {
			addCriterion("mobile in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotIn(List<String> values) {
			addCriterion("mobile not in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileBetween(String value1, String value2) {
			addCriterion("mobile between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotBetween(String value1, String value2) {
			addCriterion("mobile not between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andStudentTypeIsNull() {
			addCriterion("student_type is null");
			return (Criteria) this;
		}

		public Criteria andStudentTypeIsNotNull() {
			addCriterion("student_type is not null");
			return (Criteria) this;
		}

		public Criteria andStudentTypeEqualTo(Integer value) {
			addCriterion("student_type =", value, "studentType");
			return (Criteria) this;
		}

		public Criteria andStudentTypeNotEqualTo(Integer value) {
			addCriterion("student_type <>", value, "studentType");
			return (Criteria) this;
		}

		public Criteria andStudentTypeGreaterThan(Integer value) {
			addCriterion("student_type >", value, "studentType");
			return (Criteria) this;
		}

		public Criteria andStudentTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("student_type >=", value, "studentType");
			return (Criteria) this;
		}

		public Criteria andStudentTypeLessThan(Integer value) {
			addCriterion("student_type <", value, "studentType");
			return (Criteria) this;
		}

		public Criteria andStudentTypeLessThanOrEqualTo(Integer value) {
			addCriterion("student_type <=", value, "studentType");
			return (Criteria) this;
		}

		public Criteria andStudentTypeIn(List<Integer> values) {
			addCriterion("student_type in", values, "studentType");
			return (Criteria) this;
		}

		public Criteria andStudentTypeNotIn(List<Integer> values) {
			addCriterion("student_type not in", values, "studentType");
			return (Criteria) this;
		}

		public Criteria andStudentTypeBetween(Integer value1, Integer value2) {
			addCriterion("student_type between", value1, value2, "studentType");
			return (Criteria) this;
		}

		public Criteria andStudentTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("student_type not between", value1, value2, "studentType");
			return (Criteria) this;
		}

		public Criteria andStudentLevelIsNull() {
			addCriterion("student_level is null");
			return (Criteria) this;
		}

		public Criteria andStudentLevelIsNotNull() {
			addCriterion("student_level is not null");
			return (Criteria) this;
		}

		public Criteria andStudentLevelEqualTo(Integer value) {
			addCriterion("student_level =", value, "studentLevel");
			return (Criteria) this;
		}

		public Criteria andStudentLevelNotEqualTo(Integer value) {
			addCriterion("student_level <>", value, "studentLevel");
			return (Criteria) this;
		}

		public Criteria andStudentLevelGreaterThan(Integer value) {
			addCriterion("student_level >", value, "studentLevel");
			return (Criteria) this;
		}

		public Criteria andStudentLevelGreaterThanOrEqualTo(Integer value) {
			addCriterion("student_level >=", value, "studentLevel");
			return (Criteria) this;
		}

		public Criteria andStudentLevelLessThan(Integer value) {
			addCriterion("student_level <", value, "studentLevel");
			return (Criteria) this;
		}

		public Criteria andStudentLevelLessThanOrEqualTo(Integer value) {
			addCriterion("student_level <=", value, "studentLevel");
			return (Criteria) this;
		}

		public Criteria andStudentLevelIn(List<Integer> values) {
			addCriterion("student_level in", values, "studentLevel");
			return (Criteria) this;
		}

		public Criteria andStudentLevelNotIn(List<Integer> values) {
			addCriterion("student_level not in", values, "studentLevel");
			return (Criteria) this;
		}

		public Criteria andStudentLevelBetween(Integer value1, Integer value2) {
			addCriterion("student_level between", value1, value2, "studentLevel");
			return (Criteria) this;
		}

		public Criteria andStudentLevelNotBetween(Integer value1, Integer value2) {
			addCriterion("student_level not between", value1, value2, "studentLevel");
			return (Criteria) this;
		}

		public Criteria andMemberLevelIsNull() {
			addCriterion("member_level is null");
			return (Criteria) this;
		}

		public Criteria andMemberLevelIsNotNull() {
			addCriterion("member_level is not null");
			return (Criteria) this;
		}

		public Criteria andMemberLevelEqualTo(Integer value) {
			addCriterion("member_level =", value, "memberLevel");
			return (Criteria) this;
		}

		public Criteria andMemberLevelNotEqualTo(Integer value) {
			addCriterion("member_level <>", value, "memberLevel");
			return (Criteria) this;
		}

		public Criteria andMemberLevelGreaterThan(Integer value) {
			addCriterion("member_level >", value, "memberLevel");
			return (Criteria) this;
		}

		public Criteria andMemberLevelGreaterThanOrEqualTo(Integer value) {
			addCriterion("member_level >=", value, "memberLevel");
			return (Criteria) this;
		}

		public Criteria andMemberLevelLessThan(Integer value) {
			addCriterion("member_level <", value, "memberLevel");
			return (Criteria) this;
		}

		public Criteria andMemberLevelLessThanOrEqualTo(Integer value) {
			addCriterion("member_level <=", value, "memberLevel");
			return (Criteria) this;
		}

		public Criteria andMemberLevelIn(List<Integer> values) {
			addCriterion("member_level in", values, "memberLevel");
			return (Criteria) this;
		}

		public Criteria andMemberLevelNotIn(List<Integer> values) {
			addCriterion("member_level not in", values, "memberLevel");
			return (Criteria) this;
		}

		public Criteria andMemberLevelBetween(Integer value1, Integer value2) {
			addCriterion("member_level between", value1, value2, "memberLevel");
			return (Criteria) this;
		}

		public Criteria andMemberLevelNotBetween(Integer value1, Integer value2) {
			addCriterion("member_level not between", value1, value2, "memberLevel");
			return (Criteria) this;
		}

		public Criteria andStudentStatusIsNull() {
			addCriterion("student_status is null");
			return (Criteria) this;
		}

		public Criteria andStudentStatusIsNotNull() {
			addCriterion("student_status is not null");
			return (Criteria) this;
		}

		public Criteria andStudentStatusEqualTo(String value) {
			addCriterion("student_status =", value, "studentStatus");
			return (Criteria) this;
		}

		public Criteria andStudentStatusNotEqualTo(String value) {
			addCriterion("student_status <>", value, "studentStatus");
			return (Criteria) this;
		}

		public Criteria andStudentStatusGreaterThan(String value) {
			addCriterion("student_status >", value, "studentStatus");
			return (Criteria) this;
		}

		public Criteria andStudentStatusGreaterThanOrEqualTo(String value) {
			addCriterion("student_status >=", value, "studentStatus");
			return (Criteria) this;
		}

		public Criteria andStudentStatusLessThan(String value) {
			addCriterion("student_status <", value, "studentStatus");
			return (Criteria) this;
		}

		public Criteria andStudentStatusLessThanOrEqualTo(String value) {
			addCriterion("student_status <=", value, "studentStatus");
			return (Criteria) this;
		}

		public Criteria andStudentStatusLike(String value) {
			addCriterion("student_status like", value, "studentStatus");
			return (Criteria) this;
		}

		public Criteria andStudentStatusNotLike(String value) {
			addCriterion("student_status not like", value, "studentStatus");
			return (Criteria) this;
		}

		public Criteria andStudentStatusIn(List<String> values) {
			addCriterion("student_status in", values, "studentStatus");
			return (Criteria) this;
		}

		public Criteria andStudentStatusNotIn(List<String> values) {
			addCriterion("student_status not in", values, "studentStatus");
			return (Criteria) this;
		}

		public Criteria andStudentStatusBetween(String value1, String value2) {
			addCriterion("student_status between", value1, value2, "studentStatus");
			return (Criteria) this;
		}

		public Criteria andStudentStatusNotBetween(String value1, String value2) {
			addCriterion("student_status not between", value1, value2, "studentStatus");
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

		public Criteria andSexIsNull() {
			addCriterion("sex is null");
			return (Criteria) this;
		}

		public Criteria andSexIsNotNull() {
			addCriterion("sex is not null");
			return (Criteria) this;
		}

		public Criteria andSexEqualTo(Integer value) {
			addCriterion("sex =", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotEqualTo(Integer value) {
			addCriterion("sex <>", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThan(Integer value) {
			addCriterion("sex >", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThanOrEqualTo(Integer value) {
			addCriterion("sex >=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThan(Integer value) {
			addCriterion("sex <", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThanOrEqualTo(Integer value) {
			addCriterion("sex <=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexIn(List<Integer> values) {
			addCriterion("sex in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotIn(List<Integer> values) {
			addCriterion("sex not in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexBetween(Integer value1, Integer value2) {
			addCriterion("sex between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotBetween(Integer value1, Integer value2) {
			addCriterion("sex not between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andBirthdayIsNull() {
			addCriterion("birthday is null");
			return (Criteria) this;
		}

		public Criteria andBirthdayIsNotNull() {
			addCriterion("birthday is not null");
			return (Criteria) this;
		}

		public Criteria andBirthdayEqualTo(Date value) {
			addCriterionForJDBCDate("birthday =", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotEqualTo(Date value) {
			addCriterionForJDBCDate("birthday <>", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayGreaterThan(Date value) {
			addCriterionForJDBCDate("birthday >", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("birthday >=", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayLessThan(Date value) {
			addCriterionForJDBCDate("birthday <", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("birthday <=", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayIn(List<Date> values) {
			addCriterionForJDBCDate("birthday in", values, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotIn(List<Date> values) {
			addCriterionForJDBCDate("birthday not in", values, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
			return (Criteria) this;
		}

		public Criteria andNationIsNull() {
			addCriterion("nation is null");
			return (Criteria) this;
		}

		public Criteria andNationIsNotNull() {
			addCriterion("nation is not null");
			return (Criteria) this;
		}

		public Criteria andNationEqualTo(String value) {
			addCriterion("nation =", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotEqualTo(String value) {
			addCriterion("nation <>", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationGreaterThan(String value) {
			addCriterion("nation >", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationGreaterThanOrEqualTo(String value) {
			addCriterion("nation >=", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLessThan(String value) {
			addCriterion("nation <", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLessThanOrEqualTo(String value) {
			addCriterion("nation <=", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLike(String value) {
			addCriterion("nation like", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotLike(String value) {
			addCriterion("nation not like", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationIn(List<String> values) {
			addCriterion("nation in", values, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotIn(List<String> values) {
			addCriterion("nation not in", values, "nation");
			return (Criteria) this;
		}

		public Criteria andNationBetween(String value1, String value2) {
			addCriterion("nation between", value1, value2, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotBetween(String value1, String value2) {
			addCriterion("nation not between", value1, value2, "nation");
			return (Criteria) this;
		}

		public Criteria andProvinceIsNull() {
			addCriterion("province is null");
			return (Criteria) this;
		}

		public Criteria andProvinceIsNotNull() {
			addCriterion("province is not null");
			return (Criteria) this;
		}

		public Criteria andProvinceEqualTo(String value) {
			addCriterion("province =", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotEqualTo(String value) {
			addCriterion("province <>", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceGreaterThan(String value) {
			addCriterion("province >", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceGreaterThanOrEqualTo(String value) {
			addCriterion("province >=", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceLessThan(String value) {
			addCriterion("province <", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceLessThanOrEqualTo(String value) {
			addCriterion("province <=", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceLike(String value) {
			addCriterion("province like", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotLike(String value) {
			addCriterion("province not like", value, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceIn(List<String> values) {
			addCriterion("province in", values, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotIn(List<String> values) {
			addCriterion("province not in", values, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceBetween(String value1, String value2) {
			addCriterion("province between", value1, value2, "province");
			return (Criteria) this;
		}

		public Criteria andProvinceNotBetween(String value1, String value2) {
			addCriterion("province not between", value1, value2, "province");
			return (Criteria) this;
		}

		public Criteria andCityIsNull() {
			addCriterion("city is null");
			return (Criteria) this;
		}

		public Criteria andCityIsNotNull() {
			addCriterion("city is not null");
			return (Criteria) this;
		}

		public Criteria andCityEqualTo(String value) {
			addCriterion("city =", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotEqualTo(String value) {
			addCriterion("city <>", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityGreaterThan(String value) {
			addCriterion("city >", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityGreaterThanOrEqualTo(String value) {
			addCriterion("city >=", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLessThan(String value) {
			addCriterion("city <", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLessThanOrEqualTo(String value) {
			addCriterion("city <=", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityLike(String value) {
			addCriterion("city like", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotLike(String value) {
			addCriterion("city not like", value, "city");
			return (Criteria) this;
		}

		public Criteria andCityIn(List<String> values) {
			addCriterion("city in", values, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotIn(List<String> values) {
			addCriterion("city not in", values, "city");
			return (Criteria) this;
		}

		public Criteria andCityBetween(String value1, String value2) {
			addCriterion("city between", value1, value2, "city");
			return (Criteria) this;
		}

		public Criteria andCityNotBetween(String value1, String value2) {
			addCriterion("city not between", value1, value2, "city");
			return (Criteria) this;
		}

		public Criteria andAreaIsNull() {
			addCriterion("area is null");
			return (Criteria) this;
		}

		public Criteria andAreaIsNotNull() {
			addCriterion("area is not null");
			return (Criteria) this;
		}

		public Criteria andAreaEqualTo(String value) {
			addCriterion("area =", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotEqualTo(String value) {
			addCriterion("area <>", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaGreaterThan(String value) {
			addCriterion("area >", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaGreaterThanOrEqualTo(String value) {
			addCriterion("area >=", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLessThan(String value) {
			addCriterion("area <", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLessThanOrEqualTo(String value) {
			addCriterion("area <=", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLike(String value) {
			addCriterion("area like", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotLike(String value) {
			addCriterion("area not like", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaIn(List<String> values) {
			addCriterion("area in", values, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotIn(List<String> values) {
			addCriterion("area not in", values, "area");
			return (Criteria) this;
		}

		public Criteria andAreaBetween(String value1, String value2) {
			addCriterion("area between", value1, value2, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotBetween(String value1, String value2) {
			addCriterion("area not between", value1, value2, "area");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("address is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("address is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("address =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("address <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("address >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("address >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("address <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("address <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("address like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("address not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("address in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("address not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("address between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("address not between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andPostcodeIsNull() {
			addCriterion("postcode is null");
			return (Criteria) this;
		}

		public Criteria andPostcodeIsNotNull() {
			addCriterion("postcode is not null");
			return (Criteria) this;
		}

		public Criteria andPostcodeEqualTo(String value) {
			addCriterion("postcode =", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeNotEqualTo(String value) {
			addCriterion("postcode <>", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeGreaterThan(String value) {
			addCriterion("postcode >", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
			addCriterion("postcode >=", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeLessThan(String value) {
			addCriterion("postcode <", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeLessThanOrEqualTo(String value) {
			addCriterion("postcode <=", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeLike(String value) {
			addCriterion("postcode like", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeNotLike(String value) {
			addCriterion("postcode not like", value, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeIn(List<String> values) {
			addCriterion("postcode in", values, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeNotIn(List<String> values) {
			addCriterion("postcode not in", values, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeBetween(String value1, String value2) {
			addCriterion("postcode between", value1, value2, "postcode");
			return (Criteria) this;
		}

		public Criteria andPostcodeNotBetween(String value1, String value2) {
			addCriterion("postcode not between", value1, value2, "postcode");
			return (Criteria) this;
		}

		public Criteria andTelphoneIsNull() {
			addCriterion("telphone is null");
			return (Criteria) this;
		}

		public Criteria andTelphoneIsNotNull() {
			addCriterion("telphone is not null");
			return (Criteria) this;
		}

		public Criteria andTelphoneEqualTo(String value) {
			addCriterion("telphone =", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneNotEqualTo(String value) {
			addCriterion("telphone <>", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneGreaterThan(String value) {
			addCriterion("telphone >", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneGreaterThanOrEqualTo(String value) {
			addCriterion("telphone >=", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneLessThan(String value) {
			addCriterion("telphone <", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneLessThanOrEqualTo(String value) {
			addCriterion("telphone <=", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneLike(String value) {
			addCriterion("telphone like", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneNotLike(String value) {
			addCriterion("telphone not like", value, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneIn(List<String> values) {
			addCriterion("telphone in", values, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneNotIn(List<String> values) {
			addCriterion("telphone not in", values, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneBetween(String value1, String value2) {
			addCriterion("telphone between", value1, value2, "telphone");
			return (Criteria) this;
		}

		public Criteria andTelphoneNotBetween(String value1, String value2) {
			addCriterion("telphone not between", value1, value2, "telphone");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyIsNull() {
			addCriterion("email_standby is null");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyIsNotNull() {
			addCriterion("email_standby is not null");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyEqualTo(String value) {
			addCriterion("email_standby =", value, "emailStandby");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyNotEqualTo(String value) {
			addCriterion("email_standby <>", value, "emailStandby");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyGreaterThan(String value) {
			addCriterion("email_standby >", value, "emailStandby");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyGreaterThanOrEqualTo(String value) {
			addCriterion("email_standby >=", value, "emailStandby");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyLessThan(String value) {
			addCriterion("email_standby <", value, "emailStandby");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyLessThanOrEqualTo(String value) {
			addCriterion("email_standby <=", value, "emailStandby");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyLike(String value) {
			addCriterion("email_standby like", value, "emailStandby");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyNotLike(String value) {
			addCriterion("email_standby not like", value, "emailStandby");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyIn(List<String> values) {
			addCriterion("email_standby in", values, "emailStandby");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyNotIn(List<String> values) {
			addCriterion("email_standby not in", values, "emailStandby");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyBetween(String value1, String value2) {
			addCriterion("email_standby between", value1, value2, "emailStandby");
			return (Criteria) this;
		}

		public Criteria andEmailStandbyNotBetween(String value1, String value2) {
			addCriterion("email_standby not between", value1, value2, "emailStandby");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyIsNull() {
			addCriterion("mobile_standby is null");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyIsNotNull() {
			addCriterion("mobile_standby is not null");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyEqualTo(String value) {
			addCriterion("mobile_standby =", value, "mobileStandby");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyNotEqualTo(String value) {
			addCriterion("mobile_standby <>", value, "mobileStandby");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyGreaterThan(String value) {
			addCriterion("mobile_standby >", value, "mobileStandby");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyGreaterThanOrEqualTo(String value) {
			addCriterion("mobile_standby >=", value, "mobileStandby");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyLessThan(String value) {
			addCriterion("mobile_standby <", value, "mobileStandby");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyLessThanOrEqualTo(String value) {
			addCriterion("mobile_standby <=", value, "mobileStandby");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyLike(String value) {
			addCriterion("mobile_standby like", value, "mobileStandby");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyNotLike(String value) {
			addCriterion("mobile_standby not like", value, "mobileStandby");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyIn(List<String> values) {
			addCriterion("mobile_standby in", values, "mobileStandby");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyNotIn(List<String> values) {
			addCriterion("mobile_standby not in", values, "mobileStandby");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyBetween(String value1, String value2) {
			addCriterion("mobile_standby between", value1, value2, "mobileStandby");
			return (Criteria) this;
		}

		public Criteria andMobileStandbyNotBetween(String value1, String value2) {
			addCriterion("mobile_standby not between", value1, value2, "mobileStandby");
			return (Criteria) this;
		}

		public Criteria andContactQqIsNull() {
			addCriterion("contact_qq is null");
			return (Criteria) this;
		}

		public Criteria andContactQqIsNotNull() {
			addCriterion("contact_qq is not null");
			return (Criteria) this;
		}

		public Criteria andContactQqEqualTo(String value) {
			addCriterion("contact_qq =", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqNotEqualTo(String value) {
			addCriterion("contact_qq <>", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqGreaterThan(String value) {
			addCriterion("contact_qq >", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqGreaterThanOrEqualTo(String value) {
			addCriterion("contact_qq >=", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqLessThan(String value) {
			addCriterion("contact_qq <", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqLessThanOrEqualTo(String value) {
			addCriterion("contact_qq <=", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqLike(String value) {
			addCriterion("contact_qq like", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqNotLike(String value) {
			addCriterion("contact_qq not like", value, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqIn(List<String> values) {
			addCriterion("contact_qq in", values, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqNotIn(List<String> values) {
			addCriterion("contact_qq not in", values, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqBetween(String value1, String value2) {
			addCriterion("contact_qq between", value1, value2, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactQqNotBetween(String value1, String value2) {
			addCriterion("contact_qq not between", value1, value2, "contactQq");
			return (Criteria) this;
		}

		public Criteria andContactMsnIsNull() {
			addCriterion("contact_msn is null");
			return (Criteria) this;
		}

		public Criteria andContactMsnIsNotNull() {
			addCriterion("contact_msn is not null");
			return (Criteria) this;
		}

		public Criteria andContactMsnEqualTo(String value) {
			addCriterion("contact_msn =", value, "contactMsn");
			return (Criteria) this;
		}

		public Criteria andContactMsnNotEqualTo(String value) {
			addCriterion("contact_msn <>", value, "contactMsn");
			return (Criteria) this;
		}

		public Criteria andContactMsnGreaterThan(String value) {
			addCriterion("contact_msn >", value, "contactMsn");
			return (Criteria) this;
		}

		public Criteria andContactMsnGreaterThanOrEqualTo(String value) {
			addCriterion("contact_msn >=", value, "contactMsn");
			return (Criteria) this;
		}

		public Criteria andContactMsnLessThan(String value) {
			addCriterion("contact_msn <", value, "contactMsn");
			return (Criteria) this;
		}

		public Criteria andContactMsnLessThanOrEqualTo(String value) {
			addCriterion("contact_msn <=", value, "contactMsn");
			return (Criteria) this;
		}

		public Criteria andContactMsnLike(String value) {
			addCriterion("contact_msn like", value, "contactMsn");
			return (Criteria) this;
		}

		public Criteria andContactMsnNotLike(String value) {
			addCriterion("contact_msn not like", value, "contactMsn");
			return (Criteria) this;
		}

		public Criteria andContactMsnIn(List<String> values) {
			addCriterion("contact_msn in", values, "contactMsn");
			return (Criteria) this;
		}

		public Criteria andContactMsnNotIn(List<String> values) {
			addCriterion("contact_msn not in", values, "contactMsn");
			return (Criteria) this;
		}

		public Criteria andContactMsnBetween(String value1, String value2) {
			addCriterion("contact_msn between", value1, value2, "contactMsn");
			return (Criteria) this;
		}

		public Criteria andContactMsnNotBetween(String value1, String value2) {
			addCriterion("contact_msn not between", value1, value2, "contactMsn");
			return (Criteria) this;
		}

		public Criteria andContactWeiboIsNull() {
			addCriterion("contact_weibo is null");
			return (Criteria) this;
		}

		public Criteria andContactWeiboIsNotNull() {
			addCriterion("contact_weibo is not null");
			return (Criteria) this;
		}

		public Criteria andContactWeiboEqualTo(String value) {
			addCriterion("contact_weibo =", value, "contactWeibo");
			return (Criteria) this;
		}

		public Criteria andContactWeiboNotEqualTo(String value) {
			addCriterion("contact_weibo <>", value, "contactWeibo");
			return (Criteria) this;
		}

		public Criteria andContactWeiboGreaterThan(String value) {
			addCriterion("contact_weibo >", value, "contactWeibo");
			return (Criteria) this;
		}

		public Criteria andContactWeiboGreaterThanOrEqualTo(String value) {
			addCriterion("contact_weibo >=", value, "contactWeibo");
			return (Criteria) this;
		}

		public Criteria andContactWeiboLessThan(String value) {
			addCriterion("contact_weibo <", value, "contactWeibo");
			return (Criteria) this;
		}

		public Criteria andContactWeiboLessThanOrEqualTo(String value) {
			addCriterion("contact_weibo <=", value, "contactWeibo");
			return (Criteria) this;
		}

		public Criteria andContactWeiboLike(String value) {
			addCriterion("contact_weibo like", value, "contactWeibo");
			return (Criteria) this;
		}

		public Criteria andContactWeiboNotLike(String value) {
			addCriterion("contact_weibo not like", value, "contactWeibo");
			return (Criteria) this;
		}

		public Criteria andContactWeiboIn(List<String> values) {
			addCriterion("contact_weibo in", values, "contactWeibo");
			return (Criteria) this;
		}

		public Criteria andContactWeiboNotIn(List<String> values) {
			addCriterion("contact_weibo not in", values, "contactWeibo");
			return (Criteria) this;
		}

		public Criteria andContactWeiboBetween(String value1, String value2) {
			addCriterion("contact_weibo between", value1, value2, "contactWeibo");
			return (Criteria) this;
		}

		public Criteria andContactWeiboNotBetween(String value1, String value2) {
			addCriterion("contact_weibo not between", value1, value2, "contactWeibo");
			return (Criteria) this;
		}

		public Criteria andContactOthersIsNull() {
			addCriterion("contact_others is null");
			return (Criteria) this;
		}

		public Criteria andContactOthersIsNotNull() {
			addCriterion("contact_others is not null");
			return (Criteria) this;
		}

		public Criteria andContactOthersEqualTo(String value) {
			addCriterion("contact_others =", value, "contactOthers");
			return (Criteria) this;
		}

		public Criteria andContactOthersNotEqualTo(String value) {
			addCriterion("contact_others <>", value, "contactOthers");
			return (Criteria) this;
		}

		public Criteria andContactOthersGreaterThan(String value) {
			addCriterion("contact_others >", value, "contactOthers");
			return (Criteria) this;
		}

		public Criteria andContactOthersGreaterThanOrEqualTo(String value) {
			addCriterion("contact_others >=", value, "contactOthers");
			return (Criteria) this;
		}

		public Criteria andContactOthersLessThan(String value) {
			addCriterion("contact_others <", value, "contactOthers");
			return (Criteria) this;
		}

		public Criteria andContactOthersLessThanOrEqualTo(String value) {
			addCriterion("contact_others <=", value, "contactOthers");
			return (Criteria) this;
		}

		public Criteria andContactOthersLike(String value) {
			addCriterion("contact_others like", value, "contactOthers");
			return (Criteria) this;
		}

		public Criteria andContactOthersNotLike(String value) {
			addCriterion("contact_others not like", value, "contactOthers");
			return (Criteria) this;
		}

		public Criteria andContactOthersIn(List<String> values) {
			addCriterion("contact_others in", values, "contactOthers");
			return (Criteria) this;
		}

		public Criteria andContactOthersNotIn(List<String> values) {
			addCriterion("contact_others not in", values, "contactOthers");
			return (Criteria) this;
		}

		public Criteria andContactOthersBetween(String value1, String value2) {
			addCriterion("contact_others between", value1, value2, "contactOthers");
			return (Criteria) this;
		}

		public Criteria andContactOthersNotBetween(String value1, String value2) {
			addCriterion("contact_others not between", value1, value2, "contactOthers");
			return (Criteria) this;
		}

		public Criteria andSourceChannelIsNull() {
			addCriterion("source_channel is null");
			return (Criteria) this;
		}

		public Criteria andSourceChannelIsNotNull() {
			addCriterion("source_channel is not null");
			return (Criteria) this;
		}

		public Criteria andSourceChannelEqualTo(String value) {
			addCriterion("source_channel =", value, "sourceChannel");
			return (Criteria) this;
		}

		public Criteria andSourceChannelNotEqualTo(String value) {
			addCriterion("source_channel <>", value, "sourceChannel");
			return (Criteria) this;
		}

		public Criteria andSourceChannelGreaterThan(String value) {
			addCriterion("source_channel >", value, "sourceChannel");
			return (Criteria) this;
		}

		public Criteria andSourceChannelGreaterThanOrEqualTo(String value) {
			addCriterion("source_channel >=", value, "sourceChannel");
			return (Criteria) this;
		}

		public Criteria andSourceChannelLessThan(String value) {
			addCriterion("source_channel <", value, "sourceChannel");
			return (Criteria) this;
		}

		public Criteria andSourceChannelLessThanOrEqualTo(String value) {
			addCriterion("source_channel <=", value, "sourceChannel");
			return (Criteria) this;
		}

		public Criteria andSourceChannelLike(String value) {
			addCriterion("source_channel like", value, "sourceChannel");
			return (Criteria) this;
		}

		public Criteria andSourceChannelNotLike(String value) {
			addCriterion("source_channel not like", value, "sourceChannel");
			return (Criteria) this;
		}

		public Criteria andSourceChannelIn(List<String> values) {
			addCriterion("source_channel in", values, "sourceChannel");
			return (Criteria) this;
		}

		public Criteria andSourceChannelNotIn(List<String> values) {
			addCriterion("source_channel not in", values, "sourceChannel");
			return (Criteria) this;
		}

		public Criteria andSourceChannelBetween(String value1, String value2) {
			addCriterion("source_channel between", value1, value2, "sourceChannel");
			return (Criteria) this;
		}

		public Criteria andSourceChannelNotBetween(String value1, String value2) {
			addCriterion("source_channel not between", value1, value2, "sourceChannel");
			return (Criteria) this;
		}

		public Criteria andSourceActivityIsNull() {
			addCriterion("source_activity is null");
			return (Criteria) this;
		}

		public Criteria andSourceActivityIsNotNull() {
			addCriterion("source_activity is not null");
			return (Criteria) this;
		}

		public Criteria andSourceActivityEqualTo(String value) {
			addCriterion("source_activity =", value, "sourceActivity");
			return (Criteria) this;
		}

		public Criteria andSourceActivityNotEqualTo(String value) {
			addCriterion("source_activity <>", value, "sourceActivity");
			return (Criteria) this;
		}

		public Criteria andSourceActivityGreaterThan(String value) {
			addCriterion("source_activity >", value, "sourceActivity");
			return (Criteria) this;
		}

		public Criteria andSourceActivityGreaterThanOrEqualTo(String value) {
			addCriterion("source_activity >=", value, "sourceActivity");
			return (Criteria) this;
		}

		public Criteria andSourceActivityLessThan(String value) {
			addCriterion("source_activity <", value, "sourceActivity");
			return (Criteria) this;
		}

		public Criteria andSourceActivityLessThanOrEqualTo(String value) {
			addCriterion("source_activity <=", value, "sourceActivity");
			return (Criteria) this;
		}

		public Criteria andSourceActivityLike(String value) {
			addCriterion("source_activity like", value, "sourceActivity");
			return (Criteria) this;
		}

		public Criteria andSourceActivityNotLike(String value) {
			addCriterion("source_activity not like", value, "sourceActivity");
			return (Criteria) this;
		}

		public Criteria andSourceActivityIn(List<String> values) {
			addCriterion("source_activity in", values, "sourceActivity");
			return (Criteria) this;
		}

		public Criteria andSourceActivityNotIn(List<String> values) {
			addCriterion("source_activity not in", values, "sourceActivity");
			return (Criteria) this;
		}

		public Criteria andSourceActivityBetween(String value1, String value2) {
			addCriterion("source_activity between", value1, value2, "sourceActivity");
			return (Criteria) this;
		}

		public Criteria andSourceActivityNotBetween(String value1, String value2) {
			addCriterion("source_activity not between", value1, value2, "sourceActivity");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartIsNull() {
			addCriterion("assigned_depart is null");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartIsNotNull() {
			addCriterion("assigned_depart is not null");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartEqualTo(String value) {
			addCriterion("assigned_depart =", value, "assignedDepart");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartNotEqualTo(String value) {
			addCriterion("assigned_depart <>", value, "assignedDepart");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartGreaterThan(String value) {
			addCriterion("assigned_depart >", value, "assignedDepart");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartGreaterThanOrEqualTo(String value) {
			addCriterion("assigned_depart >=", value, "assignedDepart");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartLessThan(String value) {
			addCriterion("assigned_depart <", value, "assignedDepart");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartLessThanOrEqualTo(String value) {
			addCriterion("assigned_depart <=", value, "assignedDepart");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartLike(String value) {
			addCriterion("assigned_depart like", value, "assignedDepart");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartNotLike(String value) {
			addCriterion("assigned_depart not like", value, "assignedDepart");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartIn(List<String> values) {
			addCriterion("assigned_depart in", values, "assignedDepart");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartNotIn(List<String> values) {
			addCriterion("assigned_depart not in", values, "assignedDepart");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartBetween(String value1, String value2) {
			addCriterion("assigned_depart between", value1, value2, "assignedDepart");
			return (Criteria) this;
		}

		public Criteria andAssignedDepartNotBetween(String value1, String value2) {
			addCriterion("assigned_depart not between", value1, value2, "assignedDepart");
			return (Criteria) this;
		}

		public Criteria andAssignedUserIsNull() {
			addCriterion("assigned_user is null");
			return (Criteria) this;
		}

		public Criteria andAssignedUserIsNotNull() {
			addCriterion("assigned_user is not null");
			return (Criteria) this;
		}

		public Criteria andAssignedUserEqualTo(String value) {
			addCriterion("assigned_user =", value, "assignedUser");
			return (Criteria) this;
		}

		public Criteria andAssignedUserNotEqualTo(String value) {
			addCriterion("assigned_user <>", value, "assignedUser");
			return (Criteria) this;
		}

		public Criteria andAssignedUserGreaterThan(String value) {
			addCriterion("assigned_user >", value, "assignedUser");
			return (Criteria) this;
		}

		public Criteria andAssignedUserGreaterThanOrEqualTo(String value) {
			addCriterion("assigned_user >=", value, "assignedUser");
			return (Criteria) this;
		}

		public Criteria andAssignedUserLessThan(String value) {
			addCriterion("assigned_user <", value, "assignedUser");
			return (Criteria) this;
		}

		public Criteria andAssignedUserLessThanOrEqualTo(String value) {
			addCriterion("assigned_user <=", value, "assignedUser");
			return (Criteria) this;
		}

		public Criteria andAssignedUserLike(String value) {
			addCriterion("assigned_user like", value, "assignedUser");
			return (Criteria) this;
		}

		public Criteria andAssignedUserNotLike(String value) {
			addCriterion("assigned_user not like", value, "assignedUser");
			return (Criteria) this;
		}

		public Criteria andAssignedUserIn(List<String> values) {
			addCriterion("assigned_user in", values, "assignedUser");
			return (Criteria) this;
		}

		public Criteria andAssignedUserNotIn(List<String> values) {
			addCriterion("assigned_user not in", values, "assignedUser");
			return (Criteria) this;
		}

		public Criteria andAssignedUserBetween(String value1, String value2) {
			addCriterion("assigned_user between", value1, value2, "assignedUser");
			return (Criteria) this;
		}

		public Criteria andAssignedUserNotBetween(String value1, String value2) {
			addCriterion("assigned_user not between", value1, value2, "assignedUser");
			return (Criteria) this;
		}

		public Criteria andLastOwnerIsNull() {
			addCriterion("last_owner is null");
			return (Criteria) this;
		}

		public Criteria andLastOwnerIsNotNull() {
			addCriterion("last_owner is not null");
			return (Criteria) this;
		}

		public Criteria andLastOwnerEqualTo(String value) {
			addCriterion("last_owner =", value, "lastOwner");
			return (Criteria) this;
		}

		public Criteria andLastOwnerNotEqualTo(String value) {
			addCriterion("last_owner <>", value, "lastOwner");
			return (Criteria) this;
		}

		public Criteria andLastOwnerGreaterThan(String value) {
			addCriterion("last_owner >", value, "lastOwner");
			return (Criteria) this;
		}

		public Criteria andLastOwnerGreaterThanOrEqualTo(String value) {
			addCriterion("last_owner >=", value, "lastOwner");
			return (Criteria) this;
		}

		public Criteria andLastOwnerLessThan(String value) {
			addCriterion("last_owner <", value, "lastOwner");
			return (Criteria) this;
		}

		public Criteria andLastOwnerLessThanOrEqualTo(String value) {
			addCriterion("last_owner <=", value, "lastOwner");
			return (Criteria) this;
		}

		public Criteria andLastOwnerLike(String value) {
			addCriterion("last_owner like", value, "lastOwner");
			return (Criteria) this;
		}

		public Criteria andLastOwnerNotLike(String value) {
			addCriterion("last_owner not like", value, "lastOwner");
			return (Criteria) this;
		}

		public Criteria andLastOwnerIn(List<String> values) {
			addCriterion("last_owner in", values, "lastOwner");
			return (Criteria) this;
		}

		public Criteria andLastOwnerNotIn(List<String> values) {
			addCriterion("last_owner not in", values, "lastOwner");
			return (Criteria) this;
		}

		public Criteria andLastOwnerBetween(String value1, String value2) {
			addCriterion("last_owner between", value1, value2, "lastOwner");
			return (Criteria) this;
		}

		public Criteria andLastOwnerNotBetween(String value1, String value2) {
			addCriterion("last_owner not between", value1, value2, "lastOwner");
			return (Criteria) this;
		}

		public Criteria andJobIndustryIsNull() {
			addCriterion("job_industry is null");
			return (Criteria) this;
		}

		public Criteria andJobIndustryIsNotNull() {
			addCriterion("job_industry is not null");
			return (Criteria) this;
		}

		public Criteria andJobIndustryEqualTo(String value) {
			addCriterion("job_industry =", value, "jobIndustry");
			return (Criteria) this;
		}

		public Criteria andJobIndustryNotEqualTo(String value) {
			addCriterion("job_industry <>", value, "jobIndustry");
			return (Criteria) this;
		}

		public Criteria andJobIndustryGreaterThan(String value) {
			addCriterion("job_industry >", value, "jobIndustry");
			return (Criteria) this;
		}

		public Criteria andJobIndustryGreaterThanOrEqualTo(String value) {
			addCriterion("job_industry >=", value, "jobIndustry");
			return (Criteria) this;
		}

		public Criteria andJobIndustryLessThan(String value) {
			addCriterion("job_industry <", value, "jobIndustry");
			return (Criteria) this;
		}

		public Criteria andJobIndustryLessThanOrEqualTo(String value) {
			addCriterion("job_industry <=", value, "jobIndustry");
			return (Criteria) this;
		}

		public Criteria andJobIndustryLike(String value) {
			addCriterion("job_industry like", value, "jobIndustry");
			return (Criteria) this;
		}

		public Criteria andJobIndustryNotLike(String value) {
			addCriterion("job_industry not like", value, "jobIndustry");
			return (Criteria) this;
		}

		public Criteria andJobIndustryIn(List<String> values) {
			addCriterion("job_industry in", values, "jobIndustry");
			return (Criteria) this;
		}

		public Criteria andJobIndustryNotIn(List<String> values) {
			addCriterion("job_industry not in", values, "jobIndustry");
			return (Criteria) this;
		}

		public Criteria andJobIndustryBetween(String value1, String value2) {
			addCriterion("job_industry between", value1, value2, "jobIndustry");
			return (Criteria) this;
		}

		public Criteria andJobIndustryNotBetween(String value1, String value2) {
			addCriterion("job_industry not between", value1, value2, "jobIndustry");
			return (Criteria) this;
		}

		public Criteria andJobTitleIsNull() {
			addCriterion("job_title is null");
			return (Criteria) this;
		}

		public Criteria andJobTitleIsNotNull() {
			addCriterion("job_title is not null");
			return (Criteria) this;
		}

		public Criteria andJobTitleEqualTo(String value) {
			addCriterion("job_title =", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleNotEqualTo(String value) {
			addCriterion("job_title <>", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleGreaterThan(String value) {
			addCriterion("job_title >", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleGreaterThanOrEqualTo(String value) {
			addCriterion("job_title >=", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleLessThan(String value) {
			addCriterion("job_title <", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleLessThanOrEqualTo(String value) {
			addCriterion("job_title <=", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleLike(String value) {
			addCriterion("job_title like", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleNotLike(String value) {
			addCriterion("job_title not like", value, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleIn(List<String> values) {
			addCriterion("job_title in", values, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleNotIn(List<String> values) {
			addCriterion("job_title not in", values, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleBetween(String value1, String value2) {
			addCriterion("job_title between", value1, value2, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobTitleNotBetween(String value1, String value2) {
			addCriterion("job_title not between", value1, value2, "jobTitle");
			return (Criteria) this;
		}

		public Criteria andJobCompanyIsNull() {
			addCriterion("job_company is null");
			return (Criteria) this;
		}

		public Criteria andJobCompanyIsNotNull() {
			addCriterion("job_company is not null");
			return (Criteria) this;
		}

		public Criteria andJobCompanyEqualTo(String value) {
			addCriterion("job_company =", value, "jobCompany");
			return (Criteria) this;
		}

		public Criteria andJobCompanyNotEqualTo(String value) {
			addCriterion("job_company <>", value, "jobCompany");
			return (Criteria) this;
		}

		public Criteria andJobCompanyGreaterThan(String value) {
			addCriterion("job_company >", value, "jobCompany");
			return (Criteria) this;
		}

		public Criteria andJobCompanyGreaterThanOrEqualTo(String value) {
			addCriterion("job_company >=", value, "jobCompany");
			return (Criteria) this;
		}

		public Criteria andJobCompanyLessThan(String value) {
			addCriterion("job_company <", value, "jobCompany");
			return (Criteria) this;
		}

		public Criteria andJobCompanyLessThanOrEqualTo(String value) {
			addCriterion("job_company <=", value, "jobCompany");
			return (Criteria) this;
		}

		public Criteria andJobCompanyLike(String value) {
			addCriterion("job_company like", value, "jobCompany");
			return (Criteria) this;
		}

		public Criteria andJobCompanyNotLike(String value) {
			addCriterion("job_company not like", value, "jobCompany");
			return (Criteria) this;
		}

		public Criteria andJobCompanyIn(List<String> values) {
			addCriterion("job_company in", values, "jobCompany");
			return (Criteria) this;
		}

		public Criteria andJobCompanyNotIn(List<String> values) {
			addCriterion("job_company not in", values, "jobCompany");
			return (Criteria) this;
		}

		public Criteria andJobCompanyBetween(String value1, String value2) {
			addCriterion("job_company between", value1, value2, "jobCompany");
			return (Criteria) this;
		}

		public Criteria andJobCompanyNotBetween(String value1, String value2) {
			addCriterion("job_company not between", value1, value2, "jobCompany");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneIsNull() {
			addCriterion("job_telphone is null");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneIsNotNull() {
			addCriterion("job_telphone is not null");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneEqualTo(String value) {
			addCriterion("job_telphone =", value, "jobTelphone");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneNotEqualTo(String value) {
			addCriterion("job_telphone <>", value, "jobTelphone");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneGreaterThan(String value) {
			addCriterion("job_telphone >", value, "jobTelphone");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneGreaterThanOrEqualTo(String value) {
			addCriterion("job_telphone >=", value, "jobTelphone");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneLessThan(String value) {
			addCriterion("job_telphone <", value, "jobTelphone");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneLessThanOrEqualTo(String value) {
			addCriterion("job_telphone <=", value, "jobTelphone");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneLike(String value) {
			addCriterion("job_telphone like", value, "jobTelphone");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneNotLike(String value) {
			addCriterion("job_telphone not like", value, "jobTelphone");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneIn(List<String> values) {
			addCriterion("job_telphone in", values, "jobTelphone");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneNotIn(List<String> values) {
			addCriterion("job_telphone not in", values, "jobTelphone");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneBetween(String value1, String value2) {
			addCriterion("job_telphone between", value1, value2, "jobTelphone");
			return (Criteria) this;
		}

		public Criteria andJobTelphoneNotBetween(String value1, String value2) {
			addCriterion("job_telphone not between", value1, value2, "jobTelphone");
			return (Criteria) this;
		}

		public Criteria andJobAddressIsNull() {
			addCriterion("job_address is null");
			return (Criteria) this;
		}

		public Criteria andJobAddressIsNotNull() {
			addCriterion("job_address is not null");
			return (Criteria) this;
		}

		public Criteria andJobAddressEqualTo(String value) {
			addCriterion("job_address =", value, "jobAddress");
			return (Criteria) this;
		}

		public Criteria andJobAddressNotEqualTo(String value) {
			addCriterion("job_address <>", value, "jobAddress");
			return (Criteria) this;
		}

		public Criteria andJobAddressGreaterThan(String value) {
			addCriterion("job_address >", value, "jobAddress");
			return (Criteria) this;
		}

		public Criteria andJobAddressGreaterThanOrEqualTo(String value) {
			addCriterion("job_address >=", value, "jobAddress");
			return (Criteria) this;
		}

		public Criteria andJobAddressLessThan(String value) {
			addCriterion("job_address <", value, "jobAddress");
			return (Criteria) this;
		}

		public Criteria andJobAddressLessThanOrEqualTo(String value) {
			addCriterion("job_address <=", value, "jobAddress");
			return (Criteria) this;
		}

		public Criteria andJobAddressLike(String value) {
			addCriterion("job_address like", value, "jobAddress");
			return (Criteria) this;
		}

		public Criteria andJobAddressNotLike(String value) {
			addCriterion("job_address not like", value, "jobAddress");
			return (Criteria) this;
		}

		public Criteria andJobAddressIn(List<String> values) {
			addCriterion("job_address in", values, "jobAddress");
			return (Criteria) this;
		}

		public Criteria andJobAddressNotIn(List<String> values) {
			addCriterion("job_address not in", values, "jobAddress");
			return (Criteria) this;
		}

		public Criteria andJobAddressBetween(String value1, String value2) {
			addCriterion("job_address between", value1, value2, "jobAddress");
			return (Criteria) this;
		}

		public Criteria andJobAddressNotBetween(String value1, String value2) {
			addCriterion("job_address not between", value1, value2, "jobAddress");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeIsNull() {
			addCriterion("job_postcode is null");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeIsNotNull() {
			addCriterion("job_postcode is not null");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeEqualTo(String value) {
			addCriterion("job_postcode =", value, "jobPostcode");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeNotEqualTo(String value) {
			addCriterion("job_postcode <>", value, "jobPostcode");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeGreaterThan(String value) {
			addCriterion("job_postcode >", value, "jobPostcode");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeGreaterThanOrEqualTo(String value) {
			addCriterion("job_postcode >=", value, "jobPostcode");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeLessThan(String value) {
			addCriterion("job_postcode <", value, "jobPostcode");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeLessThanOrEqualTo(String value) {
			addCriterion("job_postcode <=", value, "jobPostcode");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeLike(String value) {
			addCriterion("job_postcode like", value, "jobPostcode");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeNotLike(String value) {
			addCriterion("job_postcode not like", value, "jobPostcode");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeIn(List<String> values) {
			addCriterion("job_postcode in", values, "jobPostcode");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeNotIn(List<String> values) {
			addCriterion("job_postcode not in", values, "jobPostcode");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeBetween(String value1, String value2) {
			addCriterion("job_postcode between", value1, value2, "jobPostcode");
			return (Criteria) this;
		}

		public Criteria andJobPostcodeNotBetween(String value1, String value2) {
			addCriterion("job_postcode not between", value1, value2, "jobPostcode");
			return (Criteria) this;
		}

		public Criteria andEduDegreeIsNull() {
			addCriterion("edu_degree is null");
			return (Criteria) this;
		}

		public Criteria andEduDegreeIsNotNull() {
			addCriterion("edu_degree is not null");
			return (Criteria) this;
		}

		public Criteria andEduDegreeEqualTo(String value) {
			addCriterion("edu_degree =", value, "eduDegree");
			return (Criteria) this;
		}

		public Criteria andEduDegreeNotEqualTo(String value) {
			addCriterion("edu_degree <>", value, "eduDegree");
			return (Criteria) this;
		}

		public Criteria andEduDegreeGreaterThan(String value) {
			addCriterion("edu_degree >", value, "eduDegree");
			return (Criteria) this;
		}

		public Criteria andEduDegreeGreaterThanOrEqualTo(String value) {
			addCriterion("edu_degree >=", value, "eduDegree");
			return (Criteria) this;
		}

		public Criteria andEduDegreeLessThan(String value) {
			addCriterion("edu_degree <", value, "eduDegree");
			return (Criteria) this;
		}

		public Criteria andEduDegreeLessThanOrEqualTo(String value) {
			addCriterion("edu_degree <=", value, "eduDegree");
			return (Criteria) this;
		}

		public Criteria andEduDegreeLike(String value) {
			addCriterion("edu_degree like", value, "eduDegree");
			return (Criteria) this;
		}

		public Criteria andEduDegreeNotLike(String value) {
			addCriterion("edu_degree not like", value, "eduDegree");
			return (Criteria) this;
		}

		public Criteria andEduDegreeIn(List<String> values) {
			addCriterion("edu_degree in", values, "eduDegree");
			return (Criteria) this;
		}

		public Criteria andEduDegreeNotIn(List<String> values) {
			addCriterion("edu_degree not in", values, "eduDegree");
			return (Criteria) this;
		}

		public Criteria andEduDegreeBetween(String value1, String value2) {
			addCriterion("edu_degree between", value1, value2, "eduDegree");
			return (Criteria) this;
		}

		public Criteria andEduDegreeNotBetween(String value1, String value2) {
			addCriterion("edu_degree not between", value1, value2, "eduDegree");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateIsNull() {
			addCriterion("edu_graduation_date is null");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateIsNotNull() {
			addCriterion("edu_graduation_date is not null");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateEqualTo(String value) {
			addCriterion("edu_graduation_date =", value, "eduGraduationDate");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateNotEqualTo(String value) {
			addCriterion("edu_graduation_date <>", value, "eduGraduationDate");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateGreaterThan(String value) {
			addCriterion("edu_graduation_date >", value, "eduGraduationDate");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateGreaterThanOrEqualTo(String value) {
			addCriterion("edu_graduation_date >=", value, "eduGraduationDate");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateLessThan(String value) {
			addCriterion("edu_graduation_date <", value, "eduGraduationDate");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateLessThanOrEqualTo(String value) {
			addCriterion("edu_graduation_date <=", value, "eduGraduationDate");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateLike(String value) {
			addCriterion("edu_graduation_date like", value, "eduGraduationDate");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateNotLike(String value) {
			addCriterion("edu_graduation_date not like", value, "eduGraduationDate");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateIn(List<String> values) {
			addCriterion("edu_graduation_date in", values, "eduGraduationDate");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateNotIn(List<String> values) {
			addCriterion("edu_graduation_date not in", values, "eduGraduationDate");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateBetween(String value1, String value2) {
			addCriterion("edu_graduation_date between", value1, value2, "eduGraduationDate");
			return (Criteria) this;
		}

		public Criteria andEduGraduationDateNotBetween(String value1, String value2) {
			addCriterion("edu_graduation_date not between", value1, value2, "eduGraduationDate");
			return (Criteria) this;
		}

		public Criteria andEduSchoolIsNull() {
			addCriterion("edu_school is null");
			return (Criteria) this;
		}

		public Criteria andEduSchoolIsNotNull() {
			addCriterion("edu_school is not null");
			return (Criteria) this;
		}

		public Criteria andEduSchoolEqualTo(String value) {
			addCriterion("edu_school =", value, "eduSchool");
			return (Criteria) this;
		}

		public Criteria andEduSchoolNotEqualTo(String value) {
			addCriterion("edu_school <>", value, "eduSchool");
			return (Criteria) this;
		}

		public Criteria andEduSchoolGreaterThan(String value) {
			addCriterion("edu_school >", value, "eduSchool");
			return (Criteria) this;
		}

		public Criteria andEduSchoolGreaterThanOrEqualTo(String value) {
			addCriterion("edu_school >=", value, "eduSchool");
			return (Criteria) this;
		}

		public Criteria andEduSchoolLessThan(String value) {
			addCriterion("edu_school <", value, "eduSchool");
			return (Criteria) this;
		}

		public Criteria andEduSchoolLessThanOrEqualTo(String value) {
			addCriterion("edu_school <=", value, "eduSchool");
			return (Criteria) this;
		}

		public Criteria andEduSchoolLike(String value) {
			addCriterion("edu_school like", value, "eduSchool");
			return (Criteria) this;
		}

		public Criteria andEduSchoolNotLike(String value) {
			addCriterion("edu_school not like", value, "eduSchool");
			return (Criteria) this;
		}

		public Criteria andEduSchoolIn(List<String> values) {
			addCriterion("edu_school in", values, "eduSchool");
			return (Criteria) this;
		}

		public Criteria andEduSchoolNotIn(List<String> values) {
			addCriterion("edu_school not in", values, "eduSchool");
			return (Criteria) this;
		}

		public Criteria andEduSchoolBetween(String value1, String value2) {
			addCriterion("edu_school between", value1, value2, "eduSchool");
			return (Criteria) this;
		}

		public Criteria andEduSchoolNotBetween(String value1, String value2) {
			addCriterion("edu_school not between", value1, value2, "eduSchool");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityIsNull() {
			addCriterion("edu_speciality is null");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityIsNotNull() {
			addCriterion("edu_speciality is not null");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityEqualTo(String value) {
			addCriterion("edu_speciality =", value, "eduSpeciality");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityNotEqualTo(String value) {
			addCriterion("edu_speciality <>", value, "eduSpeciality");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityGreaterThan(String value) {
			addCriterion("edu_speciality >", value, "eduSpeciality");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityGreaterThanOrEqualTo(String value) {
			addCriterion("edu_speciality >=", value, "eduSpeciality");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityLessThan(String value) {
			addCriterion("edu_speciality <", value, "eduSpeciality");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityLessThanOrEqualTo(String value) {
			addCriterion("edu_speciality <=", value, "eduSpeciality");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityLike(String value) {
			addCriterion("edu_speciality like", value, "eduSpeciality");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityNotLike(String value) {
			addCriterion("edu_speciality not like", value, "eduSpeciality");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityIn(List<String> values) {
			addCriterion("edu_speciality in", values, "eduSpeciality");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityNotIn(List<String> values) {
			addCriterion("edu_speciality not in", values, "eduSpeciality");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityBetween(String value1, String value2) {
			addCriterion("edu_speciality between", value1, value2, "eduSpeciality");
			return (Criteria) this;
		}

		public Criteria andEduSpecialityNotBetween(String value1, String value2) {
			addCriterion("edu_speciality not between", value1, value2, "eduSpeciality");
			return (Criteria) this;
		}

		public Criteria andEduAddressIsNull() {
			addCriterion("edu_address is null");
			return (Criteria) this;
		}

		public Criteria andEduAddressIsNotNull() {
			addCriterion("edu_address is not null");
			return (Criteria) this;
		}

		public Criteria andEduAddressEqualTo(String value) {
			addCriterion("edu_address =", value, "eduAddress");
			return (Criteria) this;
		}

		public Criteria andEduAddressNotEqualTo(String value) {
			addCriterion("edu_address <>", value, "eduAddress");
			return (Criteria) this;
		}

		public Criteria andEduAddressGreaterThan(String value) {
			addCriterion("edu_address >", value, "eduAddress");
			return (Criteria) this;
		}

		public Criteria andEduAddressGreaterThanOrEqualTo(String value) {
			addCriterion("edu_address >=", value, "eduAddress");
			return (Criteria) this;
		}

		public Criteria andEduAddressLessThan(String value) {
			addCriterion("edu_address <", value, "eduAddress");
			return (Criteria) this;
		}

		public Criteria andEduAddressLessThanOrEqualTo(String value) {
			addCriterion("edu_address <=", value, "eduAddress");
			return (Criteria) this;
		}

		public Criteria andEduAddressLike(String value) {
			addCriterion("edu_address like", value, "eduAddress");
			return (Criteria) this;
		}

		public Criteria andEduAddressNotLike(String value) {
			addCriterion("edu_address not like", value, "eduAddress");
			return (Criteria) this;
		}

		public Criteria andEduAddressIn(List<String> values) {
			addCriterion("edu_address in", values, "eduAddress");
			return (Criteria) this;
		}

		public Criteria andEduAddressNotIn(List<String> values) {
			addCriterion("edu_address not in", values, "eduAddress");
			return (Criteria) this;
		}

		public Criteria andEduAddressBetween(String value1, String value2) {
			addCriterion("edu_address between", value1, value2, "eduAddress");
			return (Criteria) this;
		}

		public Criteria andEduAddressNotBetween(String value1, String value2) {
			addCriterion("edu_address not between", value1, value2, "eduAddress");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeIsNull() {
			addCriterion("edu_postcode is null");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeIsNotNull() {
			addCriterion("edu_postcode is not null");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeEqualTo(String value) {
			addCriterion("edu_postcode =", value, "eduPostcode");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeNotEqualTo(String value) {
			addCriterion("edu_postcode <>", value, "eduPostcode");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeGreaterThan(String value) {
			addCriterion("edu_postcode >", value, "eduPostcode");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeGreaterThanOrEqualTo(String value) {
			addCriterion("edu_postcode >=", value, "eduPostcode");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeLessThan(String value) {
			addCriterion("edu_postcode <", value, "eduPostcode");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeLessThanOrEqualTo(String value) {
			addCriterion("edu_postcode <=", value, "eduPostcode");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeLike(String value) {
			addCriterion("edu_postcode like", value, "eduPostcode");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeNotLike(String value) {
			addCriterion("edu_postcode not like", value, "eduPostcode");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeIn(List<String> values) {
			addCriterion("edu_postcode in", values, "eduPostcode");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeNotIn(List<String> values) {
			addCriterion("edu_postcode not in", values, "eduPostcode");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeBetween(String value1, String value2) {
			addCriterion("edu_postcode between", value1, value2, "eduPostcode");
			return (Criteria) this;
		}

		public Criteria andEduPostcodeNotBetween(String value1, String value2) {
			addCriterion("edu_postcode not between", value1, value2, "eduPostcode");
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