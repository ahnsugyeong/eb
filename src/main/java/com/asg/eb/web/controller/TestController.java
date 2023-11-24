package com.asg.eb.web.controller;

import com.asg.eb.api.ApiResponse;
import com.asg.eb.converter.TestConverter;
import com.asg.eb.service.test.TestQueryService;
import com.asg.eb.web.dto.TestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class TestController {

    private final TestQueryService testQueryService;

    @GetMapping
    public ApiResponse<TestResponse.TestDto> testAPI() {
        return ApiResponse.onSuccess(TestConverter.toTestDto());
    }

    @GetMapping("/exception")
    public ApiResponse<TestResponse.TestExceptionDto> exceptionAPI(@RequestParam Integer flag) {
        testQueryService.checkFlag(flag);
        return ApiResponse.onSuccess(TestConverter.toTestExceptionDto(flag));
    }

}
