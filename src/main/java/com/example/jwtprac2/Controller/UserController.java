package com.example.jwtprac2.Controller;

import com.example.jwtprac2.dto.SignupRequestDto;
import com.example.jwtprac2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/member/signup")
    public void signUp(@RequestBody SignupRequestDto signupRequestDto){
        userService.registerUser(signupRequestDto);
    }
}
