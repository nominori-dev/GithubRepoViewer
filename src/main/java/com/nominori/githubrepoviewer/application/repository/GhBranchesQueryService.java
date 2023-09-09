package com.nominori.githubrepoviewer.application.repository;

import com.nominori.githubrepoviewer.core.repository.GithubRepositoryBranch;

import java.util.Set;

public interface GhBranchesQueryService {
    Set<GithubRepositoryBranch> getRepositoryBranches(String repositoryUrl);
}
