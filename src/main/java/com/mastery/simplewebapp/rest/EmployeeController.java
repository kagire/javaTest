package com.mastery.simplewebapp.rest;

import com.mastery.simplewebapp.dto.Employee;
import com.mastery.simplewebapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> showEmployee(){
        return employeeService.print();
    }

    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable long id){
        return employeeService.get(id);
    }

    @PostMapping
    public void newEmployee(@RequestBody Employee employee){
        employeeService.create(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee (@PathVariable long id, @RequestBody Employee employee) throws Exception {
        employeeService.edit(id, employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) throws Exception {
        employeeService.delete(id);
        return new ResponseEntity<String>("updated", HttpStatus.OK);
    }
}