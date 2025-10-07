package com.bookingservice.serviceImpl;

import com.bookingservice.dtos.InventryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class IntentryValidationService {

    @Autowired
    RestTemplate restTemplate;
    public InventryDetails getInventryDataForTheDate(String roomId, LocalDate checkForDay){
          InventryDetails inventryDetails= restTemplate.getForObject("http://INVENTRYSERVICE/inventry/getAvailableRoom/301/25-09-2025",InventryDetails.class);
          return inventryDetails;
    }
}
