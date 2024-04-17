package com.microservices.userservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		logger.info("Creating user: " + user.toString());
		User savedUser = userService.saveUser(user);
		logger.info("User created: " + savedUser.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		logger.info("Fetching user with ID: " + userId);
		User user = userService.getUser(userId);
		logger.info("Fetched user: " + user.toString());
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser() {
		logger.info("Fetching all users");
		List<User> userList = userService.getAllUser();
		logger.info("Fetched " + userList.size() + " users");
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}
}
