package com.yobs.singlemodulespringboot.adapter.in.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {

    private final String code;
    private final String message;

    private final Map<String, String> validation = new HashMap<>();


    public void addValidation(String fieldName, String message) {
        validation.put(fieldName, message);
    }
}
