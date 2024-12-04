package com.example.lab112.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class ApiResponse {
    private String message;
    public ApiResponse(String message) {
        this.message = message;
    }

}
