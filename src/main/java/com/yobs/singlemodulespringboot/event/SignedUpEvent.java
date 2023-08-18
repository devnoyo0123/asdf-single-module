package com.yobs.singlemodulespringboot.event;

import com.yobs.singlemodulespringboot.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class SignedUpEvent {
    private final User user;
}
