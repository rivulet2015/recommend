package com.alfago.weixin.common.vo;

import java.util.Date;

import com.alfago.weixin.common.entitys.PageElementEntity;
import com.alfago.weixin.common.utils.DateUtil;

public class ElementVo  extends BaseVo{

	private Integer id;
	
	private Integer pageId;
	
	private Integer moduleId;
	
	private String keyname;
	
	private String value;
	
	private String systime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSystime() {
		return systime;
	}

	public void setSystime(String systime) {
		this.systime = systime;
	}

	public ElementVo(){
		
	}
	
	public ElementVo(PageElementEntity e){
		this.setId(e.getId());
		this.setKeyname(e.getKeyname());
		this.setValue(e.getValue());
		this.setPageId(e.getPageId());
		this.setSystime(DateUtil.toString(e.getSystime()));				
	}	
}
