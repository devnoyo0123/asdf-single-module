package com.yobs.singlemodulespringboot.application.service;

import com.yobs.singlemodulespringboot.adapter.out.persistence.UserJpaRepository;
import com.yobs.singlemodulespringboot.application.port.in.SignUpCommand;
import com.yobs.singlemodulespringboot.application.port.in.SignUpUseCase;
import com.yobs.singlemodulespringboot.application.port.out.SignUpRepository;
import com.yobs.singlemodulespringboot.domain.User;
import com.yobs.singlemodulespringboot.event.SignedUpEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements SignUpUseCase {

    private final SignUpRepository signUpRepository;
    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    @Transactional
    public void signUp(SignUpCommand signUpCommand) {
        if(userJpaRepository.findByEmail(signUpCommand.getPassword()).isPresent()){
            throw new IllegalArgumentException("사용중인 이메일입니다.");
        }

        var newUser = User.withOutId(signUpCommand.getEmail(), passwordEncoder.encode(signUpCommand.getPassword()));
        signUpRepository.signUp(newUser);
        eventPublisher.publishEvent(new SignedUpEvent(newUser));
    }
}
