package com.mastery.simplewebapp.service;

import com.mastery.simplewebapp.dao.EmployeeDao;
import com.mastery.simplewebapp.dto.*;
import com.mastery.simplewebapp.exceptions.EmployeeNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService{

    @Autowired
    EmployeeDao employeeDao;

    // list
    private List<Employee> employees = new ArrayList<>();

    Logger logger = LogManager.getLogger(EmployeeService.class);

    public List<Employee> print(){
        employees = employeeDao.read();
        logToConsole();
        return employees;
    }

    public void create(Employee employee){
        employeeDao.create(new Employee(employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                employee.getJobTitle(), employee.getGender(), employee.getDateOfBirth()));
        employees = employeeDao.read();
        logToConsole();
    }

    public void delete(long employeeId){
        if(employeeDao.ifExist(employeeId))
            employeeDao.delete(employeeId);
        else throw new EmployeeNotFoundException(employeeId);
        employees = employeeDao.read();
        logToConsole();
    }

    public void edit(long employeeId, Employee employee){
        if(employeeDao.ifExist(employeeId))
            employeeDao.update(employeeId, employee);
        else throw new EmployeeNotFoundException(employeeId);
        employees = employeeDao.read();
        logToConsole();
    }

    public Employee get(long employeeId){
        if(employeeDao.ifExist(employeeId))
            return employeeDao.get(employeeId);
        else throw new EmployeeNotFoundException(employeeId);
    }

    //to print list to terminal
    public void logToConsole(){
        logger.trace("Records total: " + employees.size());
    }
}
