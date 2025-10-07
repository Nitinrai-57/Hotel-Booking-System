package com.bookingservice.service;

import com.bookingservice.dtos.BookingDetails;
import com.bookingservice.entity.Booking;

public interface BookingService {
    public Booking createBooking(BookingDetails booking);
}
