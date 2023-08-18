package com.yobs.singlemodulespringboot.application.service;

import com.yobs.singlemodulespringboot.application.port.in.SignUpCommand;
import com.yobs.singlemodulespringboot.application.port.in.SignUpUseCase;
import com.yobs.singlemodulespringboot.application.port.out.SignUpRepository;
import com.yobs.singlemodulespringboot.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements SignUpUseCase {

    private final SignUpRepository signUpRepository;
    private final UserManagement userManagement;

    @Override
    public void signUp(SignUpCommand signUpCommand) {
        userManagement.checkDuplicate(signUpCommand.getEmail());
        var newUser = User.withOutId(signUpCommand.getEmail(), signUpCommand.getPassword());
        signUpRepository.signUp(newUser);
    }
}
