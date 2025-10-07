package com.bookingservice.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoomDetails {

    private String roomId;
    private String hotelId;
    private String roomType;
    private int totalRoom;
    private double pricePerNight;
    private int maximumGuest;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
