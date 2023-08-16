package com.yobs.singlemodulespringboot.application.port.out;

import com.yobs.singlemodulespringboot.application.port.in.GetPostQuery;
import com.yobs.singlemodulespringboot.application.port.in.GetPostsQuery;
import com.yobs.singlemodulespringboot.domain.Post;

import java.util.List;

public interface GetPostRepository {
    Post getPost(GetPostQuery query);

    List<Post> getPosts(GetPostsQuery query);
}
