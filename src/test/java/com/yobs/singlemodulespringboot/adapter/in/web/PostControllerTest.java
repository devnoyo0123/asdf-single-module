package com.yobs.singlemodulespringboot.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yobs.singlemodulespringboot.adapter.in.web.dto.CreatePostDto;
import com.yobs.singlemodulespringboot.adapter.out.persistence.JpaPostRepository;
import com.yobs.singlemodulespringboot.application.port.out.CreatePostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CreatePostRepository createPostRepository;

    @Autowired
    private JpaPostRepository jpaPostRepository;

    @BeforeEach
    void clean() {
        jpaPostRepository.deleteAll();
    }


    @Test
    @DisplayName("/posts 요청시 title은 필수값이다.")
    void test2() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        CreatePostDto createPostDto = new CreatePostDto("", "내용");
        mockMvc.perform(MockMvcRequestBuilders.post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPostDto)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.validation.title").value("타이틀을 입력해주세요."))
                .andDo(print());
    }

    @Test
    @DisplayName("/posts 요청시 DB에 값이 저장된다.")
    void test3() throws Exception {

        // given
        ObjectMapper objectMapper = new ObjectMapper();
        CreatePostDto createPostDto = new CreatePostDto("제목", "내용");

        // when
        mockMvc.perform(MockMvcRequestBuilders.post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createPostDto)))
                .andExpect(status().isOk())
                .andDo(print());

        // then
        assertEquals(1L, jpaPostRepository.count());

    }
}