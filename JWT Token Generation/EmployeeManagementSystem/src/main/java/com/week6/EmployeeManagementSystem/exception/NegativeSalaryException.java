package com.week6.EmployeeManagementSystem.exception;

public class NegativeSalaryException extends RuntimeException {

    public NegativeSalaryException(String message) {
//        super(message);
    }

    public NegativeSalaryException(Throwable cause) {
        super(cause);
    }

    public NegativeSalaryException(String message, Throwable cause) {
        super(message, cause);
    }
}
