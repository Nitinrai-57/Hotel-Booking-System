package com.userservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String accessToken;
    private String tokenType="Bearer";
    private long expriesInSeconds;
    private String refereshToken;

}
