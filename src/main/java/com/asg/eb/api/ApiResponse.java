package com.asg.eb.api;

import com.asg.eb.api.code.BaseCode;
import com.asg.eb.api.code.SuccessStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    private final Boolean isSuccess;
    private final Integer code;
    private final String message;
    private T result;

    public static <T> ApiResponse<T> onSuccess(T result) {
        return new ApiResponse<>(true, 2000, SuccessStatus._SUCCESS.getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result) {
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(), result);
    }

    public static <T> ApiResponse<T> onFailure(Integer code, String message, T data){
        return new ApiResponse<>(true, code, message, data);
    }

}
