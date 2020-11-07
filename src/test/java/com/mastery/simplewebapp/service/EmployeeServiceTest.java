package com.mastery.simplewebapp.service;

import com.mastery.simplewebapp.dao.EmployeeDao;
import com.mastery.simplewebapp.dto.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

    @Test
    void create() throws SQLException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee((long)1, "One", "Two", 28, "mr President",
                "MALE", new Date(1)));
        employees = EmployeeService.create(employees.get(0));

        Assert.assertTrue(EmployeeDao.ifExist(employees.get(0).getEmployeeId()));
        Assert.assertNotNull(employees.get(0).getFirstName());
    }

    @Test
    void update() throws SQLException, ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();
        Employee newEmployee = new Employee((long)1, "UPDATE", "UPDATE", 28, "mr President",
                "MALE", new Date(1));
        long counter = 0;
        while(counter < 100){
            if(EmployeeDao.ifExist(counter)){
                employees.add(EmployeeService.get(counter));
                break;
            }
            counter++;
        }
        employees = EmployeeService.edit(counter, newEmployee);

        Assert.assertTrue(EmployeeDao.ifExist(employees.get(0).getEmployeeId()));
        Assert.assertNotNull(employees.get(0).getFirstName());
    }

    @MockBean
    private EmployeeService employeeService;

    @Test
    void checkResponse(){
        employeeService.report();
        Mockito.verify(employeeService, Mockito.times(1)).report();
    }
}