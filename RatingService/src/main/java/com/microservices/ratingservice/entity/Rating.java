package com.microservices.ratingservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_ratings") // the @Document annotation is used to indicate that a Java class represents a
							// document in a MongoDB collection
public class Rating {
	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;

	private String feedback;
}
