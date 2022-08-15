package com.example.mariox.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.mariox.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.example.mariox.rest.webservices.restfulwebservices.model.Posts;
import com.example.mariox.rest.webservices.restfulwebservices.model.User;
import com.example.mariox.rest.webservices.restfulwebservices.repository.PostsDaoService;
import com.example.mariox.rest.webservices.restfulwebservices.repository.UserDaoService;

@RestController
public class PostsController {
	@Autowired
	private UserDaoService userService;
	
	@Autowired PostsDaoService postService; 
	
	@GetMapping("/users/{id}/posts")
	public List<Posts> getPostsByUserId(@PathVariable Integer id){
		Optional<User> user=userService.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id= "+id+" does not exist");
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> savePost(@PathVariable Integer id, @RequestBody Posts post){
		Optional<User> user=userService.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id= "+id+" does not exist");
		}
		User myUser=user.get();
		post.setUser(myUser);
		postService.save(post);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getPostId()).toUri();
		return ResponseEntity.created(location).build();
		}
	
	@DeleteMapping("/posts/{postId}")
	public void deletePosts(@PathVariable Integer postId){
		Optional<Posts> post=postService.findById(postId);
		if(post.isEmpty()) {
			throw new UserNotFoundException("id= "+postId+" does not exist");
		}
		Posts myPost=post.get();
		postService.delete(myPost);
		}
	
	@GetMapping("/posts")
	public List<Posts> getPosts(){
		List<Posts> post=postService.findAll();
		return post;
		}

}
