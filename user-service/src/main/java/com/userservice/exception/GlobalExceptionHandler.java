package com.userservice.exception;

import com.userservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFount.class)  // Corrected spelling
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFount ex) {

        String message = ex.getMessage();
        ApiResponse apiResponse= ApiResponse.builder().message(message).isSuccess(true).httpStatusCode(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
