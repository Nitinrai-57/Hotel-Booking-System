package com.bookingservice.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDetails {
    private Long userId;
    private String hotelId;
    private String roomId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int quantity;
}
