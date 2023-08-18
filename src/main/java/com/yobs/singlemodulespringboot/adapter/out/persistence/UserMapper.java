package com.yobs.singlemodulespringboot.adapter.out.persistence;

import com.yobs.singlemodulespringboot.domain.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMapper {
    public UserJpaEntity mapToJpaEntity(User user) {
        return new UserJpaEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public Optional<User> mapToDomainEntity(UserJpaEntity userJpaEntity) {
        if(userJpaEntity == null) {
            return Optional.empty();
        }
        return  Optional.of(new User(userJpaEntity.getId(),userJpaEntity.getEmail(), userJpaEntity.getPassword()));
    }
}
