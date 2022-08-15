package com.example.mariox.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.mariox.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.example.mariox.rest.webservices.restfulwebservices.model.User;
import com.example.mariox.rest.webservices.restfulwebservices.repository.UserDaoService;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}") @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	public Optional<User> retrieveOneUser(@PathVariable Integer id ){
		Optional<User> user=service.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id= "+id+" does not exist");
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
		User savedUser= service.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		Optional<User> user =service.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id= "+id+" does not exist");
		}
		service.deleteById(id);
		}
}
