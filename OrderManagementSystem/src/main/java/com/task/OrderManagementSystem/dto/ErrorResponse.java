package com.task.OrderManagementSystem.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    // what if work with HttpStatus directly
    private HttpStatus status;
//    private int status;
    private String message;
    private long timeStamp;


}
