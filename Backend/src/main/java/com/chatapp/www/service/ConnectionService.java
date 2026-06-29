package com.chatapp.www.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.chatapp.www.entity.ConnectionStatus;
import com.chatapp.www.entity.User;
import com.chatapp.www.entity.UserConnection;
import com.chatapp.www.repository.UserConnectionRepository;
import com.chatapp.www.repository.UserRepository;

@Service
public class ConnectionService {

    @Autowired
    private UserConnectionRepository userConnectionRepository;

    @Autowired
    private UserRepository userRepository;

    public UserConnection sendRequest(Long targetUserId) {
        User requester = getCurrentUser();
        User receiver = userRepository.findById(targetUserId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (requester.getId().equals(receiver.getId())) {
            throw new RuntimeException("You cannot send a connection request to yourself");
        }

        userConnectionRepository.findConnectionBetweenUsers(requester, receiver)
                .ifPresent(existing -> {
                    if (existing.getStatus() == ConnectionStatus.PENDING) {
                        throw new RuntimeException("Connection request already pending");
                    }
                    if (existing.getStatus() == ConnectionStatus.ACCEPTED) {
                        throw new RuntimeException("You are already connected with this user");
                    }
                    throw new RuntimeException("Connection request was previously rejected");
                });

        UserConnection connection = new UserConnection();
        connection.setRequester(requester);
        connection.setReceiver(receiver);
        connection.setStatus(ConnectionStatus.PENDING);
        connection.setCreatedAt(LocalDateTime.now());

        return userConnectionRepository.save(connection);
    }

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
