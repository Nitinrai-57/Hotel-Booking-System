package com.hotelservice.payloads;

import lombok.*;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseHotel {
    private String message;
    private boolean isSuccess;
    private HttpStatus httpStatusCode;
}
