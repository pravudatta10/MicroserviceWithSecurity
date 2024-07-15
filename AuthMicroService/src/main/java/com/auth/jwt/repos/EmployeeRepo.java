package com.auth.jwt.repos;

import com.auth.jwt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByUserName(String username);
}