package com.app2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app2")
public class app2Controller {

    @GetMapping("/")
    public String msg() {
        System.out.println("Inside APP2");
        return "Welcome to app2";
    }
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome API From app2";
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