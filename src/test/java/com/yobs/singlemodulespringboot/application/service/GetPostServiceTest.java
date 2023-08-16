package com.yobs.singlemodulespringboot.application.service;

import com.yobs.singlemodulespringboot.application.port.in.CreatePostCommand;
import com.yobs.singlemodulespringboot.application.port.in.GetPostQuery;
import com.yobs.singlemodulespringboot.application.port.out.CreatePostRepository;
import com.yobs.singlemodulespringboot.application.port.out.GetPostRepository;
import com.yobs.singlemodulespringboot.domain.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GetPostServiceTest {

    @Autowired
    private CreatePostRepository createPostRepository;

    @Autowired
    private GetPostRepository getPostRepository;


    @Test
    @DisplayName("Post 1개 조회")
    void test() {

        //given
        var createPostCommand = new CreatePostCommand("제목", "내용");
        var post = Post.withOutId(createPostCommand.getTitle(), createPostCommand.getContent());
        var createdPost = this.createPostRepository.create(post);

        // when
        var getPost = this.getPostRepository.getPost(new GetPostQuery(createdPost.getId()));

        // then
        assertNotNull(getPost);
        assertEquals(createdPost.getTitle(),getPost.getTitle());
        assertEquals(createdPost.getContent(),getPost.getContent());

    }
}