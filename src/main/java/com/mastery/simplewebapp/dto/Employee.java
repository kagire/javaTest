package com.mastery.simplewebapp.dto;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee {
    private final Long employeeId;
    private final String firstName;
    private final String lastName;
    private final int departmentId;
    private final String jobTitle;
    private final Gender gender;
    private final Calendar dateOfBirth;

    public Employee(Long employeeId, String firstName, String lastName, int departmentId,
                    String jobTitle, String gender, Date dateOfBirth){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        if (gender.equals("MALE")) this.gender = Gender.MALE;
        else this.gender = Gender.FEMALE;
        this.dateOfBirth = convertToCalendar(dateOfBirth);
    }

    public long getEmployeeId(){ return employeeId; }

    public String getFirstName(){ return firstName; }

    public String getLastName(){ return lastName; }

    public int getDepartmentId(){ return departmentId; }

    public String getJobTitle(){ return jobTitle; }

    public Gender getGender(){ return gender; }

    public String getGenderString() {
        if (gender == Gender.FEMALE) return "FEMALE";
        else return "MALE";
    }

    public Calendar getDateOfBirth(){ return dateOfBirth; }

    public void print(){
        System.out.println("Id: " + employeeId + ", name: " + firstName + ", last name: " + lastName + ", department: "
                + departmentId + ", job: " + jobTitle + ", gender: " + this.getGenderString() + ", birthdate: " +
                dateOfBirth.get(Calendar.YEAR) + "-" + dateOfBirth.get(Calendar.MONTH) +
                "-" + dateOfBirth.get(Calendar.DAY_OF_MONTH));
    }

    private static Calendar convertToCalendar(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;
    }
}
