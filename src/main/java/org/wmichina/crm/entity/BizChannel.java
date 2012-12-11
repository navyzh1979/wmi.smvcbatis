package org.wmichina.crm.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class BizChannel {
	private String action="new";
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
    private Integer channelId;

    @Size(min=4,max=20,message="来源标识长度应在4位到20位之间.")
    private String channelCode;

    @Size(min=4,max=20,message="来源名称长度应在4位到20位之间.")
    private String channelName;

    private String channelClass1;

    private String channelClass2;

    private String channelClass3;

    private String channelClass4;

    private String channelClass5;

    private Integer isValid;

    @NotEmpty(message="来源描述不能为空.")
    private String description;

    private Date createDate;

    private String createUser;

    private Date updateDate;

    private String updateUser;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelClass1() {
        return channelClass1;
    }

    public void setChannelClass1(String channelClass1) {
        this.channelClass1 = channelClass1;
    }

    public String getChannelClass2() {
        return channelClass2;
    }

    public void setChannelClass2(String channelClass2) {
        this.channelClass2 = channelClass2;
    }

    public String getChannelClass3() {
        return channelClass3;
    }

    public void setChannelClass3(String channelClass3) {
        this.channelClass3 = channelClass3;
    }

    public String getChannelClass4() {
        return channelClass4;
    }

    public void setChannelClass4(String channelClass4) {
        this.channelClass4 = channelClass4;
    }

    public String getChannelClass5() {
        return channelClass5;
    }

    public void setChannelClass5(String channelClass5) {
        this.channelClass5 = channelClass5;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
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