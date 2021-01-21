package com.mastery.simplewebapp.service;

import com.mastery.simplewebapp.dao.EmployeeDao;
import com.mastery.simplewebapp.dto.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.SQLException;
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
    void create() throws SQLException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee((long)1, "One", "Two", 28, "mr President",
                "MALE", new Date(1)));
        employeeService.create(employees.get(0));
        employees = employeeService.print();

        Assert.assertNotNull(employees);
    }

    @Test
    void update() throws Exception {
        Employee newEmployee = new Employee((long)1, "UPDATE", "UPDATE", 28,
                "mr President", "MALE", new Date(1));
        employeeService.edit(14, newEmployee);
        List<Employee> employees = employeeService.print();

        Assertions.assertNotNull(employees);

        Mockito.verify(employeeDao, Mockito.never()).get(ArgumentMatchers.anyLong());
        Mockito.verify(employeeDao, Mockito.atMostOnce()).ifExist(ArgumentMatchers.anyLong());
    }

    @Test
    void print() throws SQLException, ClassNotFoundException {
        employeeService.print();
        Mockito.verify(employeeDao, Mockito.times(1)).read();
    }
}