package com.microservices.ratingservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.ratingservice.entity.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {
	
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
}
