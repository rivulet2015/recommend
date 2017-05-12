package com.alfago.weixin.common.domain;

public class ReplyDomain  extends BaseMongoObject{

	protected Integer replyId;
	
	protected String content;

	
	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
		
}
