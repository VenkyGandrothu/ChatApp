package com.chatapp.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatapp.www.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
}
