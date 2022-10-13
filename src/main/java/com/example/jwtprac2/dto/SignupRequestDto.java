package com.example.jwtprac2.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {

    //    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,12}$")
    private String nickname;
    private String password;
    private String passwordCheck;
    private String email;


}