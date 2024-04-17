package com.microservices.hotelservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_HOTEL_DET")
@ToString
public class Hotel {
	
	@Id
	private String id;
	private String name;
	private String location;
	private String about;
	
}
