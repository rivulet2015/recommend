package com.alfago.weixin.common.domain;

public class BlogDomain  extends BaseMongoObject{

	protected Integer blogId;
	
	protected String content;

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
