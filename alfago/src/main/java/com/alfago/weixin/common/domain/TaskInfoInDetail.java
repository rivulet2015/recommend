package com.alfago.weixin.common.domain;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alfago.weixin.common.beans.Entity;
import com.alfago.weixin.common.beans.UserTaskEntity;

public class TaskInfoInDetail extends BaseMongoObject{

	protected String taskId;
	
	protected String groupId;
	
	protected String recommendationId;
	
	protected Float progress;
	
	protected String state;
	
	protected List<UserTaskEntity> receiversQQ;
	
	protected Date createdTime;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getRecommendationId() {
		return recommendationId;
	}

	public void setRecommendationId(String recommendationId) {
		this.recommendationId = recommendationId;
	}

	public Float getProgress() {
		return progress;
	}

	public void setProgress(Float progress) {
		this.progress = progress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<UserTaskEntity> getReceiversQQ() {
		return receiversQQ;
	}

	public void setReceiversQQ(List<UserTaskEntity> receiversQQ) {
		this.receiversQQ = receiversQQ;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
