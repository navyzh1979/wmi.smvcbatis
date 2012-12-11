package org.wmichina.crm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

public class SysRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4058087806087381656L;

	private Integer roleId;

    @Size(min=3,max=10,message="角色名称长度应在3位到10位之间.")
	private String roleName;
	private Integer auditStatus;
	private String statusDesc;
	private Integer isValid;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	private String remark;
	private List<SysRight> roleRights = new ArrayList<SysRight>();

	@Size(min=1,message="没有选择任何角色权限！")
	private String[] roleRightCodes;
	
	private String[] roleRightNames;
	
	public String[] getRoleRightNames() {
		return roleRightNames;
	}
	public void setRoleRightNames(String[] roleRightNames) {
		this.roleRightNames = roleRightNames;
	}
	public String[] getRoleRightCodes() {
		return roleRightCodes;
	}
	public void setRoleRightCodes(String[] roleRightCodes) {
		 this.roleRightCodes = roleRightCodes;
	}
	public List<SysRight> getRoleRights() {
		return roleRights;
	}
	/*Fill roleRightCodes/roleRightNames while setting roleeRights.*/
	public void setRoleRights(List<SysRight> roleRights) {
		this.roleRights = roleRights;
		if(roleRights!=null && roleRights.size()>0){
			this.roleRightCodes = new String[roleRights.size()];
			this.roleRightNames = new String[roleRights.size()];
			for(int i=0;i<roleRights.size();i++){
				SysRight sysRight = roleRights.get(i);
				this.roleRightCodes[i] = Integer.toString(sysRight.getRightId());
				this.roleRightNames[i] = sysRight.getRightName();
			}
		}
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
		if(this.auditStatus == 0){
			this.statusDesc="未审核";
		}else if(this.auditStatus == 1){
			this.statusDesc="审核通过";
		}
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
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
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder()
				.append("{roleId: ").append(this.roleId).append(", roleName: ").append(this.roleName)
				.append(", isValid: ").append(this.isValid).append(", auditStatus: ").append(this.auditStatus)
				.append(", [");
		for(SysRight right : roleRights){
			builder.append(right._shortDesc()).append(",");
		}
		builder.append("]}");
		
		return builder.toString();
		
	}
}
