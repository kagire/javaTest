package com.mastery.simplewebapp.rest;

import com.mastery.simplewebapp.components.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JmsController {

    @Autowired
    JmsProducer jmsProducer;

    @PostMapping(value="/messages/send")
    public String sendMessage(@RequestBody String message){
        jmsProducer.sendMessage(message);
        return message;
    }
}