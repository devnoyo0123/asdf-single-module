package com.yobs.singlemodulespringboot.application.port.in;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreatePostCommand {
    private final String title;
    private final String content;
}
