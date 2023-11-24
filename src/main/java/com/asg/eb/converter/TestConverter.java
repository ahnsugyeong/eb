package com.asg.eb.converter;

import com.asg.eb.web.dto.TestResponse;

public class TestConverter {
    public static TestResponse.TestDto toTestDto() {
        return TestResponse.TestDto.builder()
                .test("Hello World!")
                .build();
    }
}
