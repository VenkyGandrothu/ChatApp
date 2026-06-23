package com.chatapp.www.service;

import java.util.List;

import com.chatapp.www.entity.User;

public interface UserService {
    List<User> getAllUsers();
    List<User> searchUsers(String name);
}