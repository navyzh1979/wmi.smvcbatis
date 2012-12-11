package org.wmichina.crm.entity;

import java.util.Date;

public class SysNoticeRoles {
    private Integer noticeRoleId;

    private Integer noticeId;

    private Integer roleId;

    private Date createDate;

    private String createNotice;

    public Integer getNoticeRoleId() {
        return noticeRoleId;
    }

    public void setNoticeRoleId(Integer noticeRoleId) {
        this.noticeRoleId = noticeRoleId;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateNotice() {
        return createNotice;
    }

    public void setCreateNotice(String createNotice) {
        this.createNotice = createNotice;
    }
}