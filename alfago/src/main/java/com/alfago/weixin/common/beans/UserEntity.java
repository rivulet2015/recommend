package com.alfago.weixin.common.beans;

import java.util.Date;

// Generated 2014-7-4 14:24:02 by Hibernate Tools 3.4.0.CR1

/**
 * UserBasicInfo generated by hbm2java
 */
public class UserEntity extends Entity {
	
	protected Integer id;
	
	protected Integer groupId;
	
	protected String qq;
	
	protected Integer state;
	
	protected Date createdTime;
	

	public UserEntity() {
	}

	public UserEntity(Long userId, String qq) {
		
		
		this.qq = qq;
		
		this.state = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	
}