package com.inventryService.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoomDetails {
    private String roomId;

    private String hotelId;

    private RoomType roomType;
    private int totalRoom;
    private double pricePerNight;
    private int maximumGuest;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
enum RoomType{
    SINGLE,DOUBLE,SUITE,DELUXE
}