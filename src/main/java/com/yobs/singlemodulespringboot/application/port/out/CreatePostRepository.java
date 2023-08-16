package com.yobs.singlemodulespringboot.application.port.out;

import com.yobs.singlemodulespringboot.adapter.out.persistence.PostJpaEntity;
import com.yobs.singlemodulespringboot.domain.Post;

import java.util.Optional;

public interface CreatePostRepository {
    public Post create(Post post);

}
