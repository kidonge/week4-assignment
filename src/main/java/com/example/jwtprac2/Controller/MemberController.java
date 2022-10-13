package com.example.jwtprac2.Controller;

import com.example.jwtprac2.dto.MemberLoginRequestDto;
import com.example.jwtprac2.dto.TokenInfo;
import com.example.jwtprac2.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
//@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/member/login")
    public TokenInfo login(@RequestBody MemberLoginRequestDto memberLoginRequestDto) {
        String memberId = memberLoginRequestDto.getNickname();
        String password = memberLoginRequestDto.getPassword();
        TokenInfo tokenInfo = memberService.login(memberId, password);
        return tokenInfo;
    }
}