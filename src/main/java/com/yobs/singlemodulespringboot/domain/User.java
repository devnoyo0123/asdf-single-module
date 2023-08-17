package com.yobs.singlemodulespringboot.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {

    private final Long id;

    private final String email;

    private final String password;

    public static User withOutId(String email, String password) {
        return new User(null, email, password);
    }
}
