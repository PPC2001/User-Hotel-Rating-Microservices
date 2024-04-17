package com.microservices.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.userservice.controller.UserController;
import com.microservices.userservice.entity.Hotel;
import com.microservices.userservice.entity.Rating;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.exception.ResourceNotFoundException;
import com.microservices.userservice.external.services.HotelService;
import com.microservices.userservice.repository.UserRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HotelService hotelService;

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	public User getUser(String userId) {

		// Get user from DB with help of userRepository
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found " + userId));
		
		// Get rating of the above user from RATING-SERVICE
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/userId/" + userId,
				Rating[].class);

		List<Rating> ratingList = new ArrayList<>();
		for (Rating rating : ratingsOfUser) {
			// Rest API call to HOTEL-SERVICE using RestTemplate

			// ResponseEntity<Hotel> forEntity = restTemplate
			// .getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),
			// Hotel.class);
			// Hotel hotel = forEntity.getBody();

			// Rest API call to HOTEL-SERVICE using Feign Client
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			ratingList.add(rating);
		}
		user.setRatings(ratingList);
		return user;
	}

	public User ratingHotelFallback(String userId, Exception ex) {
		logger.info("Fallback method executed..." + ex.getMessage());
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found " + userId));
		return user;
	}

}
