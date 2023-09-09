package com.nominori.githubrepoviewer.application.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nominori.githubrepoviewer.api.exception.RateLimitException;
import com.nominori.githubrepoviewer.api.repository.dto.GithubRepositoryQueryDto;
import com.nominori.githubrepoviewer.application.repository.GhBranchesQueryService;
import com.nominori.githubrepoviewer.application.repository.GhRepositoryQueryService;
import com.nominori.githubrepoviewer.application.repository.RepositoryQueryParams;
import com.nominori.githubrepoviewer.application.repository.exception.RepositoryResponseErrorHandler;
import com.nominori.githubrepoviewer.application.user.GhUserQueryService;
import com.nominori.githubrepoviewer.core.repository.GithubRepository;
import com.nominori.githubrepoviewer.core.user.GithubUser;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GhRepositoryQueryServiceImpl implements GhRepositoryQueryService {

    private final GhBranchesQueryService branchesQueryService;
    private final RestTemplate restTemplate;

    private final String GH_REPOS_URL = "https://api.github.com/repos/";

    public GhRepositoryQueryServiceImpl(GhBranchesQueryService branchesQueryService, RestTemplateBuilder restTemplateBuilder) {
        this.branchesQueryService = branchesQueryService;
        this.restTemplate = restTemplateBuilder.errorHandler(new RepositoryResponseErrorHandler()).build();
    }

    @Override
    public List<GithubRepository> getUserRepositories(RepositoryQueryParams params) {
        ResponseEntity<GithubRepository[]> response =
                restTemplate.getForEntity(getRepositoriesUrl(params), GithubRepository[].class);

        return Arrays.stream(response.getBody())
                .filter(ghRepo -> !ghRepo.getIsFork())
                .map(ghRepo -> {
                    String repoUrl = getRepositoryUrl(params.getUser(), ghRepo.getName());
                    ghRepo.setBranches(branchesQueryService.getRepositoryBranches(repoUrl));
                    return ghRepo;
                })
                .toList();
    }

    private String getRepositoriesUrl(RepositoryQueryParams params){
        return MessageFormat.format(params.getUser().getRepositoriesUrl()
                + "?page={0}&per_page={1}", params.getPage(), params.getSize());
    }

    private String getRepositoryUrl(GithubUser user, String repositoryName){
        return GH_REPOS_URL + "/" + user.getLogin() + "/" + repositoryName;
    }

}
