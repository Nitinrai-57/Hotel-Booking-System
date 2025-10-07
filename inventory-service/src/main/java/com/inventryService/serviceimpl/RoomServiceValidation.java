package com.inventryService.serviceimpl;

import com.inventryService.dtos.RoomDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class RoomServiceValidation {
    @Autowired
    RestTemplate restTemplate;
    public RoomDetails getRoomInfo(String roomId){
       RoomDetails roomDetails= restTemplate.getForObject("http://localhost:9990/room/getRoom/301",RoomDetails.class);

       return roomDetails;
    }
}
