package com.alfago.weixin.common.domain;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
