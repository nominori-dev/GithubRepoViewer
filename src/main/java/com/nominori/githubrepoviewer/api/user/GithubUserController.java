package com.nominori.githubrepoviewer.api.user;

import com.nominori.githubrepoviewer.application.user.GhUserQueryService;
import com.nominori.githubrepoviewer.core.user.GithubUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
@Tag(name = "User", description = "User API")
public class GithubUserController {

    private final GhUserQueryService userQueryService;

    @Operation(summary = "Get user profile information", tags = "User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "406", description = "No acceptable representation"),
            @ApiResponse(responseCode = "404", description = "User not found."),
    })
    @GetMapping(value = "{username}", produces = "application/json")
    public GithubUser getUserByUsername(@PathVariable String username){
        return userQueryService.getUserByName(username);
    }

}
