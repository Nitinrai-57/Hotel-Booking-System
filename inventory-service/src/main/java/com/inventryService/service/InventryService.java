package com.inventryService.service;

import com.inventryService.entity.RoomInventry;

import java.time.LocalDate;

public interface InventryService {
    public RoomInventry getRoomInventry(String roomId, LocalDate checkDate);
}
