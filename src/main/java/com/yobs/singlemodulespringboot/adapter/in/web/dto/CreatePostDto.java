package com.yobs.singlemodulespringboot.adapter.in.web.dto;


import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreatePostDto {

    @NotBlank(message = "타이틀을 입력해주세요.")
    public String title;
    @NotBlank(message = "내용을 입력해주세요.")
    public String content;

    public CreatePostDto() {
    }

    public CreatePostDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "CreatePostDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
