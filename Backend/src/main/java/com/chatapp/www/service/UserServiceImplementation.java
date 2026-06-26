package com.chatapp.www.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.chatapp.www.dto.UserResponseDTO;
import com.chatapp.www.entity.User;
import com.chatapp.www.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {


    @Autowired
    private UserRepository userRepo;

    

    //finding the current usre (is you)
    private User getCurrentUser(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
    }

    //getting all users with user response DTO
    @Override
    public List<UserResponseDTO> getAllUsers() {
        User currentUser = getCurrentUser();

        List<User> allUsers = userRepo.findAll();
        List<UserResponseDTO> result = new ArrayList<>();

        for(User user : allUsers){
            if(!user.getId().equals(currentUser.getId())){
                result.add(injectIntoDTO(user));
            }
        }
        return result;

    }

    @Override
    public List<UserResponseDTO> searchUsers(String name) {
        User currentUser = getCurrentUser();

        List<User> matchedUsers = userRepo.findByNameContainingIgnoreCase(name);

        List<UserResponseDTO> result = new ArrayList<>();

        for(User user : matchedUsers){
            if(!user.getId().equals(currentUser.getId())){
                result.add(injectIntoDTO(user));
            }
        }
        return result;
    }

    private UserResponseDTO injectIntoDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
        return userResponseDTO;
    }
    
}
