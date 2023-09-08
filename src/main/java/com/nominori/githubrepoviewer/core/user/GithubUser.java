package com.nominori.githubrepoviewer.core.user;

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
    private String avatarUrl;
    private String repositoriesUrl;

}
