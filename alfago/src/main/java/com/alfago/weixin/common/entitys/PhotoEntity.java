package com.alfago.weixin.common.entitys;

import java.util.Date;


public class PhotoEntity extends Entity{
	
	private Integer id;
	
	private String name;
	
	private String url;
	
	private Date systime;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getSystime() {
		return systime;
	}

	public void setSystime(Date systime) {
		this.systime = systime;
	}
	

	
}
