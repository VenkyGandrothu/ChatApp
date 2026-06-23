package com.chatapp.www.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageDTO {

    @NotBlank(message = "Message content is required")
    private String content;

    @NotNull(message = "Receiver id is required")
    private Long receiverId;
}