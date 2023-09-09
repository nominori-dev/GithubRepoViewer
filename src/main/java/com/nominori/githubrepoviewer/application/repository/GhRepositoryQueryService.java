package com.nominori.githubrepoviewer.application.repository;

import com.nominori.githubrepoviewer.core.repository.GithubRepository;

import java.util.List;

public interface GhRepositoryQueryService {

    List<GithubRepository> getUserRepositories(RepositoryQueryParams params);

}
