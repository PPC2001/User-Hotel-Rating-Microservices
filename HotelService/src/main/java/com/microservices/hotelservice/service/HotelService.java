package com.microservices.hotelservice.service;

import java.util.List;

import com.microservices.hotelservice.entity.Hotel;

public interface HotelService {
	
	
	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotels();
	
	Hotel getHotel(String hotelId);
}
