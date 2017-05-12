package com.alfago.weixin.common.domain;

import java.util.Date;

import org.bson.types.ObjectId;

import com.alfago.weixin.common.beans.Entity;

public class BaseMongoObject extends Entity {

/*	protected ObjectId _id;
	
	protected String id;
	
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getId() {
		
		if(this.id == null){
			this.id = this._id.toString();
		}
		return id;
	}

	public void setId(String id) {
		set_id(new ObjectId(id));
		this.id = id;
	}*/
	
	protected String id;

	protected Date createdTime;
	
	protected Date lastModifiedTime;
	
	
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
