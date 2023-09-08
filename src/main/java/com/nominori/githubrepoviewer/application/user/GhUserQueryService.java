package com.nominori.githubrepoviewer.application.user;

import com.nominori.githubrepoviewer.core.user.GithubUser;

public interface GhUserQueryService {
    GithubUser getUserByName(String name);
}
