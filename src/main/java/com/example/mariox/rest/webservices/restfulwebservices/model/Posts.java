package com.example.mariox.rest.webservices.restfulwebservices.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Posts {
	
	@Id @GeneratedValue
	private Integer postId;
	private String postBody;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	
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
	protected Posts() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
