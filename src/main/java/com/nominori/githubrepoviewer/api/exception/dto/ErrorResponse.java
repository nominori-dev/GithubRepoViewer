package com.nominori.githubrepoviewer.api.exception.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    @JsonProperty("status")
    private int httpCode;
    @JsonProperty("Message")
    private String message;

}
