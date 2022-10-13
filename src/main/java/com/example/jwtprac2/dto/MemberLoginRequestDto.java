package com.example.jwtprac2.dto;

import lombok.Data;

@Data
public class MemberLoginRequestDto {
    private String nickname;
    private String password;
}
