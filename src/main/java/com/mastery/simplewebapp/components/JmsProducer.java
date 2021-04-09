package com.mastery.simplewebapp.components;

import com.mastery.simplewebapp.dto.Employee;
import com.mastery.simplewebapp.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {

    Logger logger = LogManager.getLogger(EmployeeService.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${active-mq.queue}")
    private String queue;

    public void sendMessage(String message){
        try{
            logger.trace("Sending to "+ queue);
            logger.trace("Message: "+ message);
            jmsTemplate.convertAndSend(queue, message);
        } catch(Exception e){
            logger.error("Received exception during send message: ", e);
        }
    }
}