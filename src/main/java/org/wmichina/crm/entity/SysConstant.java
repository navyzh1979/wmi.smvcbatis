package org.wmichina.crm.entity;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

public class SysConstant implements Serializable {
	private static final long serialVersionUID = -3891887298301740646L;
	
	private Integer constantId;
	private String constantCode;
	private String constantName;
	private Integer constantLevel;
	private String parentCode;
	private String parentName;
	private Integer isPredefined=0;
	private Integer isValid=1;
	private String createUser="system";
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	private String remark;
	
	public Integer getConstantId() {
		return constantId;
	}
	public void setConstantId(Integer constantId) {
		this.constantId = constantId;
	}
	public String getConstantCode() {
		return constantCode;
	}
	public void setConstantCode(String constantCode) {
		this.constantCode = constantCode;
	}
	public String getConstantName() {
		return constantName;
	}
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}
	public Integer getConstantLevel() {
		return constantLevel;
	}
	public void setConstantLevel(Integer constantLevel) {
		this.constantLevel = constantLevel;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
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
				.append("(").append(this.constantCode).append(",").append(this.constantName)
				.append(",").append(this.constantLevel).append(",").append(this.parentCode)
				.append(",").append(this.parentName).append(")")
				.toString();
	}
	public String _middleDesc(){
		return new StringBuilder()
				.append("(").append(this.constantCode).append(",").append(this.constantName)
				.append(",").append(this.constantLevel).append(",").append(this.parentCode)
				.append(",").append(this.parentName).append(",").append(this.constantId)
				.append(")")
				.toString();
	}
	
	@Override
	public String toString(){
		return new JSONObject(this).toString();
	}
	
}
