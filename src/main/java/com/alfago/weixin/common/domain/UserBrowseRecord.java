package com.alfago.weixin.common.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alfago.weixin.common.beans.Entity;

public class UserBrowseRecord extends BaseMongoObject{

	private String userId;
	
	private String recommendationId;
	
	private Integer browseTimes;
	
	private Date lastBrowseTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRecommendationId() {
		return recommendationId;
	}

	public void setRecommendationId(String recommendationId) {
		this.recommendationId = recommendationId;
	}

	public Integer getBrowseTimes() {
		return browseTimes;
	}

	public void setBrowseTimes(Integer browseTimes) {
		this.browseTimes = browseTimes;
	}

	public Date getLastBrowseTime() {
		return lastBrowseTime;
	}

	public void setLastBrowseTime(Date lastBrowseTime) {
		this.lastBrowseTime = lastBrowseTime;
	}

}
