package com.asg.eb.web.controller;

import com.asg.eb.api.ApiResponse;
import com.asg.eb.converter.TestConverter;
import com.asg.eb.service.test.TestQueryService;
import com.asg.eb.web.dto.TestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Test API", description = "테스트용 API")
@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
public class TestController {

    private final TestQueryService testQueryService;

    @GetMapping
    public ApiResponse<TestResponse.TestDto> testAPI() {
        return ApiResponse.onSuccess(TestConverter.toTestDto());
    }

    @Operation(summary = "Exception Test", description = "파라미터로 받은 정수가 1이면 Exception.")
    @Parameter(name = "flag", description = "정수 값")
    @GetMapping("/exception")
    public ApiResponse<TestResponse.TestExceptionDto> exceptionAPI(@RequestParam Integer flag) {
        testQueryService.checkFlag(flag);
        return ApiResponse.onSuccess(TestConverter.toTestExceptionDto(flag));
    }

}
