package com.mastery.simplewebapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@EnableWebMvc
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { EmployeeNotFoundException.class })
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        e.printStackTrace();
        System.out.println("Make sure u trying to manage existing employee");
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
