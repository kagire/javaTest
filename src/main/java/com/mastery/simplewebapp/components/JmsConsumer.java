package com.mastery.simplewebapp.components;

import com.google.gson.Gson;
import com.mastery.simplewebapp.dto.Employee;
import com.mastery.simplewebapp.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class JmsConsumer{

    Logger logger = LogManager.getLogger(EmployeeService.class);

    @JmsListener(destination = "${active-mq.queue}")
    public void onMessage(String message) {
        try{
            Gson gson = new Gson();
            Employee employee = gson.fromJson(message, Employee.class);
            logger.info("Received Message: "+ employee.toString());
        } catch(Exception e) {
            logger.error("Received Exception : "+ e);
        }
    }
}
