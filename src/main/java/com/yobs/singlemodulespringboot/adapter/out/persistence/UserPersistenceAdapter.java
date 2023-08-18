package com.yobs.singlemodulespringboot.adapter.out.persistence;

import com.yobs.singlemodulespringboot.application.port.out.SignUpRepository;
import com.yobs.singlemodulespringboot.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements SignUpRepository {


    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public void signUp(User user) {
        var jpaUserEntity = userMapper.mapToJpaEntity(user);
        userJpaRepository.save(jpaUserEntity);
    }
}
