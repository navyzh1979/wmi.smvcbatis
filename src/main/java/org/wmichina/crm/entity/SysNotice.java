package org.wmichina.crm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

public class SysNotice {
	private String action="new";
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
    private Integer noticeId;

    @Size(min=4,max=20,message="公告标题应在4位到20位之间.")
    private String noticeName;

    private Integer isValid;

    private Date startDate;

    private Date endDate;

    private Date createDate;

    private String createUser;

    private Date updateDate;

    private String updateUser;

    @Size(min=1,message="公告内容不能为空.")
    private byte[] description;

	@Size(min=1,message="没有选择任何角色！")
	private String[] roleIds;
	
	private List<SysRole> roles = new ArrayList<SysRole>();
	
    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
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

    public byte[] getDescription() {
        return description;
    }

    public void setDescription(byte[] description) {
        this.description = description;
    }

	public String[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
		if(roles!=null && roles.size()>0){
			this.roleIds = new String[roles.size()];
			for(int i=0;i<roles.size();i++){
				SysRole sysRole = roles.get(i);
				this.roleIds[i] = Integer.toString(sysRole.getRoleId());
			}
		}
	}
}