package com.bookingservice.serviceImpl;

import com.bookingservice.dtos.HotelDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HotelValidationService {
    @Autowired
    RestTemplate restTemplate;
    public HotelDetails findHotel(String hotelId){

       HotelDetails hotelDetails=restTemplate.getForObject("http://HOTELSERVICE/hotel/"+hotelId,HotelDetails.class);
        return hotelDetails;
    }
}
