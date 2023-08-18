package com.yobs.singlemodulespringboot.application.service;

import com.yobs.singlemodulespringboot.adapter.out.persistence.UserJpaRepository;
import com.yobs.singlemodulespringboot.application.port.in.SignUpCommand;
import com.yobs.singlemodulespringboot.application.port.in.SignUpUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private SignUpUseCase signUpUseCase;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void clean() {
        this.userJpaRepository.deleteAll();
    }

    @DisplayName("회원가입 중복된 이메일")
    @Test
    void test2() {
        // given
        String email = "yobs@github.com";
        String password = "1q2w3e4";
        SignUpCommand signUpCommand = new SignUpCommand(email, password);
        signUpUseCase.signUp(signUpCommand);

        // when then
        var exception = assertThrows(IllegalArgumentException.class, () -> signUpUseCase.signUp(signUpCommand));
        assertEquals("사용중인 이메일입니다.", exception.getMessage());
    }

    @DisplayName("회원가입 성공")
    @Test
    void test() {
        // given
        String email = "yobs@github.com";
        String password = "1q2w3e4";
        SignUpCommand signUpCommand = new SignUpCommand(email, password);

        // when
        signUpUseCase.signUp(signUpCommand);

        // then
        assertEquals(1, userJpaRepository.count());

        var jpaUserEntity = userJpaRepository.findAll().stream().findFirst().orElseThrow(() -> new IllegalArgumentException("잘못된 요청입니다."));
        assertEquals(email, jpaUserEntity.getEmail());
        assertTrue(passwordEncoder.matches(signUpCommand.getPassword(), jpaUserEntity.getPassword()));

    }
}