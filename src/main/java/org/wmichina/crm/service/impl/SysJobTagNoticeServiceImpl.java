package org.wmichina.crm.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.wmichina.crm.entity.SysDailyJob;
import org.wmichina.crm.entity.SysNotice;
import org.wmichina.crm.entity.SysNoticeRoles;
import org.wmichina.crm.entity.SysRole;
import org.wmichina.crm.entity.SysTag;
import org.wmichina.crm.entity.example.SysDailyJobExample;
import org.wmichina.crm.entity.example.SysNoticeExample;
import org.wmichina.crm.entity.example.SysNoticeRolesExample;
import org.wmichina.crm.entity.example.SysTagExample;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.mapper.SysDailyJobMapper;
import org.wmichina.crm.mapper.SysNoticeMapper;
import org.wmichina.crm.mapper.SysNoticeRolesMapper;
import org.wmichina.crm.mapper.SysTagMapper;
import org.wmichina.crm.service.SysJobTagNoticeService;

@Repository(value="sysJobTagNoticeService")
@Transactional
public class SysJobTagNoticeServiceImpl implements SysJobTagNoticeService {

	@Resource(name="sysTagMapper")
	private SysTagMapper sysTagMapper;
	@Resource(name="sysDailyJobMapper")
	private SysDailyJobMapper sysDailyJobMapper;
	@Resource(name="sysNoticeMapper")
	private SysNoticeMapper sysNoticeMapper;
	@Resource(name="sysNoticeRolesMapper")
	private SysNoticeRolesMapper sysNoticeRolesMapper;
	
	/**
	 * SysDailyJob
	 */
	@Override
	public List<SysDailyJob> findJobs() {
		return this.sysDailyJobMapper.selectByExample(null);
	}

	@Override
	public List<SysDailyJob> findJobsByDepartment(String departCode) {
		SysDailyJobExample example = new SysDailyJobExample();
		SysDailyJobExample.Criteria query = example.createCriteria();
		query.andJobDepartmentEqualTo(departCode);

		return this.sysDailyJobMapper.selectByExample(example);
	}
	
	@Override
	public boolean checkJobCode(String jobCode) {
		SysDailyJobExample example = new SysDailyJobExample();
		SysDailyJobExample.Criteria query = example.createCriteria();
		query.andJobCodeEqualTo(jobCode);
		
		List<SysDailyJob> result = this.sysDailyJobMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}
	
	@Override
	public boolean checkJobName(String jobName) {
		SysDailyJobExample example = new SysDailyJobExample();
		SysDailyJobExample.Criteria query = example.createCriteria();
		query.andJobNameEqualTo(jobName);
		
		List<SysDailyJob> result = this.sysDailyJobMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}
	
	@Override
	public SysDailyJob selectJobByCode(String jobCode) {
		SysDailyJobExample example = new SysDailyJobExample();
		SysDailyJobExample.Criteria query = example.createCriteria();
		query.andJobCodeEqualTo(jobCode);
		List<SysDailyJob> result = this.sysDailyJobMapper.selectByExample(example);
		
		if(result!=null && result.size()>0){
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public SysDailyJob selectJobByName(String jobName) {
		SysDailyJobExample example = new SysDailyJobExample();
		SysDailyJobExample.Criteria query = example.createCriteria();
		query.andJobNameEqualTo(jobName);
		List<SysDailyJob> result = this.sysDailyJobMapper.selectByExample(example);
		
		if(result!=null && result.size()>0){
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public SysDailyJob selectJobById(Integer jobId) {
		if(jobId == null ) return null;
		return this.sysDailyJobMapper.selectByPrimaryKey(jobId);
	}

	@Override
	public void insertJob(SysDailyJob job) {
		this.sysDailyJobMapper.insertSelective(job);
	}

	@Override
	public void updateJob(SysDailyJob job) {
		this.sysDailyJobMapper.updateByPrimaryKeySelective(job);
	}

	@Override
	public ResultPageBuilder<SysDailyJob> findJobsByPage(SysDailyJob job, int currentPage) {
		SysDailyJobExample example = new SysDailyJobExample();
		int allRows = this.sysDailyJobMapper.countByExample(example);
		//
		ResultPageBuilder<SysDailyJob> pageBuilder = new ResultPageBuilder<SysDailyJob>(allRows, EntityConstants.PAGE_SIZE, currentPage);
		//
		example.setStart(pageBuilder.getStart());
		example.setStart(pageBuilder.getEnd());
		List<SysDailyJob> jobs = this.sysDailyJobMapper.selectByExample(example);
		//
		pageBuilder.setResultSet(jobs);
		
		return pageBuilder;
	}

	/**
	 * SysTag
	 */
	@Override
	public List<SysTag> findTags() {
		return this.sysTagMapper.selectByExample(null);
	}

	@Override
	public List<SysTag> findTagsByDepartment(String departCode) {
		SysTagExample example = new SysTagExample();
		SysTagExample.Criteria query = example.createCriteria();
		query.andTagDepartmentEqualTo(departCode);

		return this.sysTagMapper.selectByExample(example);
	}
	
	@Override
	public boolean checkTagName(String tagName) {
		SysTagExample example = new SysTagExample();
		SysTagExample.Criteria query = example.createCriteria();
		query.andTagNameEqualTo(tagName);
		
		List<SysTag> result = this.sysTagMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public SysTag selectTagById(Integer tagId) {
		if(tagId == null) return null;
		return this.sysTagMapper.selectByPrimaryKey(tagId);
	}

	@Override
	public SysTag selectTagByName(String tagName) {
		SysTagExample example = new SysTagExample();
		SysTagExample.Criteria query = example.createCriteria();
		query.andTagNameEqualTo(tagName);
		List<SysTag> result = this.sysTagMapper.selectByExample(example);
		
		if(result!=null && result.size()>0){
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public void insertTag(SysTag tag) {
		this.sysTagMapper.insertSelective(tag);
	}

	@Override
	public void updateTag(SysTag tag) {
		this.sysTagMapper.updateByPrimaryKeySelective(tag);
	}

	@Override
	public ResultPageBuilder<SysTag> findTagsByPage(SysTag tag, int currentPage) {
		SysTagExample example = new SysTagExample();
		int allRows = this.sysTagMapper.countByExample(example);
		//
		ResultPageBuilder<SysTag> pageBuilder = new ResultPageBuilder<SysTag>(allRows, EntityConstants.PAGE_SIZE, currentPage);
		//
		example.setStart(pageBuilder.getStart());
		example.setStart(pageBuilder.getEnd());
		List<SysTag> tags = this.sysTagMapper.selectByExample(example);
		//
		pageBuilder.setResultSet(tags);
		
		return pageBuilder;
	}

	/**
	 * SysNotice
	 */
	@Override
	public List<SysNotice> findNotices() {
		List<SysNotice> notices = this.sysNoticeMapper.selectByExample(null);
		if(notices!=null && notices.size()>0){
			for(SysNotice notice : notices){
				List<SysRole> roles = this.sysNoticeMapper.findRolesByNoticeId(notice.getNoticeId());
				notice.setRoles(roles);
			}
		}
		return notices;
	}

	@Override
	public List<SysNotice> findNoticesByRoleIds(Integer[] roleIds) {
		if(roleIds !=null && roleIds.length >1){
			throw new RuntimeException(" roleIds is null.");
		}
		String sRoleIds = Arrays.toString(roleIds).replace('[', '(').replace(']', ')');
		List<SysNotice> notices = this.sysNoticeMapper.findNoticesByRoleIds(sRoleIds);
		if(notices!=null && notices.size()>0){
			for(SysNotice notice : notices){
				List<SysRole> roles = this.sysNoticeMapper.findRolesByNoticeId(notice.getNoticeId());
				notice.setRoles(roles);
			}
		}
		return notices;
	}
	
	@Override
	public boolean checkNoticeName(String noticeName) {
		SysNoticeExample example = new SysNoticeExample();
		SysNoticeExample.Criteria query = example.createCriteria();
		query.andNoticeNameEqualTo(noticeName);
		
		List<SysNotice> result = this.sysNoticeMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public SysNotice selectNoticeById(Integer noticeId) {
		if(noticeId == null) {
			throw new RuntimeException(" noticeId is null.");
		}
		SysNotice notice = this.sysNoticeMapper.selectByPrimaryKey(noticeId);
		if(notice!=null ){
			List<SysRole> roles = this.sysNoticeMapper.findRolesByNoticeId(notice.getNoticeId());
			notice.setRoles(roles);
		}
		return notice;
	}

	@Override
	public void insertNotice(SysNotice notice) {
		this.sysNoticeMapper.insertSelective(notice);
		if(notice.getRoleIds()!=null && notice.getRoleIds().length>0){
			for(String roleId : notice.getRoleIds()){
				SysNoticeRoles noticeRole = new SysNoticeRoles();
				noticeRole.setNoticeId(notice.getNoticeId());
				noticeRole.setRoleId(Integer.parseInt(roleId));
				
				this.sysNoticeRolesMapper.insertSelective(noticeRole);
			}
		}
	}

	@Override
	public void updateNotice(SysNotice notice) {
		this.sysNoticeMapper.updateByPrimaryKeySelective(notice);
		if(notice.getRoleIds()!=null && notice.getRoleIds().length>0){
			// #1. delete all roles first.
			SysNoticeRolesExample example = new SysNoticeRolesExample();
			SysNoticeRolesExample.Criteria condition = example.createCriteria();
			condition.andNoticeIdEqualTo(notice.getNoticeId());
			this.sysNoticeRolesMapper.deleteByExample(example);
			
			// #2. add roles.
			for(String roleId : notice.getRoleIds()){
				SysNoticeRoles noticeRole = new SysNoticeRoles();
				noticeRole.setNoticeId(notice.getNoticeId());
				noticeRole.setRoleId(Integer.parseInt(roleId));
				
				this.sysNoticeRolesMapper.insertSelective(noticeRole);
			}
		}
	}

	@Override
	public ResultPageBuilder<SysNotice> findNoticesByPage(SysNotice notice, int currentPage) {
		SysNoticeExample example = new SysNoticeExample();
		int allRows = this.sysNoticeMapper.countByExample(example);
		//
		ResultPageBuilder<SysNotice> pageBuilder = new ResultPageBuilder<SysNotice>(allRows, EntityConstants.PAGE_SIZE, currentPage);
		//
		example.setStart(pageBuilder.getStart());
		example.setStart(pageBuilder.getEnd());
		List<SysNotice> noitices = this.sysNoticeMapper.selectByExample(example);
		//
		for(SysNotice entry : noitices){
			List<SysRole> roles = this.sysNoticeMapper.findRolesByNoticeId(entry.getNoticeId());
			entry.setRoles(roles);
		}
		pageBuilder.setResultSet(noitices);
		
		return pageBuilder;
	}

}
