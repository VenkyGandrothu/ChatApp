package com.chatapp.www.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
    private String name;
    private String email;
    private String password;
    private LocalDateTime createAt;
}