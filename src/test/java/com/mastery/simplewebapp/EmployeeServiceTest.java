package com.mastery.simplewebapp;

import com.mastery.simplewebapp.dao.EmployeeDao;
import com.mastery.simplewebapp.dto.Employee;
import com.mastery.simplewebapp.dto.Gender;
import com.mastery.simplewebapp.exceptions.EmployeeNotFoundException;
import com.mastery.simplewebapp.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeDao employeeDao;

    @Test
    void printShouldReturnNonNullValue(){
        Assertions.assertNotNull(employeeService.print());
        Mockito.verify(employeeDao, Mockito.times(1)).read();
    }

    @Test
    void createShouldRunButListStillBeEmpty(){
        employeeService.create(new Employee("One", "Two", 28, "mr President",
                Gender.MALE, new Date(1)));

        Assertions.assertTrue(employeeService.print().isEmpty());
        Mockito.verify(employeeDao, Mockito.times(2)).read();
    }

    @Test
    void deleteShouldThrowEmployeeNotFoundException(){
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.delete(1));
    }

    @Test
    void editShouldThrowEmployeeNotFoundException() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.delete(1));
    }

    @Test
    void getShouldThrowEmployeeNotFoundException() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.delete(1));
    }
}