package com.nominori.githubrepoviewer.api.user;

import com.nominori.githubrepoviewer.application.user.GhUserQueryService;
import com.nominori.githubrepoviewer.core.user.GithubUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class GithubUserController {

    private final GhUserQueryService userQueryService;

    @GetMapping("{username}")
    public GithubUser getUserByUsername(@PathVariable String username){
        return userQueryService.getUserByName(username);
    }

}
