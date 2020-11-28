package com.mastery.simplewebapp.service;

import com.mastery.simplewebapp.dao.EmployeeDao;
import com.mastery.simplewebapp.dto.*;
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

    public List<Employee> create(Employee employee){
        employees = employeeDao.create(employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                employee.getJobTitle(), employee.getGenderString(), convertToSqlDate(employee.getDateOfBirth()));
        printList(employees);
        return employees;
    }

    public List<Employee> delete(long employeeId){
        if(employeeDao.ifExist(employeeId))
            employees = employeeDao.delete(employeeId);
        printList(employees);
        return employees;
    }

    public List<Employee> edit(long employeeId, Employee employee){
        if(employeeDao.ifExist(employeeId))
            employees = employeeDao.update(employeeId, employee);
        printList(employees);
        return employees;
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
