package com.auth.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "nb_emp_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String fname;

    @Column(nullable = false)
    private String lname;

    private Integer age;

    private LocalDate dataOfJoining;

    private Double salary;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;
}