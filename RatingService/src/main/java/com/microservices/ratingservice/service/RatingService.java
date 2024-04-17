package com.microservices.ratingservice.service;

import java.util.List;

import com.microservices.ratingservice.entity.Rating;

public interface RatingService {

	Rating createRating(Rating rating);

	List<Rating> getRatings();

	List<Rating> getRatingByUserId(String userId);

	List<Rating> getRatingByHotelId(String hotelId);
}
