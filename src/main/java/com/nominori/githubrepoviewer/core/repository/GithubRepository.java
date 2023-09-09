package com.nominori.githubrepoviewer.core.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepository {

    private String name;

    @JsonProperty("owner.login")
    private String owner;


    @JsonProperty("fork")
    private Boolean isFork;


    private Set<GithubRepositoryBranch> branches = new HashSet<>();



}
