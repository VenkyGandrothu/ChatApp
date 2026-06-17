package com.chatapp.www.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapp.www.dto.RegistrationDTO;
import com.chatapp.www.dto.LoginDTO;
import com.chatapp.www.entity.User;
import com.chatapp.www.repository.UserRepository;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepo;


    public String register(RegistrationDTO registrationDTO){

        Optional<User> existingUser = userRepo.findUserByEmail(registrationDTO.getEmail());
        if(existingUser.isPresent()){
            throw new RuntimeException("Email already exists");
        }

        //create new user entity
        User user = new User();

        //set user name
        user.setName(registrationDTO.getName());

        //set user email
        user.setEmail(registrationDTO.getEmail());

        //set user password
        user.setPassword(registrationDTO.getPassword());

        //set user create at
        user.setCreateAt(LocalDateTime.now());

        //save user to database
        userRepo.save(user);

        return "User registered successfully";
    }

    public String login(LoginDTO loginDTO){

        User user = (User) userRepo.findUserByEmail(loginDTO.getEmail()).orElseThrow(() -> 
        new RuntimeException("User not found or invalid credentials"));

        if(!user.getPassword().equals(loginDTO.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return "User logged in successfully";

    }
}
