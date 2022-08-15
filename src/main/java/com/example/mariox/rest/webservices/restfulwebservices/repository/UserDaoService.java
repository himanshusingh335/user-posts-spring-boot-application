package com.example.mariox.rest.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mariox.rest.webservices.restfulwebservices.model.User;


@Repository
public interface UserDaoService extends JpaRepository<User, Integer> {

	}
