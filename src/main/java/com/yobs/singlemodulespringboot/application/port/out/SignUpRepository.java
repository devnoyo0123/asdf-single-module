package com.yobs.singlemodulespringboot.application.port.out;

import com.yobs.singlemodulespringboot.domain.User;

public interface SignUpRepository {
    void signUp(User user);
}
