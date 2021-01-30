package com.mastery.simplewebapp.dao;

import com.mastery.simplewebapp.dto.Employee;
import com.mastery.simplewebapp.dto.Gender;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findById(Long employeeId);
    List<Employee> findAll();
    void deleteById(Long employeeId);
    boolean existsById(Long employeeId);
    Employee findByFirstName(String name);
    int countByGender(Gender gender);
}
