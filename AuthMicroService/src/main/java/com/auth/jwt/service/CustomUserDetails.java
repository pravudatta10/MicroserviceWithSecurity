package com.auth.jwt.service;

import com.auth.jwt.entity.Employee;
import com.auth.jwt.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetails implements UserDetailsService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> user = employeeRepo.findByUserName(username);
        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.
                    User(user.get().getUserName()
                    , user.get().getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User Not Found");
        }
    }
}