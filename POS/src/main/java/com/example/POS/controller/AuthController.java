package com.example.POS.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    
    @PostMapping("/auth/login")
    public String login() {
        return "login";
    }
}
