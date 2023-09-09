package com.nominori.githubrepoviewer.application.user.impl;

import com.nominori.githubrepoviewer.application.user.GhUserQueryService;
import com.nominori.githubrepoviewer.application.user.exception.UserResponseErrorHandler;
import com.nominori.githubrepoviewer.core.user.GithubUser;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GhUserQueryServiceImpl implements GhUserQueryService {

    private final RestTemplate restTemplate;
    private final String GH_USER_ENDPOINT = "https://api.github.com/users/";


    public GhUserQueryServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.errorHandler(new UserResponseErrorHandler()).build();
    }

    @Override
    public GithubUser getUserByName(String name) {
        ResponseEntity<GithubUser> response =
                restTemplate.getForEntity(GH_USER_ENDPOINT + name, GithubUser.class);

        return response.getBody();
    }
}
