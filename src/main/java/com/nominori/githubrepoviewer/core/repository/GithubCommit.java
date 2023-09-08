package com.nominori.githubrepoviewer.core.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GithubCommit {
    private String url;
    private String sha;
}
