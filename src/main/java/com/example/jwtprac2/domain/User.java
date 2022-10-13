package com.example.jwtprac2.domain;

import com.example.jwtprac2.dto.SignupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity(name = "users") // DB 테이블 역할을 합니다.
public class User {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "user_id", nullable = false)
    private Long id;

    // nullable: null 허용 여부
    // unique: 중복 허용 여부 (false 일때 중복 허용)
    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;




    public User(String nickname, String password,String email) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }

    public User(SignupRequestDto signupRequestDto) {
        this.nickname = signupRequestDto.getNickname();
        this.password = signupRequestDto.getPassword();
        this.email = signupRequestDto.getEmail();
    }
}

