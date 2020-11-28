package com.mastery.simplewebapp.dao;

import com.mastery.simplewebapp.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Repository
@Transactional
public class EmployeeDao extends JdbcDaoSupport {

    //connection link
    @Autowired
    public EmployeeDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    //READ
    public List<Employee> read(){
        String sql = "SELECT * FROM employee";
        Object[] params = new Object[]{};
        EmployeeMapper mapper = new EmployeeMapper();
        assert this.getJdbcTemplate() != null;
        return this.getJdbcTemplate().query(sql, params, mapper);
    }

    //CREATE
    public List<Employee> create(String firstName, String lastName, int departmentId, String jobTitle,
                                 String gender, Date dateOfBirth){
        String sql = "INSERT INTO employee (first_name, last_name," +
                " department_id, job_title, gender, date_of_birth) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] params = new Object[]{firstName, lastName, departmentId, jobTitle, gender, dateOfBirth};
        assert this.getJdbcTemplate() != null;
        this.getJdbcTemplate().update(sql, params);
        return read();
    }

    //DELETE
    public List<Employee> delete(long employeeId){
        String sql = "DELETE FROM employee WHERE employee_id = ?";
        Object[] params = new Object[]{employeeId};
        assert this.getJdbcTemplate() != null;
        this.getJdbcTemplate().update(sql, params);
        return read();
    }

    //UPDATE
    public List<Employee> update(long employeeId, Employee employee){
        String sql = "UPDATE employee SET first_name = ?, last_name = ?, department_id = ?, job_title = ?," +
                " gender = ?, date_of_birth = ? WHERE employee_id = ?";
        Object[] params = new Object[]{employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                employee.getJobTitle(), employee.getGenderString(), new Date(employee.getDateOfBirth().getTimeInMillis()),
                employeeId};
        assert this.getJdbcTemplate() != null;
        this.getJdbcTemplate().update(sql, params);
        return read();
    }

    //get exact one
    public Employee get(long employeeId){
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        Object[] params = new Object[]{employeeId};
        EmployeeMapper mapper = new EmployeeMapper();
        assert this.getJdbcTemplate() != null;
        return this.getJdbcTemplate().queryForObject(sql, params, mapper);
    }

    //record exists or not
    public boolean ifExist(long employeeId){
        String sql = "SELECT * FROM employee where employee_id = ?";
        Object[] params = new Object[]{employeeId};
        EmployeeMapper mapper = new EmployeeMapper();
        try {
            assert this.getJdbcTemplate() != null;
            return this.getJdbcTemplate().queryForObject(sql, params, mapper) != null;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
