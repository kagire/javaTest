package com.mastery.simplewebapp.rest;

import com.mastery.simplewebapp.components.JmsProducer;
import com.mastery.simplewebapp.dto.Employee;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class JmsController {

    @Autowired
    JmsProducer jmsProducer;


    @ApiResponses(value = {
           @ApiResponse(code = 200, message = "Message successfully sent"),
           @ApiResponse(code = 400, message = "Invalid data provided")
    })
    @PostMapping(value="/messages/send")
    public Employee sendMessage(@RequestBody @Valid Employee employee){
        jmsProducer.sendMessage(employee.toString());
        return employee;
    }
}