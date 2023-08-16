package com.yobs.singlemodulespringboot.application.service;

import com.yobs.singlemodulespringboot.application.port.in.CreatePostCommand;
import com.yobs.singlemodulespringboot.application.port.in.CreatePostUseCase;
import com.yobs.singlemodulespringboot.application.port.out.CreatePostRepository;
import com.yobs.singlemodulespringboot.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreatePostService implements CreatePostUseCase {

    private final CreatePostRepository createPostRepository;
    @Override
    public Post create(CreatePostCommand command) {

        var post = Post.withOutId(command.getTitle(), command.getContent());
        return this.createPostRepository.create(post);
    }
}
