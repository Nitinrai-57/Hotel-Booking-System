package com.inventryService.controller;

import com.inventryService.entity.RoomInventry;
import com.inventryService.service.InventryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/inventry")
public class InventryController {
    @Autowired
    InventryService inventryService;
    @GetMapping("/getAvailableRoom/{roomId}/{checkDate}")
    public RoomInventry getRoomInventry(@PathVariable("roomId") String roomId,@PathVariable("checkDate")@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate checkDate){
      return inventryService.getRoomInventry(roomId,checkDate);
    }
}
