package com.bookingservice.serviceImpl;

import com.bookingservice.dtos.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserValidationService {
    @Autowired
    RestTemplate restTemplate;
    public UserDetails findUserDetails(Long userId)
    {

       UserDetails userDetails= restTemplate.getForObject("http://USERSERVICE/api/users/userId/"+userId,UserDetails.class);
       return userDetails;
    }
}
