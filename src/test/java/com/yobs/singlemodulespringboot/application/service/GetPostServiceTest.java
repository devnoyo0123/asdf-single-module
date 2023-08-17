package com.yobs.singlemodulespringboot.application.service;

import com.yobs.singlemodulespringboot.adapter.out.persistence.PostJpaRepository;
import com.yobs.singlemodulespringboot.adapter.out.persistence.PostJpaEntity;
import com.yobs.singlemodulespringboot.application.port.in.CreatePostCommand;
import com.yobs.singlemodulespringboot.application.port.in.GetPostQuery;
import com.yobs.singlemodulespringboot.application.port.in.GetPostsQuery;
import com.yobs.singlemodulespringboot.application.port.out.CreatePostRepository;
import com.yobs.singlemodulespringboot.application.port.out.GetPostRepository;
import com.yobs.singlemodulespringboot.domain.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GetPostServiceTest {

    @Autowired
    private CreatePostRepository createPostRepository;

    @Autowired
    private GetPostRepository getPostRepository;

    @Autowired
    private PostJpaRepository postJpaRepository;


    @BeforeEach
    void clean() {
        this.postJpaRepository.deleteAll();
    }


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

    @Test
    @DisplayName("Post 페이징 조회")
    void test2() {

        //given

        List<PostJpaEntity> requestPosts = IntStream.range(0,20)
                .mapToObj(i -> new PostJpaEntity(null, "foo"+i, "bar"+i))
                .collect(Collectors.toList());

        postJpaRepository.saveAll(requestPosts);

        // when
        var getPosts = this.getPostRepository.getPosts(new GetPostsQuery(1, 10));

        // then
        assertNotNull(getPosts);
        assertEquals(getPosts.get(0).getTitle(), requestPosts.get(requestPosts.size()-1).getTitle());

    }
}