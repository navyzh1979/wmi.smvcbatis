package org.wmichina.crm.service;

import java.util.List;

import org.wmichina.crm.entity.BizActivity;
import org.wmichina.crm.entity.BizChannel;
import org.wmichina.crm.helper.ResultPageBuilder;

public interface BizActChannelService {
    /** BizActivity **/
	List<BizActivity> findActivities();
	boolean checkActivityCode(String activityCode);
	boolean checkActivityName(String activityName);
	BizActivity selectActivityByCode(String activityCode);
	BizActivity selectActivityByName(String activityName);
	BizActivity selectActivityById(Integer activityId);
	void insertActivity(BizActivity activity);
	void updateActivity(BizActivity activity);
	ResultPageBuilder<BizActivity> findActivitiesByPage(BizActivity activity, int currentPage);

    /** BizChannel **/
	List<BizChannel> findChannels();
	boolean checkChannelCode(String channelCode);
	boolean checkChannelName(String channelName);
	BizChannel selectChannelByCode(String channelCode);
	BizChannel selectChannelByName(String channelName);
	BizChannel selectChannelById(Integer channelId);
	void insertChannel(BizChannel channel);
	void updateChannel(BizChannel channel);
	ResultPageBuilder<BizChannel> findChannelsByPage(BizChannel channel, int currentPage);

}
