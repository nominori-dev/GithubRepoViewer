package com.nominori.githubrepoviewer.application.repository;

import com.nominori.githubrepoviewer.core.user.GithubUser;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepositoryQueryParams {
    private int page = 1;
    private int size = 30;
    private GithubUser user;
}
