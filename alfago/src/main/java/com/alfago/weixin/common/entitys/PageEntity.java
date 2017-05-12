package com.alfago.weixin.common.entitys;

import java.util.Date;

public class PageEntity extends Entity{

	private Integer id;
	
	private String name;
	
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

	public Date getSystime() {
		return systime;
	}

	public void setSystime(Date systime) {
		this.systime = systime;
	}
	
	public String toString(){
		return name;
		
	}
}
