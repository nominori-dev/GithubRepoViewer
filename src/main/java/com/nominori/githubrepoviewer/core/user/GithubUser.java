package com.nominori.githubrepoviewer.core.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GithubUser {

    private Long id;
    private String login;
    private String name;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("repos_url")
    private String repositoriesUrl;

}
