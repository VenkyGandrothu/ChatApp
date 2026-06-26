package com.chatapp.www.service;

import java.util.List;

import com.chatapp.www.dto.UserResponseDTO;
import com.chatapp.www.entity.User;

public interface UserService {
    List<UserResponseDTO> getAllUsers();
    List<UserResponseDTO> searchUsers(String name);
}