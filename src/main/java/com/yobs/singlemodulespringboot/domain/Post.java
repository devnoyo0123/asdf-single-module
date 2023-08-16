package com.yobs.singlemodulespringboot.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class Post {
    private final Long id;

    private final String title;

    private final String content;


    public static Post withOutId(
            String title,
            String content
    ){
        return new Post(null, title, content);
    }

    public static Post withId(
            Long id,
            String title,
            String content
    ){
        return new Post(id, title, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content);
    }
}
