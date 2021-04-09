package com.mastery.simplewebapp.dao;

import com.mastery.simplewebapp.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class EmployeeDao extends JdbcDaoSupport {

    //JPA
    @Autowired
    private EmployeeRepository employeeRepository;

    //connection link
    @Autowired
    public EmployeeDao(DataSource dataSource) { this.setDataSource(dataSource); }

    //READ
    public List<Employee> read(){
        return employeeRepository.findAll();
    }

    //CREATE
    public void create(Employee employee){
        employeeRepository.save(employee);
    }

    //DELETE
    public void delete(long employeeId){
        employeeRepository.deleteById(employeeId);

    }

    //UPDATE
    public void update(long employeeId, Employee employee){
        Employee oldEmployee = employeeRepository.findById(employeeId).get();
        oldEmployee.cloneData(employee);
        employeeRepository.save(oldEmployee);
    }

    //get exact one
    public Employee get(long employeeId){
        return employeeRepository.findById(employeeId).get();
    }

    //record exists or not
    public boolean ifExist(long employeeId){
        return employeeRepository.existsById(employeeId);
    }
}
