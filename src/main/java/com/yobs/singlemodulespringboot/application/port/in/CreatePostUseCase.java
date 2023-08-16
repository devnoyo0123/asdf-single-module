package com.yobs.singlemodulespringboot.application.port.in;

import com.yobs.singlemodulespringboot.domain.Post;

public interface CreatePostUseCase {
    public Post create(CreatePostCommand command);
}
