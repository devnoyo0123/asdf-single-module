package com.yobs.singlemodulespringboot.adapter.out.persistence;

import com.yobs.singlemodulespringboot.application.port.in.GetPostQuery;
import com.yobs.singlemodulespringboot.application.port.out.CreatePostRepository;
import com.yobs.singlemodulespringboot.application.port.out.GetPostRepository;
import com.yobs.singlemodulespringboot.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostPersistenceAdapter implements CreatePostRepository, GetPostRepository {


    private final JpaPostRepository jpaPostRepository;
    private final PostMapper postMapper;

    @Override
    public Post create(Post post) {
        var jpaPostEntity = this.jpaPostRepository.save(postMapper.mapToJpaEntity(post));
        return postMapper.mapToDomainEntity(jpaPostEntity);
    }


    @Override
    public Post getPost(GetPostQuery query) {
        var jpaPostEntity = this.jpaPostRepository.findById(query.getPostId()).orElseThrow(() -> new IllegalArgumentException("잘못된 요청입니다."));
        return postMapper.mapToDomainEntity(jpaPostEntity);
    }
}
