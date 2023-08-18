package com.yobs.singlemodulespringboot.application.service;

import com.yobs.singlemodulespringboot.application.port.in.SignUpCommand;
import com.yobs.singlemodulespringboot.application.port.in.SignUpUseCase;
import com.yobs.singlemodulespringboot.application.port.out.SignUpRepository;
import com.yobs.singlemodulespringboot.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements SignUpUseCase {

    private final SignUpRepository signUpRepository;
    private final UserManagement userManagement;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpCommand signUpCommand) {
        userManagement.checkDuplicate(signUpCommand.getEmail());

        var newUser = User.withOutId(signUpCommand.getEmail(), passwordEncoder.encode(signUpCommand.getPassword()));
        signUpRepository.signUp(newUser);
    }
}
