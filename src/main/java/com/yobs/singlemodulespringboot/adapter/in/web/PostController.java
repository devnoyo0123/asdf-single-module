package com.yobs.singlemodulespringboot.adapter.in.web;

import com.yobs.singlemodulespringboot.adapter.in.web.dto.CreatePostDto;
import com.yobs.singlemodulespringboot.application.port.in.CreatePostCommand;
import com.yobs.singlemodulespringboot.application.port.in.CreatePostUseCase;
import com.yobs.singlemodulespringboot.application.port.in.GetPostQuery;
import com.yobs.singlemodulespringboot.application.port.in.GetPostUseCase;
import com.yobs.singlemodulespringboot.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final CreatePostUseCase createPostUseCase;
    private final GetPostUseCase getPostUseCase;

    @PostMapping("/posts")
    public Post posts(@RequestBody @Valid CreatePostDto createPostDto) {
        var command = new CreatePostCommand(createPostDto.getTitle(), createPostDto.getContent());
        return createPostUseCase.create(command);
    }

    @GetMapping("/posts/{postId}")
    public Post get(@PathVariable(name = "postId")Long id){
        return getPostUseCase.getPost(new GetPostQuery(id));
    }
}
