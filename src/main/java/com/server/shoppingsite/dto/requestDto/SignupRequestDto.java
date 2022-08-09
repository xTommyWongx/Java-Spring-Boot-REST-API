package com.server.shoppingsite.dto.requestDto;

import lombok.Data;

import java.util.Set;

@Data
public class SignupRequestDto {
    private String username;
    private String password;
    private String email;
    private Set<String> role;
}
