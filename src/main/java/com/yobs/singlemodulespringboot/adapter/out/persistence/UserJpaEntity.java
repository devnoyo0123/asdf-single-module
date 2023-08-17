package com.yobs.singlemodulespringboot.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    public UserJpaEntity(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
