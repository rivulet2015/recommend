package com.alfago.weixin.common.entitys;

import java.util.Date;

public class GbookEntity extends Entity{

	private Integer id;
	
	private String content;
	
	private String contentId;
	
	private Date systime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	
	
}
