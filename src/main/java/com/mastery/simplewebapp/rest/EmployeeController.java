package com.mastery.simplewebapp.rest;

import com.mastery.simplewebapp.dto.Employee;
import org.springframework.web.bind.annotation.*;

import com.mastery.simplewebapp.service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @GetMapping
    public List<Employee> showEmployee() throws SQLException, ClassNotFoundException {
        return EmployeeService.print();
    }

    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable long id) throws SQLException, ClassNotFoundException {
        return EmployeeService.get(id);
    }

    @PostMapping
    public List<Employee> newEmployee(@RequestBody Employee employee) throws SQLException, ClassNotFoundException {
        return EmployeeService.create(employee);
    }

    @PutMapping("{id}")
    public List<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee)
            throws SQLException, ClassNotFoundException {
        return EmployeeService.edit(id, employee);
    }

    @DeleteMapping("{id}")
    public List<Employee> deleteEmployee(@PathVariable long id) throws SQLException, ClassNotFoundException {
        return EmployeeService.delete(id);
    }
}