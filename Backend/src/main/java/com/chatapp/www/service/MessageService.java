package com.chatapp.www.service;

import java.util.List;

import com.chatapp.www.dto.SendMessageDTO;
import com.chatapp.www.entity.Message;

public interface MessageService {
    Message saveMessage(SendMessageDTO messageDTO);
    List<Message> getMessages(Long senderId, Long receiverId);
    void deleteMessage(Long messageId);
}
