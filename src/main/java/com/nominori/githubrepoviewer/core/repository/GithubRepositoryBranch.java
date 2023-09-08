package com.nominori.githubrepoviewer.core.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GithubRepositoryBranch {

    private String name;
    private GithubCommit lastCommit;

}
