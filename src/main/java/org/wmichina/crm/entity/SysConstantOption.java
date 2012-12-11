package org.wmichina.crm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Size;

import org.json.JSONObject;

public class SysConstantOption implements Serializable {
	private static final long serialVersionUID = -3891887298301740646L;

	private String action="new";
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	private Integer optionId;
	private String optionCode;

    @Size(min=1,max=10,message="选项内容长度应在1位到10位之间.")
	private String optionName;
    
    @Size(min=1,max=6,message="请选择属性名称.")
	private String attrCode;
	private String attrName;

	@Size(min=1,max=6,message="请选择所属实体.")
	private String entityCode;
	private String entityName;
	private Integer isPredefined=0;
	private Integer isValid=1;
	private String createUser="system";
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	private String remark;
	
	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public String getOptionCode() {
		return optionCode;
	}

	public void setOptionCode(String optionCode) {
		this.optionCode = optionCode;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getAttrCode() {
		return attrCode;
	}

	public void setAttrCode(String attrCode) {
		this.attrCode = attrCode;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Integer getIsPredefined() {
		return isPredefined;
	}

	public void setIsPredefined(Integer isPredefined) {
		this.isPredefined = isPredefined;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String _shortDesc(){
		return new StringBuilder()
				.append("(").append(this.optionCode).append(",").append(this.optionName)
				.append("->").append(this.attrCode).append(",").append(this.attrName)
				.append("->").append(this.entityCode).append(",").append(this.entityName).append(")")
				.toString();
	}
	
	@Override
	public String toString(){
		return new JSONObject(this).toString();
	}
	
}
