package com.microservices.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.ratingservice.entity.Rating;
import com.microservices.ratingservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingService ratingService;

	@PostMapping("/createRating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating savedRating = ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
	}
	
	@GetMapping("/getRatings")
	public ResponseEntity<List<Rating>> getRatings() {
		List<Rating> ratings = ratingService.getRatings();
		return ResponseEntity.status(HttpStatus.CREATED).body(ratings);
	}
	
	@GetMapping("/userId/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
		List<Rating> ratings = ratingService.getRatingByUserId(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(ratings);
	}
	
	@GetMapping("/hotelId/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
		List<Rating> ratings = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.status(HttpStatus.CREATED).body(ratings);
	}
	
	
}
