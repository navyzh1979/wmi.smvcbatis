package org.wmichina.crm.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class BizActivity {
	private String action="new";
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
    private Integer activityId;

    @Size(min=4,max=20,message="活动标识长度应在4位到20位之间.")
    private String activityCode;

    @Size(min=4,max=20,message="活动主题长度应在4位到20位之间.")
    private String activityName;

    private String activityClass1;

    private String activityClass2;

    private String activityClass3;

    private Integer isValid;
    
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date startDate;

    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date endDate;

    @Size(min=1,message="活动描述不能为空.")
    private String description;

    private Date createDate;

    private String createUser;

    private Date updateDate;

    private String updateUser;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityClass1() {
        return activityClass1;
    }

    public void setActivityClass1(String activityClass1) {
        this.activityClass1 = activityClass1;
    }

    public String getActivityClass2() {
        return activityClass2;
    }

    public void setActivityClass2(String activityClass2) {
        this.activityClass2 = activityClass2;
    }

    public String getActivityClass3() {
        return activityClass3;
    }

    public void setActivityClass3(String activityClass3) {
        this.activityClass3 = activityClass3;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}