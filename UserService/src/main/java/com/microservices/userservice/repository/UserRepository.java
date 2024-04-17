package com.microservices.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
