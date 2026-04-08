package com.week6.EmployeeManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NegativeSalaryException.class)
    public ResponseEntity<EmployeeErrorResponse> handleNegativeSalaryException(NegativeSalaryException negativeSalaryException){
//        @Autowired : can't be use int instance field
//        Any other way to inject the object of NegativeSalaryResponse
        EmployeeErrorResponse response = new EmployeeErrorResponse();
//        response.setMessage("Salary Can't be Negative");
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateEmailException(
            DuplicateEmailException duplicateEmailException){
        Map<String, String> errorMsg = new HashMap<>();
        errorMsg.put("message", "Email already exists");
        return ResponseEntity.badRequest().body(errorMsg);
    }

}
