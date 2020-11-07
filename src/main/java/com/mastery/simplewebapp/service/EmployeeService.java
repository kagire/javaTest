package com.mastery.simplewebapp.service;

import com.mastery.simplewebapp.dao.EmployeeDao;
import com.mastery.simplewebapp.dto.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EmployeeService {
    
    private static List<Employee> employees = new ArrayList<>();

    public static List<Employee> print() throws SQLException, ClassNotFoundException {
        employees = EmployeeDao.read();
        printList(employees);
        return employees;
    }

    public static List<Employee> create(Employee employee) throws SQLException, ClassNotFoundException {
        employees = EmployeeDao.create(employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                employee.getJobTitle(), employee.getGenderString(), convertToSqlDate(employee.getDateOfBirth()));
        printList(employees);
        return employees;
    }

    public static List<Employee> delete(long employeeId) throws SQLException, ClassNotFoundException {
        if(EmployeeDao.ifExist(employeeId))
            employees = EmployeeDao.delete(employeeId);
        printList(employees);
        return employees;
    }

    public static List<Employee> edit(long employeeId, Employee employee) throws SQLException, ClassNotFoundException {
        if(EmployeeDao.ifExist(employeeId))
            employees = EmployeeDao.update(employeeId, employee);
        printList(employees);
        return employees;
    }

    public static Employee get(long employeeId) throws SQLException, ClassNotFoundException {
        return EmployeeDao.get(employeeId);
    }

    //converting to sql format to transfer
    private static Date convertToSqlDate(Calendar calendar) {
        return new Date(calendar.getTimeInMillis());
    }

    //to print list to terminal
    public static void printList(List<Employee> employees){
        for (Employee employee : employees) employee.print();
    }

}
