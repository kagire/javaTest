package com.mastery.simplewebapp;

import com.mastery.simplewebapp.dao.EmployeeDao;
import com.mastery.simplewebapp.dto.Employee;
import com.mastery.simplewebapp.dto.Gender;
import com.mastery.simplewebapp.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeDao employeeDao;

    @Test
    void create(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "One", "Two", 28, "mr President",
                Gender.MALE, new Date(1)));
        employeeService.create(employees.get(0));
        employees = employeeService.print();

        Assertions.assertNotNull(employees);
    }

    @Test
    void print(){
        employeeService.print();
        Mockito.verify(employeeDao, Mockito.times(1)).read();
    }
}