package com.app1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app1")
@RestController
public class app1Controller {

    @GetMapping("/msg")
    public String msg() {
        System.out.println("Inside APP1");
        return "Welcome to app1";
    }

    @GetMapping("/secure")
    public String secureData() {
        return "This is a secure data";
    }

    @GetMapping("/public")
    public String publicData() {
        return "This is a public data";
    }
}