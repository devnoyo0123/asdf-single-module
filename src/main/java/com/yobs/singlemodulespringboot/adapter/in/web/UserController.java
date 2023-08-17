package com.yobs.singlemodulespringboot.adapter.in.web;

import com.yobs.singlemodulespringboot.adapter.in.web.dto.SignupDto;
import com.yobs.singlemodulespringboot.application.port.in.SignUpCommand;
import com.yobs.singlemodulespringboot.application.port.in.SignUpUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class UserController {

    private final SignUpUseCase signUpUseCase;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupDto signupDto){
        signUpUseCase.signUp(new SignUpCommand(signupDto.getEmail(), signupDto.getPassword()));
    }
}
