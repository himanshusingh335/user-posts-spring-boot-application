package com.example.mariox.rest.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mariox.rest.webservices.restfulwebservices.model.User;


public interface UserDaoService extends JpaRepository<User, Integer> {

	}
