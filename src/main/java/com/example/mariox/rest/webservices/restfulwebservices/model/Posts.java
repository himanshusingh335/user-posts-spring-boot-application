package com.example.mariox.rest.webservices.restfulwebservices.model;

public class Posts {
	
	private Integer postId;
	private String postBody;
	private String userId;
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPostBody() {
		return postBody;
	}
	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private Posts() {
		super();
	}
	

}
