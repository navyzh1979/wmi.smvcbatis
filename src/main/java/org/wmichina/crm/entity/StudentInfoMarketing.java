package org.wmichina.crm.entity;

import java.util.Date;

public class StudentInfoMarketing {
    private Long studentId;

    private String sourceBatchno;

    private Integer intendType;

    private String intendCourse;

    private String examDate;

    private Integer contactTried;

    private Integer contactAnswered;

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

    public Integer getIntendType() {
        return intendType;
    }

    public void setIntendType(Integer intendType) {
        this.intendType = intendType;
    }

    public String getIntendCourse() {
        return intendCourse;
    }

    public void setIntendCourse(String intendCourse) {
        this.intendCourse = intendCourse;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public Integer getContactTried() {
        return contactTried;
    }

    public void setContactTried(Integer contactTried) {
        this.contactTried = contactTried;
    }

    public Integer getContactAnswered() {
        return contactAnswered;
    }

    public void setContactAnswered(Integer contactAnswered) {
        this.contactAnswered = contactAnswered;
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