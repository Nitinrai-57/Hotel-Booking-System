package com.bookingservice.dtos;

import lombok.Data;

import java.time.Instant;

@Data
public class HotelDetails {
    private String hotelId;
    private Long ownerId;
    private String hotelName;
    private String location;
    private String description;
    private double rating;
    private Instant createdAt=Instant.now();
    private Instant updatedAt;
}
