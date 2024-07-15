package com.auth.jwt.controller;

import com.auth.jwt.dto.AUthRes;
import com.auth.jwt.dto.AuthDto;
import com.auth.jwt.entity.Employee;
import com.auth.jwt.service.AuthService;
import com.auth.jwt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class MasterController {
    @Autowired
    AuthService authService;
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/signup")
    public String saveEmp(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AUthRes> generateToken(@RequestBody AuthDto authDto) {
        return authService.authenticate(authDto);
    }

    @PostMapping("/hello")
    public String hello() {
        return "Hello";
    }
}