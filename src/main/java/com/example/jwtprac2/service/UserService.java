package com.example.jwtprac2.service;

import com.example.jwtprac2.domain.User;
import com.example.jwtprac2.dto.SignupRequestDto;
import com.example.jwtprac2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    // 회원 가입 하기
    public void registerUser(SignupRequestDto signupRequest){

        // 비밀번호 일치 불일치 확인
        if(!(signupRequest.getPassword().equals(signupRequest.getPasswordCheck()))){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        //비밀번호 암호화
        signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        // dto를 통해 회원 생성
        User user = new User(signupRequest);

        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByNickname(user.getNickname());
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        // 레포지터리에 저장
        userRepository.save(user);

        System.out.println("회원 가입 완료");
    }
}
