package com.chatapp.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.www.service.ConnectionService;

@RestController
@RequestMapping("/api/connections")
public class ConnectionController {
    
    @Autowired
    private ConnectionService connectionService;

    


}
