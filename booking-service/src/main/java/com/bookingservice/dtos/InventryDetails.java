package com.bookingservice.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InventryDetails {
    private Long id;
    private String roomId;
    private LocalDate date;
    private int availableRoom;
    private int version;
}
