package com.alfago.weixin.common.vo;

import java.util.Date;

import com.alfago.weixin.common.entitys.ModuleEntity;
import com.alfago.weixin.common.utils.DateUtil;

public class ModuleVo extends BaseVo{

	private Integer id;
	
	private Integer pageId;
	
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

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public String getSystime() {
		return systime;
	}

	public void setSystime(String systime) {
		this.systime = systime;
	}
	
	public ModuleVo(){
		
	}
	
	public ModuleVo(ModuleEntity e){
		this.setId(e.getId());
		this.setName(e.getName());
		this.setPageId(e.getPageId());
		this.setSystime(DateUtil.toString(e.getSystime()));		
	}	

}
