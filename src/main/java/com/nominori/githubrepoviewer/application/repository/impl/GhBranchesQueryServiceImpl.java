package com.nominori.githubrepoviewer.application.repository.impl;

import com.nominori.githubrepoviewer.api.exception.ResourceNotFoundException;
import com.nominori.githubrepoviewer.application.repository.GhBranchesQueryService;
import com.nominori.githubrepoviewer.application.repository.exception.RepositoryResponseErrorHandler;
import com.nominori.githubrepoviewer.core.repository.GithubRepositoryBranch;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class GhBranchesQueryServiceImpl implements GhBranchesQueryService {

    private final RestTemplate restTemplate;

    public GhBranchesQueryServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.errorHandler(new RepositoryResponseErrorHandler()).build();
    }

    @Override
    public Set<GithubRepositoryBranch> getRepositoryBranches(String repositoryUrl) {
        ResponseEntity<GithubRepositoryBranch[]> response =
                restTemplate.getForEntity(repositoryUrl + "/branches", GithubRepositoryBranch[].class);

        if(response.getStatusCode() != HttpStatus.OK || response.getBody() == null){
            throw new ResourceNotFoundException("Branches for provided repository not found.");
        }

        return new HashSet<>(Arrays.asList(response.getBody()));
    }
}
