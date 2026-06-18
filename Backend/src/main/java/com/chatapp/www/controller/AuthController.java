package com.chatapp.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.www.dto.LoginDTO;
import com.chatapp.www.dto.RegistrationDTO;
import com.chatapp.www.service.AuthService;

import jakarta.validation.Valid;

import com.chatapp.www.dto.RegistrationDTO;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public String register( @Valid @RequestBody RegistrationDTO registrationDTO){
        return authService.register(registrationDTO);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginDTO loginDTO){
        return authService.login(loginDTO);
    }
}
