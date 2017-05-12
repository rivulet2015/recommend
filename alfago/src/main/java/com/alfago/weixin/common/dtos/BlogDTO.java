package com.alfago.weixin.common.dtos;

import java.util.Date;

import com.alfago.weixin.common.entitys.TopicEntity;

public class BlogDTO extends BaseDTO{
	
	private Integer id;
	private String name;
	private String content;
	private String contentPart; // 内容前100字
	private Date systime;
	private TopicEntity topic;
	private int replyCount;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentPart() {
		return contentPart;
	}
	public void setContentPart(String contentPart) {
		this.contentPart = contentPart;
	}
	public Date getSystime() {
		return systime;
	}
	public void setSystime(Date systime) {
		this.systime = systime;
	}
	public TopicEntity getTopic() {
		return topic;
	}
	public void setTopic(TopicEntity topic) {
		this.topic = topic;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	
}
