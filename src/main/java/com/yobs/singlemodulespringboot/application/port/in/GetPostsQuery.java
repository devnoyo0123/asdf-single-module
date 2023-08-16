package com.yobs.singlemodulespringboot.application.port.in;

import lombok.Getter;

@Getter
public class GetPostsQuery {

    private int page;
    private int size;

    public GetPostsQuery(int page, int size) {
        this.page = page;
        this.size = size;
    }
}
