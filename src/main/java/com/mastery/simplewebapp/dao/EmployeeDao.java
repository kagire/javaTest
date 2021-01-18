package com.mastery.simplewebapp.dao;

import com.mastery.simplewebapp.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
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
    public List<Employee> create(Employee employee){
        employee = employeeRepository.save(employee);
        return read();
    }

    //DELETE
    public List<Employee> delete(long employeeId){
        employeeRepository.deleteById(employeeId);
        return read();
    }

    //UPDATE
    public List<Employee> update(long employeeId, Employee employee){
        Employee oldEmployee = employeeRepository.findById(employeeId).get();
        oldEmployee.cloneData(employee);
        employeeRepository.save(oldEmployee);
        return read();
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
