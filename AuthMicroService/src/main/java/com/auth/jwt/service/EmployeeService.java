package com.auth.jwt.service;

import com.auth.jwt.entity.Employee;
import com.auth.jwt.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String saveEmployee(Employee employee) {
        String encode = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encode);
        employeeRepo.save(employee);
        return "Data Saved Successfully";
    }
}