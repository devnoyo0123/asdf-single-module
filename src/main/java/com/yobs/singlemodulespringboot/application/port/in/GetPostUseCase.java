package com.yobs.singlemodulespringboot.application.port.in;

import com.yobs.singlemodulespringboot.domain.Post;

public interface GetPostUseCase {
    public Post getPost(GetPostQuery query);
}
