package org.wmichina.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.wmichina.crm.entity.BizActivity;
import org.wmichina.crm.entity.BizChannel;
import org.wmichina.crm.entity.example.BizActivityExample;
import org.wmichina.crm.entity.example.BizChannelExample;
import org.wmichina.crm.helper.EntityConstants;
import org.wmichina.crm.helper.ResultPageBuilder;
import org.wmichina.crm.mapper.BizActivityMapper;
import org.wmichina.crm.mapper.BizChannelMapper;
import org.wmichina.crm.service.BizActChannelService;

@Repository(value="bizActChannelService")
@Transactional
public class BizActChannelServiceImpl implements BizActChannelService {
	@Resource(name="bizActivityMapper")
	private BizActivityMapper bizActivityMapper;
	@Resource(name="bizChannelMapper")
	private BizChannelMapper bizChannelMapper;
	
	/**
	 * BizActivity
	 */
	
	@Override
	public List<BizActivity> findActivities() {
		BizActivityExample example = new BizActivityExample();
		return this.bizActivityMapper.selectByExample(example);
	}

	@Override
	public boolean checkActivityCode(String activityCode) {
		BizActivityExample example = new BizActivityExample();
		BizActivityExample.Criteria query = example.createCriteria();
		query.andActivityCodeEqualTo(activityCode);
		
		List<BizActivity> result = this.bizActivityMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public boolean checkActivityName(String activityName) {
		BizActivityExample example = new BizActivityExample();
		BizActivityExample.Criteria query = example.createCriteria();
		query.andActivityNameEqualTo(activityName);
		
		List<BizActivity> result = this.bizActivityMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public BizActivity selectActivityByCode(String activityCode) {
		BizActivityExample example = new BizActivityExample();
		BizActivityExample.Criteria query = example.createCriteria();
		query.andActivityCodeEqualTo(activityCode);
		
		List<BizActivity> result = this.bizActivityMapper.selectByExample(example);

		if(result!=null && result.size()>0){
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public BizActivity selectActivityByName(String activityName) {
		BizActivityExample example = new BizActivityExample();
		BizActivityExample.Criteria query = example.createCriteria();
		query.andActivityNameEqualTo(activityName);
		
		List<BizActivity> result = this.bizActivityMapper.selectByExample(example);

		if(result!=null && result.size()>0){
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public BizActivity selectActivityById(Integer activityId) {
		if(activityId == null ) return null;
		return this.bizActivityMapper.selectByPrimaryKey(activityId);
	}

	@Override
	public void insertActivity(BizActivity activity) {
		this.bizActivityMapper.insertSelective(activity);
	}

	@Override
	public void updateActivity(BizActivity activity) {
		this.bizActivityMapper.updateByPrimaryKeySelective(activity);
	}

	@Override
	public ResultPageBuilder<BizActivity> findActivitiesByPage(BizActivity activity, int currentPage) {
		BizActivityExample example = new BizActivityExample();
		int allRows = this.bizActivityMapper.countByExample(example);
		//
		ResultPageBuilder<BizActivity> pageBuilder = new ResultPageBuilder<BizActivity>(allRows, EntityConstants.PAGE_SIZE, currentPage);
		//
		example.setStart(pageBuilder.getStart());
		example.setStart(pageBuilder.getEnd());
		List<BizActivity> jobs = this.bizActivityMapper.selectByExample(example);
		//
		pageBuilder.setResultSet(jobs);
		
		return pageBuilder;
	}

	/**
	 * BizChannel
	 */
	
	@Override
	public List<BizChannel> findChannels() {
		BizChannelExample example = new BizChannelExample();
		return this.bizChannelMapper.selectByExample(example);
	}

	@Override
	public boolean checkChannelCode(String channelCode) {
		BizChannelExample example = new BizChannelExample();
		BizChannelExample.Criteria query = example.createCriteria();
		query.andChannelCodeEqualTo(channelCode);
		
		List<BizChannel> result = this.bizChannelMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public boolean checkChannelName(String channelName) {
		BizChannelExample example = new BizChannelExample();
		BizChannelExample.Criteria query = example.createCriteria();
		query.andChannelNameEqualTo(channelName);
		
		List<BizChannel> result = this.bizChannelMapper.selectByExample(example);
		return result!=null&&result.size()>0?true:false;
	}

	@Override
	public BizChannel selectChannelByCode(String channelCode) {
		BizChannelExample example = new BizChannelExample();
		BizChannelExample.Criteria query = example.createCriteria();
		query.andChannelCodeEqualTo(channelCode);
		
		List<BizChannel> result = this.bizChannelMapper.selectByExample(example);

		if(result!=null && result.size()>0){
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public BizChannel selectChannelByName(String channelName) {
		BizChannelExample example = new BizChannelExample();
		BizChannelExample.Criteria query = example.createCriteria();
		query.andChannelNameEqualTo(channelName);
		
		List<BizChannel> result = this.bizChannelMapper.selectByExample(example);

		if(result!=null && result.size()>0){
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public BizChannel selectChannelById(Integer channelId) {
		if(channelId == null ) return null;
		return this.bizChannelMapper.selectByPrimaryKey(channelId);
	}

	@Override
	public void insertChannel(BizChannel channel) {
		this.bizChannelMapper.insertSelective(channel);
	}

	@Override
	public void updateChannel(BizChannel channel) {
		this.bizChannelMapper.updateByPrimaryKeySelective(channel);
	}

	@Override
	public ResultPageBuilder<BizChannel> findChannelsByPage(BizChannel channel, int currentPage) {
		BizChannelExample example = new BizChannelExample();
		int allRows = this.bizChannelMapper.countByExample(example);
		//
		ResultPageBuilder<BizChannel> pageBuilder = new ResultPageBuilder<BizChannel>(allRows, EntityConstants.PAGE_SIZE, currentPage);
		//
		example.setStart(pageBuilder.getStart());
		example.setStart(pageBuilder.getEnd());
		List<BizChannel> jobs = this.bizChannelMapper.selectByExample(example);
		//
		pageBuilder.setResultSet(jobs);
		
		return pageBuilder;
	}

}
