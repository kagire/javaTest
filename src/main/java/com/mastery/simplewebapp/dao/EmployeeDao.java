package com.mastery.simplewebapp.dao;

import com.mastery.simplewebapp.dto.Employee;
import com.mastery.simplewebapp.postgresInput;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao extends postgresInput {

    //READ
    public static @ResponseBody List<Employee> read() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb",
                login, password);
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employee");
        ResultSet rs = stmt.executeQuery();
        List<Employee> employees = new ArrayList<>();
        while (rs.next()) {
            employees.add(new Employee(rs.getLong("employee_id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getInt("department_id"),
                    rs.getString("job_title"), rs.getString("gender"),
                    rs.getDate("date_of_birth")));
        }
        connection.close();
        return employees;
    }

    //CREATE
    public static List<Employee> create(String firstName, String lastName, int departmentId, String jobTitle,
                                        String gender, Date dateOfBirth) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb",
                login, password);
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO employee (first_name, last_name," +
                " department_id, job_title, gender, date_of_birth) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, firstName);
        stmt.setString(2, lastName);
        stmt.setInt(3, departmentId);
        stmt.setString(4, jobTitle);
        stmt.setString(5, gender);
        stmt.setDate(6, dateOfBirth);
        stmt.executeUpdate();
        connection.close();
        return read();
    }

    //DELETE
    public static List<Employee> delete(long employeeId) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb",
                login, password);
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM employee WHERE employee_id = ?");
        stmt.setLong(1, employeeId);
        stmt.executeUpdate();
        connection.close();
        return read();
    }

    //UPDATE
    public static List<Employee> update(long employeeId, Employee employee) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb",
                login, password);
        PreparedStatement stmt = connection.prepareStatement("UPDATE employee SET first_name = ?," +
                "last_name = ?, department_id = ?, job_title = ?, gender = ?," +
                "date_of_birth = ? WHERE employee_id = ?");
        stmt.setString(1, employee.getFirstName());
        stmt.setString(2, employee.getLastName());
        stmt.setInt(3, employee.getDepartmentId());
        stmt.setString(4, employee.getJobTitle());
        stmt.setString(5, employee.getGenderString());
        stmt.setDate(6, new Date(employee.getDateOfBirth().getTimeInMillis()));
        stmt.setLong(7, employeeId);
        stmt.executeUpdate();
        return read();
    }

    //get exact one
    public static Employee get(long employeeId) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb",
                login, password);
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employee WHERE employee_id = ?");
        stmt.setLong(1, employeeId);
        ResultSet rs = stmt.executeQuery();
        connection.close();
        rs.next();
        return new Employee(rs.getLong("employee_id"), rs.getString("first_name"),
                rs.getString("last_name"), rs.getInt("department_id"),
                rs.getString("job_title"), rs.getString("gender"),
                rs.getDate("date_of_birth"));
    }

    //record exists or not
    public static boolean ifExist(long employeeId) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeedb",
                login, password);
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employee where employee_id = ?");
        stmt.setLong(1, employeeId);
        ResultSet result = stmt.executeQuery();
        return result.next();
    }
}
