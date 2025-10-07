package com.hotelservice.services;

import com.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {


    Hotel getHotel(String id);

    List<Hotel> getAllHotel();

    Hotel saveHotel(Hotel hotel);

}
