package com.mastery.simplewebapp;

import com.mastery.simplewebapp.config.AppConfiguration;
import com.mastery.simplewebapp.dao.EmployeeRepository;
import com.mastery.simplewebapp.dto.Employee;
import static org.assertj.core.api.Assertions.*;

import com.mastery.simplewebapp.dto.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(AppConfiguration.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testCreateAndFind() {
        // given
        Employee employee = new Employee(6, "One", "Two", 28, "mr President",
                Gender.MALE, new Date(1));
        entityManager.merge(employee);
        entityManager.flush();

        Employee found = employeeRepository.findByFirstName(employee.getFirstName());

        assertThat(found.getFirstName()).isEqualTo(employee.getFirstName());
    }

}
