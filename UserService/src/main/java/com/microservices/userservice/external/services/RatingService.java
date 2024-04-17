package com.microservices.userservice.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.microservices.userservice.entity.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@PostMapping("/ratings/createRating")
	Rating createRating(Rating rating);

	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@PathVariable String ratingId, Rating rating);

	@DeleteMapping("/ratings/{ratingId}")
	void deleteRating(@PathVariable String ratingId);
}
