package com.userservice.controllers;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
    private String status;
}
