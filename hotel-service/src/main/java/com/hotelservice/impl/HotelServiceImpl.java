package com.hotelservice.impl;

import com.hotelservice.entities.Hotel;
import com.hotelservice.repositories.HotelRepository;
import com.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel getHotel(String id) {
       return hotelRepository.findById(id).orElseThrow(()->new RuntimeException("Hotel not found this hotelId is not valid"));
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String id= UUID.randomUUID().toString();
        hotel.setHotelId(id);
        return hotelRepository.save(hotel);
    }
}
