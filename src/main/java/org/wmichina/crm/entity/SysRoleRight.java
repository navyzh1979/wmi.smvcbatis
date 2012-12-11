package org.wmichina.crm.entity;

import java.io.Serializable;
import java.util.Date;


public class SysRoleRight implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2951687827169403653L;
	
	private Integer roleRightId;
	private Integer roleId;
	private Integer rightId;
	private String createUser;
	private Date createDate;
	public Integer getRoleRightId() {
		return roleRightId;
	}
	public void setRoleRightId(Integer roleRightId) {
		this.roleRightId = roleRightId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getRightId() {
		return rightId;
	}
	public void setRightId(Integer rightId) {
		this.rightId = rightId;
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
	
}
