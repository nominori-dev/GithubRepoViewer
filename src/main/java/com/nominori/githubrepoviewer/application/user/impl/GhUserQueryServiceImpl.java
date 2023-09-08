package com.nominori.githubrepoviewer.application.user.impl;

import com.nominori.githubrepoviewer.api.exception.ResourceNotFoundException;
import com.nominori.githubrepoviewer.application.user.GhUserQueryService;
import com.nominori.githubrepoviewer.core.user.GithubUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GhUserQueryServiceImpl implements GhUserQueryService {

    private final RestTemplate restTemplate;
    private final String GH_USER_ENDPOINT = "https://api.github.com/users/";

    @Override
    public GithubUser getUserByName(String name) {
        ResponseEntity<GithubUser> response =
                restTemplate.getForEntity(GH_USER_ENDPOINT + name, GithubUser.class);

        if(response.getStatusCode() != HttpStatus.OK){
            throw new ResourceNotFoundException("User with provided username not found.");
        }

        return response.getBody();
    }
}
