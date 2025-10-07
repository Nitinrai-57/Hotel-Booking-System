package com.userservice.dtos;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
}
