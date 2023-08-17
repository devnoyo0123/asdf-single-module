package com.yobs.singlemodulespringboot.adapter.out.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yobs.singlemodulespringboot.application.port.in.GetPostQuery;
import com.yobs.singlemodulespringboot.application.port.in.GetPostsQuery;
import com.yobs.singlemodulespringboot.application.port.out.CreatePostRepository;
import com.yobs.singlemodulespringboot.application.port.out.GetPostRepository;
import com.yobs.singlemodulespringboot.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PostPersistenceAdapter implements CreatePostRepository, GetPostRepository {
    private final JPAQueryFactory jpaQueryFactory;
    private final PostJpaRepository postJpaRepository;
    private final PostMapper postMapper;

    @Override
    public Post create(Post post) {
        var jpaPostEntity = this.postJpaRepository.save(postMapper.mapToJpaEntity(post));
        return postMapper.mapToDomainEntity(jpaPostEntity);
    }


    @Override
    public Post getPost(GetPostQuery query) {
        var jpaPostEntity = this.postJpaRepository.findById(query.getPostId()).orElseThrow(() -> new IllegalArgumentException("잘못된 요청입니다."));
        return postMapper.mapToDomainEntity(jpaPostEntity);
    }

    @Override
    public List<Post> getPosts(GetPostsQuery query) {
        int page = query.getPage();
        long offset = (long) ((page-1)*10);
        long limit = 10L;
        return jpaQueryFactory.selectFrom(QPostJpaEntity.postJpaEntity)
                .limit(limit)
                .orderBy(QPostJpaEntity.postJpaEntity.id.desc())
                .offset(offset)
                .fetch()
                .stream()
                .map(postMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }
}
