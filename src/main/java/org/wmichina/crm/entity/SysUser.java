package org.wmichina.crm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.StringUtils;
import org.wmichina.crm.helper.Mobile;

public class SysUser implements Serializable {

	private static final long serialVersionUID = -4379946602240085123L;

	private String action="new";
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	private Integer userId;
    
    @Size(min=4,max=20,message="用户名长度应在4位到20位之间.")
    private String loginName;

    @Size(min=6,max=20,message="密码长度应在6位到20位之间.")
    private String loginPwd;

    @Size(min=2,max=20,message="姓名长度应在2位到20位之间.")
    private String userName;

    @NotNull(message="请选择性别.")
    private Integer userSex;

    @Email(message="邮箱格式不正确。")
    private String email;

    @Mobile
    private String mobile;

    @NotEmpty(message="请选择部门.")
    private String department;
    
    private Integer auditStatus;
    private String statusDesc;

    private Integer isValid;

    private Date createDate;

    private String createUser;

    private Date updateDate;

    private String updateUser;

    private String remark;

    private Date lastLoginTime;

    private String lastLoginIp;

	@Size(min=1,message="没有选择任何角色！")
	private String[] roleIds;
	private String[] roleNames;

	private String[] roleRightCodes;
	private String[] roleRightNames;
	
	private List<SysRole> roles = new ArrayList<SysRole>();
	private List<SysRight> rights = new ArrayList<SysRight>();

    public String[] getRoleRightCodes() {
		return roleRightCodes;
	}

	public void setRoleRightCodes(String[] roleRightCodes) {
		this.roleRightCodes = roleRightCodes;
	}

	public String[] getRoleRightNames() {
		return roleRightNames;
	}

	public void setRoleRightNames(String[] roleRightNames) {
		this.roleRightNames = roleRightNames;
	}

	public String[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}

	public String[] getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String[] roleNames) {
		this.roleNames = roleNames;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
		if(roles!=null && roles.size()>0){
			this.roleIds = new String[roles.size()];
			this.roleNames = new String[roles.size()];
			for(int i=0;i<roles.size();i++){
				SysRole sysRole = roles.get(i);
				this.roleIds[i] = Integer.toString(sysRole.getRoleId());
				this.roleNames[i] = sysRole.getRoleName();
			}
		}
	}

	public List<SysRight> getRights() {
		return rights;
	}

	public void setRights(List<SysRight> rights) {
		this.rights = rights;
		if(rights!=null && rights.size()>0){
			this.roleRightCodes = new String[rights.size()];
			this.roleRightNames = new String[rights.size()];
			for(int i=0;i<rights.size();i++){
				SysRight sysRight = rights.get(i);
				this.roleRightCodes[i] = Integer.toString(sysRight.getRightId());
				this.roleRightNames[i] = sysRight.getRightName();
			}
		}
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = StringUtils.trimAllWhitespace(loginName);
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = StringUtils.trimAllWhitespace(loginPwd);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = StringUtils.trimAllWhitespace(userName);
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = StringUtils.trimAllWhitespace(email);
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = StringUtils.trimAllWhitespace(mobile);
    }

    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
}