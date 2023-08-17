package com.yobs.singlemodulespringboot.adapter.out.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yobs.singlemodulespringboot.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserJpaRepositoryImpl implements UserJpaRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final UserMapper userMapper;

    @Override
    public User findByEmail(String email) {
        var userJpaEntity = jpaQueryFactory.selectFrom(QUserJpaEntity.userJpaEntity)
                .where(QUserJpaEntity.userJpaEntity.email.eq(email))
                .fetchOne();
        return userMapper.mapToDomainEntity(userJpaEntity);
    }
}
