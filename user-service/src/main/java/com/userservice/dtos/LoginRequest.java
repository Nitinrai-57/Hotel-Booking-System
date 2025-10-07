package com.userservice.dtos;

import lombok.Data;

@Data
public class LoginRequest {

    private String nameoremail;
    private String password;

}
