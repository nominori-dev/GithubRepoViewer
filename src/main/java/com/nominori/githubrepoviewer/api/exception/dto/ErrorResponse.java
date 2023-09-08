package com.nominori.githubrepoviewer.api.exception.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ErrorResponse {

    private String message;
    private String timestamp;

    public ErrorResponse(String message) {
        this.message = message;
        this.timestamp = Instant.now().toString();
    }
}
