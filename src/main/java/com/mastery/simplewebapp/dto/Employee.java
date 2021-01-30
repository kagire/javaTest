package com.mastery.simplewebapp.dto;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @NotBlank(message = "Cannot be blank")
    @Column(name = "first_name")
    private String firstName;
    @NotBlank(message = "Cannot be blank")
    @Column(name = "last_name")
    private String lastName;
    @Min(value = 0, message = "Invalid department")
    @Column(name = "department_id")
    private int departmentId;
    @NotBlank(message = "Cannot be blank")
    @Column(name = "job_title")
    private String jobTitle;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    public Employee(){}

    public Employee(long employeeId, String firstName, String lastName, int departmentId,
                    String jobTitle, Gender gender, Date dateOfBirth){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    //get
    public long getEmployeeId(){ return employeeId; }

    public String getFirstName(){ return firstName; }

    public String getLastName(){ return lastName; }

    public int getDepartmentId(){ return departmentId; }

    public String getJobTitle(){ return jobTitle; }

    public Gender getGender(){ return gender; }

    public Date getDateOfBirth(){ return dateOfBirth; }

    //set
    public void setEmployeeId(long employeeId){ this.employeeId = employeeId; }

    public void setFirstName(String firstName){ this.firstName = firstName; }

    public void setLastName(String lastName){ this.lastName = lastName; }

    public void setDepartmentId(int departmentId){ this.departmentId = departmentId; }

    public void setJobTitle(String jobTitle){ this.jobTitle = jobTitle; }

    public void setGender(Gender gender){ this.gender = gender; }

    public void setDateOfBirth(Date dateOfBirth){ this.dateOfBirth = dateOfBirth; }

    public void cloneData(Employee employee){
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.departmentId = employee.getDepartmentId();
        this.jobTitle = employee.getJobTitle();
        this.gender = employee.getGender();
        this.dateOfBirth = employee.getDateOfBirth();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) return true;

        if (obj == null || obj.getClass() != this.getClass()) return false;

        Employee employee2 = (Employee) obj;
        return this.firstName.equals(employee2.getFirstName()) &&
                this.lastName.equals(employee2.getLastName()) &&
                this.jobTitle.equals(employee2.getJobTitle()) &&
                this.dateOfBirth.equals(employee2.getDateOfBirth()) &&
                this.gender.equals(employee2.getGender()) &&
                this.departmentId == employee2.getDepartmentId();
    }

    @Override
    public String toString() {
        return this.firstName;
    }
}
