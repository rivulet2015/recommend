package com.alfago.weixin.common.vo;


import java.util.Date;
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  

import com.alfago.weixin.common.entitys.PageEntity;
import com.alfago.weixin.common.utils.DateUtil;
  
public class PageVo extends BaseVo{  
  
	private Integer id;
	
	private String name;
	
	private String systime;

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

	public String getSystime() {
		return systime;
	}

	public void setSystime(String systime) {
		this.systime = systime;
	}

	public PageVo(){
		
	}
	
	public PageVo(PageEntity e){
		this.setId(e.getId());
		this.setName(e.getName());
		this.setSystime(DateUtil.toString(e.getSystime()));
	}
}  
