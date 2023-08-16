package com.yobs.singlemodulespringboot.application.port.in;

import lombok.Getter;

@Getter
public class GetPostQuery {

    private Long postId;

    public GetPostQuery(Long postId) {
        this.postId = postId;
    }
}
