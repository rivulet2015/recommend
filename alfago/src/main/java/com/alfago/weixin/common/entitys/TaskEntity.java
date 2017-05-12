package com.alfago.weixin.common.entitys;

import java.util.Date;
import java.util.List;

public class TaskEntity extends Entity{

	protected Integer id;
	
	protected Integer recommendRecordId;
	
	protected String creater;
	
	protected Date createdTime;
	
	protected String handler;
	
	protected Date handledTime;
	
	protected Date completedTime;
	
	protected Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getHandledTime() {
		return handledTime;
	}

	public void setHandleTime(Date handledTime) {
		this.handledTime = handledTime;
	}

	public Date getCompletedTime() {
		return completedTime;
	}

	public void setCompletedTime(Date completedTime) {
		this.completedTime = completedTime;
	}

	
	public Integer getRecommendRecordId() {
		return recommendRecordId;
	}

	public void setRecommendRecordId(Integer recommendRecordId) {
		this.recommendRecordId = recommendRecordId;
	}

	public void setHandledTime(Date handledTime) {
		this.handledTime = handledTime;
	}

	
}
