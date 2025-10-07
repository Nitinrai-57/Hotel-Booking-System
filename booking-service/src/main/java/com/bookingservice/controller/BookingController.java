package com.bookingservice.controller;

import com.bookingservice.dtos.BookingDetails;
import com.bookingservice.entity.Booking;
import com.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @PostMapping("/createbooking")
    public Booking createBooking(@RequestBody BookingDetails booking)
    {
       return bookingService.createBooking(booking);
    }


}
