package com.mastery.simplewebapp.rest;

import com.mastery.simplewebapp.dto.Employee;
import com.mastery.simplewebapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> showEmployee() throws SQLException, ClassNotFoundException {
        return employeeService.print();
    }

    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable long id) throws SQLException, ClassNotFoundException {
        return employeeService.get(id);
    }

    @PostMapping
    public List<Employee> newEmployee(@RequestBody Employee employee) throws SQLException, ClassNotFoundException {
        return employeeService.create(employee);
    }

    @PutMapping("{id}")
    public List<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee)
            throws SQLException, ClassNotFoundException {
        return employeeService.edit(id, employee);
    }

    @DeleteMapping("{id}")
    public List<Employee> deleteEmployee(@PathVariable long id) throws SQLException, ClassNotFoundException {
        return employeeService.delete(id);
    }
}