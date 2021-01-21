package com.mastery.simplewebapp.exceptions;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(long employeeId) {
        super("Employee with id " + employeeId + " does not exist");
    }
}
