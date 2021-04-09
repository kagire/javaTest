package com.mastery.simplewebapp.rest;

import com.mastery.simplewebapp.dto.Employee;
import com.mastery.simplewebapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void newEmployee(@Valid @RequestBody Employee employee){
        employeeService.create(employee);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee (@PathVariable long id,@Valid @RequestBody Employee employee){
        employeeService.edit(id, employee);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable long id){
        employeeService.delete(id);
    }
}