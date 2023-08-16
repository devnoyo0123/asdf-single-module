package com.yobs.singlemodulespringboot.application.port.out;

import com.yobs.singlemodulespringboot.application.port.in.GetPostQuery;
import com.yobs.singlemodulespringboot.domain.Post;

public interface GetPostRepository {
    Post getPost(GetPostQuery query);
}
