package org.wmichina.crm.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BizChannelExample {
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

    public BizChannelExample() {
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

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Integer value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Integer value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Integer value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Integer value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Integer> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Integer> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNull() {
            addCriterion("channel_code is null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNotNull() {
            addCriterion("channel_code is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeEqualTo(String value) {
            addCriterion("channel_code =", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotEqualTo(String value) {
            addCriterion("channel_code <>", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThan(String value) {
            addCriterion("channel_code >", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("channel_code >=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThan(String value) {
            addCriterion("channel_code <", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThanOrEqualTo(String value) {
            addCriterion("channel_code <=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLike(String value) {
            addCriterion("channel_code like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotLike(String value) {
            addCriterion("channel_code not like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIn(List<String> values) {
            addCriterion("channel_code in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotIn(List<String> values) {
            addCriterion("channel_code not in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeBetween(String value1, String value2) {
            addCriterion("channel_code between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotBetween(String value1, String value2) {
            addCriterion("channel_code not between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNull() {
            addCriterion("channel_name is null");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNotNull() {
            addCriterion("channel_name is not null");
            return (Criteria) this;
        }

        public Criteria andChannelNameEqualTo(String value) {
            addCriterion("channel_name =", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotEqualTo(String value) {
            addCriterion("channel_name <>", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThan(String value) {
            addCriterion("channel_name >", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("channel_name >=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThan(String value) {
            addCriterion("channel_name <", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThanOrEqualTo(String value) {
            addCriterion("channel_name <=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLike(String value) {
            addCriterion("channel_name like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotLike(String value) {
            addCriterion("channel_name not like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameIn(List<String> values) {
            addCriterion("channel_name in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotIn(List<String> values) {
            addCriterion("channel_name not in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameBetween(String value1, String value2) {
            addCriterion("channel_name between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotBetween(String value1, String value2) {
            addCriterion("channel_name not between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelClass1IsNull() {
            addCriterion("channel_class_1 is null");
            return (Criteria) this;
        }

        public Criteria andChannelClass1IsNotNull() {
            addCriterion("channel_class_1 is not null");
            return (Criteria) this;
        }

        public Criteria andChannelClass1EqualTo(String value) {
            addCriterion("channel_class_1 =", value, "channelClass1");
            return (Criteria) this;
        }

        public Criteria andChannelClass1NotEqualTo(String value) {
            addCriterion("channel_class_1 <>", value, "channelClass1");
            return (Criteria) this;
        }

        public Criteria andChannelClass1GreaterThan(String value) {
            addCriterion("channel_class_1 >", value, "channelClass1");
            return (Criteria) this;
        }

        public Criteria andChannelClass1GreaterThanOrEqualTo(String value) {
            addCriterion("channel_class_1 >=", value, "channelClass1");
            return (Criteria) this;
        }

        public Criteria andChannelClass1LessThan(String value) {
            addCriterion("channel_class_1 <", value, "channelClass1");
            return (Criteria) this;
        }

        public Criteria andChannelClass1LessThanOrEqualTo(String value) {
            addCriterion("channel_class_1 <=", value, "channelClass1");
            return (Criteria) this;
        }

        public Criteria andChannelClass1Like(String value) {
            addCriterion("channel_class_1 like", value, "channelClass1");
            return (Criteria) this;
        }

        public Criteria andChannelClass1NotLike(String value) {
            addCriterion("channel_class_1 not like", value, "channelClass1");
            return (Criteria) this;
        }

        public Criteria andChannelClass1In(List<String> values) {
            addCriterion("channel_class_1 in", values, "channelClass1");
            return (Criteria) this;
        }

        public Criteria andChannelClass1NotIn(List<String> values) {
            addCriterion("channel_class_1 not in", values, "channelClass1");
            return (Criteria) this;
        }

        public Criteria andChannelClass1Between(String value1, String value2) {
            addCriterion("channel_class_1 between", value1, value2, "channelClass1");
            return (Criteria) this;
        }

        public Criteria andChannelClass1NotBetween(String value1, String value2) {
            addCriterion("channel_class_1 not between", value1, value2, "channelClass1");
            return (Criteria) this;
        }

        public Criteria andChannelClass2IsNull() {
            addCriterion("channel_class_2 is null");
            return (Criteria) this;
        }

        public Criteria andChannelClass2IsNotNull() {
            addCriterion("channel_class_2 is not null");
            return (Criteria) this;
        }

        public Criteria andChannelClass2EqualTo(String value) {
            addCriterion("channel_class_2 =", value, "channelClass2");
            return (Criteria) this;
        }

        public Criteria andChannelClass2NotEqualTo(String value) {
            addCriterion("channel_class_2 <>", value, "channelClass2");
            return (Criteria) this;
        }

        public Criteria andChannelClass2GreaterThan(String value) {
            addCriterion("channel_class_2 >", value, "channelClass2");
            return (Criteria) this;
        }

        public Criteria andChannelClass2GreaterThanOrEqualTo(String value) {
            addCriterion("channel_class_2 >=", value, "channelClass2");
            return (Criteria) this;
        }

        public Criteria andChannelClass2LessThan(String value) {
            addCriterion("channel_class_2 <", value, "channelClass2");
            return (Criteria) this;
        }

        public Criteria andChannelClass2LessThanOrEqualTo(String value) {
            addCriterion("channel_class_2 <=", value, "channelClass2");
            return (Criteria) this;
        }

        public Criteria andChannelClass2Like(String value) {
            addCriterion("channel_class_2 like", value, "channelClass2");
            return (Criteria) this;
        }

        public Criteria andChannelClass2NotLike(String value) {
            addCriterion("channel_class_2 not like", value, "channelClass2");
            return (Criteria) this;
        }

        public Criteria andChannelClass2In(List<String> values) {
            addCriterion("channel_class_2 in", values, "channelClass2");
            return (Criteria) this;
        }

        public Criteria andChannelClass2NotIn(List<String> values) {
            addCriterion("channel_class_2 not in", values, "channelClass2");
            return (Criteria) this;
        }

        public Criteria andChannelClass2Between(String value1, String value2) {
            addCriterion("channel_class_2 between", value1, value2, "channelClass2");
            return (Criteria) this;
        }

        public Criteria andChannelClass2NotBetween(String value1, String value2) {
            addCriterion("channel_class_2 not between", value1, value2, "channelClass2");
            return (Criteria) this;
        }

        public Criteria andChannelClass3IsNull() {
            addCriterion("channel_class_3 is null");
            return (Criteria) this;
        }

        public Criteria andChannelClass3IsNotNull() {
            addCriterion("channel_class_3 is not null");
            return (Criteria) this;
        }

        public Criteria andChannelClass3EqualTo(String value) {
            addCriterion("channel_class_3 =", value, "channelClass3");
            return (Criteria) this;
        }

        public Criteria andChannelClass3NotEqualTo(String value) {
            addCriterion("channel_class_3 <>", value, "channelClass3");
            return (Criteria) this;
        }

        public Criteria andChannelClass3GreaterThan(String value) {
            addCriterion("channel_class_3 >", value, "channelClass3");
            return (Criteria) this;
        }

        public Criteria andChannelClass3GreaterThanOrEqualTo(String value) {
            addCriterion("channel_class_3 >=", value, "channelClass3");
            return (Criteria) this;
        }

        public Criteria andChannelClass3LessThan(String value) {
            addCriterion("channel_class_3 <", value, "channelClass3");
            return (Criteria) this;
        }

        public Criteria andChannelClass3LessThanOrEqualTo(String value) {
            addCriterion("channel_class_3 <=", value, "channelClass3");
            return (Criteria) this;
        }

        public Criteria andChannelClass3Like(String value) {
            addCriterion("channel_class_3 like", value, "channelClass3");
            return (Criteria) this;
        }

        public Criteria andChannelClass3NotLike(String value) {
            addCriterion("channel_class_3 not like", value, "channelClass3");
            return (Criteria) this;
        }

        public Criteria andChannelClass3In(List<String> values) {
            addCriterion("channel_class_3 in", values, "channelClass3");
            return (Criteria) this;
        }

        public Criteria andChannelClass3NotIn(List<String> values) {
            addCriterion("channel_class_3 not in", values, "channelClass3");
            return (Criteria) this;
        }

        public Criteria andChannelClass3Between(String value1, String value2) {
            addCriterion("channel_class_3 between", value1, value2, "channelClass3");
            return (Criteria) this;
        }

        public Criteria andChannelClass3NotBetween(String value1, String value2) {
            addCriterion("channel_class_3 not between", value1, value2, "channelClass3");
            return (Criteria) this;
        }

        public Criteria andChannelClass4IsNull() {
            addCriterion("channel_class_4 is null");
            return (Criteria) this;
        }

        public Criteria andChannelClass4IsNotNull() {
            addCriterion("channel_class_4 is not null");
            return (Criteria) this;
        }

        public Criteria andChannelClass4EqualTo(String value) {
            addCriterion("channel_class_4 =", value, "channelClass4");
            return (Criteria) this;
        }

        public Criteria andChannelClass4NotEqualTo(String value) {
            addCriterion("channel_class_4 <>", value, "channelClass4");
            return (Criteria) this;
        }

        public Criteria andChannelClass4GreaterThan(String value) {
            addCriterion("channel_class_4 >", value, "channelClass4");
            return (Criteria) this;
        }

        public Criteria andChannelClass4GreaterThanOrEqualTo(String value) {
            addCriterion("channel_class_4 >=", value, "channelClass4");
            return (Criteria) this;
        }

        public Criteria andChannelClass4LessThan(String value) {
            addCriterion("channel_class_4 <", value, "channelClass4");
            return (Criteria) this;
        }

        public Criteria andChannelClass4LessThanOrEqualTo(String value) {
            addCriterion("channel_class_4 <=", value, "channelClass4");
            return (Criteria) this;
        }

        public Criteria andChannelClass4Like(String value) {
            addCriterion("channel_class_4 like", value, "channelClass4");
            return (Criteria) this;
        }

        public Criteria andChannelClass4NotLike(String value) {
            addCriterion("channel_class_4 not like", value, "channelClass4");
            return (Criteria) this;
        }

        public Criteria andChannelClass4In(List<String> values) {
            addCriterion("channel_class_4 in", values, "channelClass4");
            return (Criteria) this;
        }

        public Criteria andChannelClass4NotIn(List<String> values) {
            addCriterion("channel_class_4 not in", values, "channelClass4");
            return (Criteria) this;
        }

        public Criteria andChannelClass4Between(String value1, String value2) {
            addCriterion("channel_class_4 between", value1, value2, "channelClass4");
            return (Criteria) this;
        }

        public Criteria andChannelClass4NotBetween(String value1, String value2) {
            addCriterion("channel_class_4 not between", value1, value2, "channelClass4");
            return (Criteria) this;
        }

        public Criteria andChannelClass5IsNull() {
            addCriterion("channel_class_5 is null");
            return (Criteria) this;
        }

        public Criteria andChannelClass5IsNotNull() {
            addCriterion("channel_class_5 is not null");
            return (Criteria) this;
        }

        public Criteria andChannelClass5EqualTo(String value) {
            addCriterion("channel_class_5 =", value, "channelClass5");
            return (Criteria) this;
        }

        public Criteria andChannelClass5NotEqualTo(String value) {
            addCriterion("channel_class_5 <>", value, "channelClass5");
            return (Criteria) this;
        }

        public Criteria andChannelClass5GreaterThan(String value) {
            addCriterion("channel_class_5 >", value, "channelClass5");
            return (Criteria) this;
        }

        public Criteria andChannelClass5GreaterThanOrEqualTo(String value) {
            addCriterion("channel_class_5 >=", value, "channelClass5");
            return (Criteria) this;
        }

        public Criteria andChannelClass5LessThan(String value) {
            addCriterion("channel_class_5 <", value, "channelClass5");
            return (Criteria) this;
        }

        public Criteria andChannelClass5LessThanOrEqualTo(String value) {
            addCriterion("channel_class_5 <=", value, "channelClass5");
            return (Criteria) this;
        }

        public Criteria andChannelClass5Like(String value) {
            addCriterion("channel_class_5 like", value, "channelClass5");
            return (Criteria) this;
        }

        public Criteria andChannelClass5NotLike(String value) {
            addCriterion("channel_class_5 not like", value, "channelClass5");
            return (Criteria) this;
        }

        public Criteria andChannelClass5In(List<String> values) {
            addCriterion("channel_class_5 in", values, "channelClass5");
            return (Criteria) this;
        }

        public Criteria andChannelClass5NotIn(List<String> values) {
            addCriterion("channel_class_5 not in", values, "channelClass5");
            return (Criteria) this;
        }

        public Criteria andChannelClass5Between(String value1, String value2) {
            addCriterion("channel_class_5 between", value1, value2, "channelClass5");
            return (Criteria) this;
        }

        public Criteria andChannelClass5NotBetween(String value1, String value2) {
            addCriterion("channel_class_5 not between", value1, value2, "channelClass5");
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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