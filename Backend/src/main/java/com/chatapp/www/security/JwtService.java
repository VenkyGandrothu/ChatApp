package com.chatapp.www.security;

import org.springframework.stereotype.Component;

import lombok.Value;

@Component
public class JwtService {
    

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expirationTime;
}
