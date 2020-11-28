package com.mastery.simplewebapp.dao;

import com.mastery.simplewebapp.dto.Employee;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

//mapping data on SQL request and DB fields
public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Employee(rs.getLong("employee_id"), rs.getString("first_name"),
                rs.getString("last_name"), rs.getInt("department_id"),
                rs.getString("job_title"), rs.getString("gender"),
                rs.getDate("date_of_birth"));
    }
}
