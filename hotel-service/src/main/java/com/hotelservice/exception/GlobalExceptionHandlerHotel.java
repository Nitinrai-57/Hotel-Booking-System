package com.hotelservice.exception;

import com.hotelservice.payloads.ApiResponseHotel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerHotel {
    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiResponseHotel> reponseExceptionHalder(ResourceNotFoundException resourceNotFoundException){
        ApiResponseHotel response=new ApiResponseHotel().builder().message(resourceNotFoundException.getMessage()).isSuccess(true).httpStatusCode(HttpStatus.NOT_FOUND).build();
    return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
