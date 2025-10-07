package com.inventryService.serviceimpl;

import com.inventryService.dtos.RoomDetails;
import com.inventryService.entity.RoomInventry;
import com.inventryService.repository.InventryRepository;
import com.inventryService.service.InventryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InventryServiceImpl implements InventryService {
    @Autowired
    InventryRepository inventryRepository;
    @Autowired
    RoomServiceValidation roomServiceValidation;
    @Override
    public RoomInventry getRoomInventry(String roomId, LocalDate date) {
       RoomInventry roomInventry= inventryRepository.findByRoomIdAndDate(roomId,date);
       if(roomInventry==null){
           //Call room service and put data into the table
        RoomDetails roomDetails = roomServiceValidation.getRoomInfo(roomId);
        roomInventry=new RoomInventry();
        roomInventry.setId(1000001L);
        roomInventry.setRoomId(roomDetails.getRoomId());
        roomInventry.setDate(date);
        roomInventry.setAvailableRoom(roomDetails.getTotalRoom());
        roomInventry.setVersion(1);
        inventryRepository.save(roomInventry);
       }

       return roomInventry;
    }
}
