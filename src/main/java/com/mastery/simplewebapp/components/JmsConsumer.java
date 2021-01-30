package com.mastery.simplewebapp.components;

import com.mastery.simplewebapp.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class JmsConsumer implements MessageListener {

    Logger logger = LogManager.getLogger(EmployeeService.class);

    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try{
            logger.info("Received Message: "+ ((TextMessage) message).getText());
        } catch(Exception e) {
            logger.error("Received Exception : "+ e);
        }

    }
}
