package com.hotelservice.controllers;

import com.hotelservice.entities.Hotel;
import com.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping
    ResponseEntity<List<Hotel>> getAllHotel()
    {
      return new ResponseEntity<>(hotelService.getAllHotel(), HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    ResponseEntity<Hotel> getHotel(@PathVariable("hotelId") String hotelId)
    {
        return new ResponseEntity<>(hotelService.getHotel(hotelId),HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel)
    {
        return new ResponseEntity<>(hotelService.saveHotel(hotel),HttpStatus.OK);
    }
}
