package com.server.shoppingsite.dto.requestDto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String username;
    private String password;
}
