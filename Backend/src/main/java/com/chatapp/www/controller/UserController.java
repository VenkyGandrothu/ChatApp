package com.chatapp.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.www.dto.UserResponseDTO;
import com.chatapp.www.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<UserResponseDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/search")
    public List<UserResponseDTO> searchUsers(@RequestParam String name){
        return userService.searchUsers(name);
    }
        
}
