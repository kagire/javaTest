package com.mastery.simplewebapp;

import com.mastery.simplewebapp.config.AppConfiguration;
import com.mastery.simplewebapp.dao.EmployeeRepository;
import com.mastery.simplewebapp.dto.Employee;
import com.mastery.simplewebapp.dto.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.sql.Date;

@DataJpaTest
@Import(AppConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void initiateBeforeEachTest(){
        Employee employee = new Employee("One", "One", 28, "mr President",
                Gender.MALE, new Date(1));
        Employee employee2 = new Employee("Two", "Two", 28, "mr President",
                Gender.FEMALE, new Date(1));
        employeeRepository.save(employee);
        employeeRepository.save(employee2);
    }

    @Test
    public void createAndFindFromBothRepositoryAndEntityManagerTest() {
        Assertions.assertNotNull(employeeRepository.findAll());
        int size = employeeRepository.findAll().size();
        Employee employee = new Employee("One", "One", 28, "mr President",
                Gender.FEMALE, new Date(1));
        Employee employee2 = new Employee("Two", "Two", 28, "mr President",
                Gender.FEMALE, new Date(1));

        entityManager.merge(employee);
        entityManager.flush();

        employeeRepository.save(employee2);

        Employee found = employeeRepository.findAll().get(size);
        Assertions.assertEquals(employee.getFirstName(), found.getFirstName());

        found = employeeRepository.findAll().get(size + 1);
        Assertions.assertEquals(employee2.getFirstName(), found.getFirstName());
    }

    @Test
    public void findByIdTest() {
        Employee employee1 = employeeRepository.findAll().get(0);
        Employee employee2 = employeeRepository.findById(employee1.getEmployeeId()).get();
        Assertions.assertEquals(employee1, employee2);
    }

    @Test
    public void deleteByIdAndExistsByIdTest(){
        Employee employee = new Employee("One", "One", 28, "mr President",
                Gender.MALE, new Date(1));
        int size = employeeRepository.findAll().size();
        employeeRepository.save(employee);
        Assertions.assertTrue(employeeRepository.findAll().size() > size);
        Assertions.assertTrue(employeeRepository.existsById(employee.getEmployeeId()));
        employeeRepository.deleteById(employee.getEmployeeId());
        Assertions.assertEquals(employeeRepository.findAll().size(), size);
    }

    @Test
    public void countByGenderTest(){
        Assertions.assertNotEquals(0, employeeRepository.countByGender(Gender.FEMALE));
        Assertions.assertNotEquals(0, employeeRepository.countByGender(Gender.MALE));
    }
}
