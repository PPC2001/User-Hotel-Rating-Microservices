package com.microservices.userservice.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_USER_DET")
@Builder
public class User {
	
	@Id
	private String userId;
	private String email;
	private String name;
	private String about;
	
	@Transient //This annotation used when you don't want to store certain field in Database
	private List<Rating> ratings = new ArrayList<>();
	
}
