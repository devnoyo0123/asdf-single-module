package com.yobs.singlemodulespringboot.adapter.out.persistence;

import com.yobs.singlemodulespringboot.domain.User;

import java.util.Optional;

public interface UserJpaRepositoryCustom {

    public Optional<User> findByEmail(String email);
}
