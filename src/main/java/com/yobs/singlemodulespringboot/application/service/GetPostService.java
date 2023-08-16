package com.yobs.singlemodulespringboot.application.service;

import com.yobs.singlemodulespringboot.application.port.in.GetPostQuery;
import com.yobs.singlemodulespringboot.application.port.in.GetPostUseCase;
import com.yobs.singlemodulespringboot.application.port.out.GetPostRepository;
import com.yobs.singlemodulespringboot.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPostService implements GetPostUseCase {

    private final GetPostRepository getPostRepository;
    @Override
    public Post getPost(GetPostQuery query) {
        return getPostRepository.getPost(query);
    }
}
