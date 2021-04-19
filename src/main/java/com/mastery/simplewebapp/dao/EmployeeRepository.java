package com.mastery.simplewebapp.dao;

import com.mastery.simplewebapp.dto.Employee;
import com.mastery.simplewebapp.dto.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findById(Long employeeId);

    @Query(value = "SELECT * FROM employee ORDER BY employee_id", nativeQuery = true)
    List<Employee> findAll();

    void deleteById(Long employeeId);
    boolean existsById(Long employeeId);
    int countByGender(Gender gender);
}
