package com.yobs.singlemodulespringboot.application.port.in;

import lombok.Getter;

@Getter
public class SignUpCommand {

    private final String email;
    private final String password;

    public SignUpCommand(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
