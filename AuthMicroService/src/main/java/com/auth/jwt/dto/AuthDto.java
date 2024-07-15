package com.auth.jwt.dto;

import lombok.Data;

@Data
public class AuthDto {
    private String loginId;
    private String password;
}