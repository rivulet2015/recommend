package com.alfago.weixin.common.domain;

public class GbookDomain  extends BaseMongoObject{

	protected Integer gBookId;
	
	protected String content;
	

	public Integer getgBookId() {
		return gBookId;
	}

	public void setgBookId(Integer gBookId) {
		this.gBookId = gBookId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
