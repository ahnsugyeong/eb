package com.asg.eb.web.controller;

import com.asg.eb.api.ApiResponse;
import com.asg.eb.converter.TestConverter;
import com.asg.eb.web.dto.TestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping
    public ApiResponse<TestResponse.TestDto> testAPI() {
        return ApiResponse.onSuccess(TestConverter.toTestDto());
    }
}
