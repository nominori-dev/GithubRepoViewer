package com.nominori.githubrepoviewer.api.repository;

import com.nominori.githubrepoviewer.api.repository.converter.GhRepositoryConverter;
import com.nominori.githubrepoviewer.api.repository.dto.GithubRepositoryQueryDto;
import com.nominori.githubrepoviewer.application.repository.GhRepositoryQueryService;
import com.nominori.githubrepoviewer.core.repository.GithubRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/repository")
@RequiredArgsConstructor
@Tag(name = "Repository", description = "Repository API")
public class GithubRepositoryController {

    private final GhRepositoryQueryService ghRepositoryQueryService;
    private final GhRepositoryConverter converter;

    @Operation(summary = "Get user non-fork repositories by username(login).", description = "This endpoint uses pagination. By default pagination is 30 repositories per page.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful."),
            @ApiResponse(responseCode = "406", description = "No acceptable representation"),
            @ApiResponse(responseCode = "404", description = "User not found."),
            @ApiResponse(responseCode = "400", description = "Username validation is failed.")
    })
    @GetMapping(produces = "application/json")
    public List<GithubRepository> getUserRepositories(@Valid GithubRepositoryQueryDto dto){
        return ghRepositoryQueryService.getUserRepositories(converter.dtoToParams(dto));
    }



}
