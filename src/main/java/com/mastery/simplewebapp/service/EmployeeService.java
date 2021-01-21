package com.mastery.simplewebapp.service;

import com.mastery.simplewebapp.dao.EmployeeDao;
import com.mastery.simplewebapp.dto.*;
import com.mastery.simplewebapp.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class EmployeeService{

    @Autowired
    EmployeeDao employeeDao;
    
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> print(){
        employees = employeeDao.read();
        printList(employees);
        return employees;
    }

    public void create(Employee employee){
        employeeDao.create(new Employee((long) 1, employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                employee.getJobTitle(), employee.getGender() /*GenderString()*/, convertToSqlDate(employee.getDateOfBirth())));
        employees = employeeDao.read();
        printList(employees);
    }

    public void delete(long employeeId) throws Exception {
        if(employeeDao.ifExist(employeeId))
            employeeDao.delete(employeeId);
        else throw new EmployeeNotFoundException(employeeId);
        employees = employeeDao.read();
        printList(employees);
    }

    public void edit(long employeeId, Employee employee) throws Exception{
        if(employeeDao.ifExist(employeeId))
            employeeDao.update(employeeId, employee);
        else throw new EmployeeNotFoundException(employeeId);
        employees = employeeDao.read();
        printList(employees);
    }

    public boolean ifExist(long employeeId){
        return employeeDao.ifExist(employeeId);
    }

    public Employee get(long employeeId){
        return employeeDao.get(employeeId);
    }

    //converting to sql format to transfer
    private Date convertToSqlDate(Calendar calendar) {
        return new Date(calendar.getTimeInMillis());
    }

    //to print list to terminal
    public void printList(List<Employee> employees){
        for (Employee employee : employees) employee.print();
    }
}
