package com.chatapp.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapp.www.dto.UserResponseDTO;
import com.chatapp.www.entity.User;
import com.chatapp.www.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {


    @Autowired
    private UserRepository userRepo;

    
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<User> searchUsers(String name) {
        return userRepo.findByNameContainingIgnoreCase(name);
    }
    
}
