package com.bookingservice.serviceImpl;

import com.bookingservice.dtos.RoomDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RoomValidationService {
    @Autowired
    RestTemplate restTemplate;
    public List<RoomDetails> findRoom(String hotelId)
    {
        ResponseEntity<List<RoomDetails>> response =
                restTemplate.exchange(
                        "http://HOTELSERVICE/room/hotelId/" + hotelId,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<RoomDetails>>() {}
                );

        List<RoomDetails> result = response.getBody();

        return result;
    }
}
