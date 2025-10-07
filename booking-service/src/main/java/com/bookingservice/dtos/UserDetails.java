package com.bookingservice.dtos;

import lombok.Data;

@Data
public class UserDetails {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
    private String status;
}
