package com.example.mariox.rest.webservices.restfulwebservices.model;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	protected User() {
		super();
	}

	@Id @GeneratedValue
	private Integer id;
	@Size(min=2, message="Min number of characters should be 2")
	private String name;
	@Past
	private Date birthDate;
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Posts> posts;
	
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
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}


}
