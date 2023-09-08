package com.nominori.githubrepoviewer.core.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GithubRepository {

    private Long id;
    private String name;
    private String fullName;
    private Boolean isFork;
    private Set<GithubRepositoryBranch> branches = new HashSet<>();

}
