package com.example.airlineproject.utils;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExceptionApiResponse {

    private boolean isSuccessful;
    private Object data;
}
