package com.yobs.singlemodulespringboot.adapter.out.persistence;

import com.yobs.singlemodulespringboot.domain.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post mapToDomainEntity(PostJpaEntity postJpaEntity){
        return new Post(
                postJpaEntity.getId(),
                postJpaEntity.getTitle(),
                postJpaEntity.getContent()
        );
    }

    public PostJpaEntity mapToJpaEntity(Post post){
        return new PostJpaEntity(post.getId(), post.getTitle(), post.getContent());
    }
}
