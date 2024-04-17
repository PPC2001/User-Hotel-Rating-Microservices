package com.microservices.userservice.service;

import java.util.List;

import com.microservices.userservice.entity.User;

public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
}
