package com.example.POS.controller;

import org.springframework.web.bind.annotation.PostMapping;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthController {
    
    @PostMapping("/auth/login")
    public String login() {
        return "login";
    }
}
