package com.yobs.singlemodulespringboot.application.service;

import com.yobs.singlemodulespringboot.adapter.out.persistence.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserManagement {
    private final UserJpaRepository userJpaRepository;

    public void checkDuplicate(String email) {
        if(userJpaRepository.findByEmail(email).isPresent()){
            throw new IllegalArgumentException("사용중인 이메일입니다.");
        }
    }
}
