package com.pm.patientservice.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Map;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime timestamp;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private int status;

    @JsonFormat(shape = JsonFormat.Shape.ANY)
    private T content;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String error;

    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    private Map<String, String> errors;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String path;


    public static <T> ApiResponse<T> success(T content) {
        return ApiResponse.<T>builder()
                .timestamp(OffsetDateTime.now())
                .status(HttpStatus.OK.value())
                .content(content)
                .build();
    }

    public static ApiResponse<Object> failure(HttpStatus status, Map<String, String> errors, String message, String path) {
        return ApiResponse.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .content(new ArrayList<>())
                .errors(errors.isEmpty() ? null : errors)
                .error(message)
                .path(path)
                .build();
    }
}
