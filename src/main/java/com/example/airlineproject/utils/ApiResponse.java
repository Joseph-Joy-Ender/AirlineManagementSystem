package com.example.airlineproject.utils;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ApiResponse {
    private HttpStatus httpStatus;
    private boolean isSuccessful;
    private Object data;
}
