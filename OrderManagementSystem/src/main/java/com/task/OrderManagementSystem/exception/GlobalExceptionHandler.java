package com.task.OrderManagementSystem.exception;

import com.task.OrderManagementSystem.dto.ApplicationResponse;
import com.task.OrderManagementSystem.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApplicationResponse<ErrorResponse>> handleInstructorNotFoundException(NotFoundException e){
        ErrorResponse error = ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .timeStamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(new ApplicationResponse<>(List.of(error)), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApplicationResponse<ErrorResponse>> handleValidationException(ValidationException e){
        ErrorResponse error = ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .timeStamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(new ApplicationResponse<>(List.of(error)), HttpStatus.BAD_REQUEST);
    }
}
