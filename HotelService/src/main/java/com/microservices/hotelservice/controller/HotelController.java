package com.microservices.hotelservice.controller;

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
import com.microservices.hotelservice.entity.Hotel;
import com.microservices.hotelservice.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	HotelService hotelService;

	@PostMapping("/createHotel")
	public ResponseEntity<Hotel> createUser(@RequestBody Hotel hotel) {
		logger.info("Creating hotel: " + hotel.toString());
		Hotel savedHotel = hotelService.createHotel(hotel);
		logger.info("Hotel created: " + savedHotel.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleUser(@PathVariable String hotelId) {
		logger.info("Fetching hotel with ID: " + hotelId);
		Hotel hotel = hotelService.getHotel(hotelId);
		logger.info("Fetched hotel: " + hotel.toString());
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
	}

	@GetMapping("/getAllHotels")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		logger.info("Fetching all hotels");
		List<Hotel> hotelList = hotelService.getAllHotels();
		logger.info("Fetched " + hotelList.size() + " hotels");
		return ResponseEntity.status(HttpStatus.OK).body(hotelList);
	}
}
