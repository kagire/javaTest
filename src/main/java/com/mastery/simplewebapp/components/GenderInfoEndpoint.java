package com.mastery.simplewebapp.components;

import com.mastery.simplewebapp.dao.EmployeeRepository;
import com.mastery.simplewebapp.dto.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "genders")
public class GenderInfoEndpoint{

    @Autowired
    EmployeeRepository employeeRepository;

    @ReadOperation
    public Map<String, Integer> countGenders() {
        Map<String, Integer> userDetails = new HashMap<>();
        userDetails.put("male", employeeRepository.countByGender(Gender.MALE));
        userDetails.put("female", employeeRepository.countByGender(Gender.FEMALE));

        return userDetails;
    }
}
