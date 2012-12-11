package org.wmichina.crm.service;

import java.util.List;

import org.wmichina.crm.entity.SysDailyJob;
import org.wmichina.crm.entity.SysNotice;
import org.wmichina.crm.entity.SysTag;
import org.wmichina.crm.helper.ResultPageBuilder;

public interface SysJobTagNoticeService {
	/** SysDailyJob **/
	List<SysDailyJob> findJobs();
	List<SysDailyJob> findJobsByDepartment(String departCode);
	boolean checkJobCode(String jobCode);
	boolean checkJobName(String jobName);
	SysDailyJob selectJobByCode(String jobCode);
	SysDailyJob selectJobByName(String jobName);
	SysDailyJob selectJobById(Integer jobId);
	void insertJob(SysDailyJob job);
	void updateJob(SysDailyJob job);
	ResultPageBuilder<SysDailyJob> findJobsByPage(SysDailyJob job, int currentPage);

	/** SysTag **/
	List<SysTag> findTags();
	List<SysTag> findTagsByDepartment(String departCode);
	SysTag selectTagById(Integer tagId);
	SysTag selectTagByName(String tagName);
	boolean checkTagName(String tagName);
	void insertTag(SysTag tag);
	void updateTag(SysTag tag);
	ResultPageBuilder<SysTag> findTagsByPage(SysTag tag, int currentPage);
	
	/** SysNotice **/
	List<SysNotice> findNotices();
	List<SysNotice> findNoticesByRoleIds(Integer[] roleIds);
	SysNotice selectNoticeById(Integer noticeId);
	boolean checkNoticeName(String NoticeName);
	void insertNotice(SysNotice notice);
	void updateNotice(SysNotice notice);
	ResultPageBuilder<SysNotice> findNoticesByPage(SysNotice notice, int currentPage);

}
