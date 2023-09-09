package com.nominori.githubrepoviewer.application.repository.exception;

import com.nominori.githubrepoviewer.api.exception.RateLimitException;
import com.nominori.githubrepoviewer.api.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RepositoryResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return (httpResponse.getStatusCode().is4xxClientError() || httpResponse.getStatusCode().is5xxServerError());
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if(response.getStatusCode().is4xxClientError()){
            if(response.getStatusCode() == HttpStatus.NOT_FOUND){
                throw new ResourceNotFoundException("Repository or branch not found.");
            }
            if(response.getStatusCode().is4xxClientError()){
                throw new RateLimitException("Rate limit exceed. Try later.");
            }
        }
    }
}
