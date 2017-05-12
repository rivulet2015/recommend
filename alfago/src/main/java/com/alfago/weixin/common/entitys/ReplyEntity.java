package com.alfago.weixin.common.entitys;

import java.util.Date;


public class ReplyEntity extends Entity{
	
	private Integer id;

	private String contentId;
	
	private Date systime;
	
	private Integer blogId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public Date getSystime() {
		return systime;
	}

	public void setSystime(Date systime) {
		this.systime = systime;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	
	
}
