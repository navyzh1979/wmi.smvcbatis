package org.wmichina.crm.entity;

import java.util.Date;

public class StudentTags {
    private Long studentId;

    private String sourceBatchno;

    private Integer tagId;

    private String tagName;

    private String tagDepart;

    private Integer isDefined;

    private Date createDate;

    private String createUser;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getSourceBatchno() {
        return sourceBatchno;
    }

    public void setSourceBatchno(String sourceBatchno) {
        this.sourceBatchno = sourceBatchno;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagDepart() {
        return tagDepart;
    }

    public void setTagDepart(String tagDepart) {
        this.tagDepart = tagDepart;
    }

    public Integer getIsDefined() {
        return isDefined;
    }

    public void setIsDefined(Integer isDefined) {
        this.isDefined = isDefined;
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
}