package com.mastery.simplewebapp.dto;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "department_id")
    private int departmentId;
    @Column(name = "job_title")
    private String jobTitle;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "date_of_birth")
    private Calendar dateOfBirth;

    public Employee(){}

    public Employee(long employeeId, String firstName, String lastName, int departmentId,
                    String jobTitle, Gender gender, Date dateOfBirth){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.dateOfBirth = convertToCalendar(dateOfBirth);
    }


    //get

    public long getEmployeeId(){ return employeeId; }


    public String getFirstName(){ return firstName; }


    public String getLastName(){ return lastName; }


    public int getDepartmentId(){ return departmentId; }


    public String getJobTitle(){ return jobTitle; }


    public Gender getGender(){ return gender; }

    public Calendar getDateOfBirth(){ return dateOfBirth; }

    //set
    public void setEmployeeId(long employeeId){ this.employeeId = employeeId; }

    public void setFirstName(String firstName){ this.firstName = firstName; }

    public void setLastName(String lastName){ this.lastName = lastName; }

    public void setDepartmentId(int departmentId){ this.departmentId = departmentId; }

    public void setJobTitle(String jobTitle){ this.jobTitle = jobTitle; }

    public void setGender(Gender gender){ this.gender = gender; }

    public void setDateOfBirth(Date dateOfBirth){ this.dateOfBirth = convertToCalendar(dateOfBirth); }

    public void cloneData(Employee employee){
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.departmentId = employee.getDepartmentId();
        this.jobTitle = employee.getJobTitle();
        this.gender = employee.getGender();
        this.dateOfBirth = employee.getDateOfBirth();
    }

    private static Calendar convertToCalendar(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;
    }
}
