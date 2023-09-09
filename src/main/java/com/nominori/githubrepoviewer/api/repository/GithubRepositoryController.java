package com.nominori.githubrepoviewer.api.repository;

import com.nominori.githubrepoviewer.api.repository.converter.GhRepositoryConverter;
import com.nominori.githubrepoviewer.api.repository.dto.GithubRepositoryQueryDto;
import com.nominori.githubrepoviewer.application.repository.GhRepositoryQueryService;
import com.nominori.githubrepoviewer.core.repository.GithubRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/repository")
@RequiredArgsConstructor
public class GithubRepositoryController {

    private final GhRepositoryQueryService ghRepositoryQueryService;
    private final GhRepositoryConverter converter;

    @GetMapping(produces = "application/json")
    public List<GithubRepository> getUserRepositories(@Valid GithubRepositoryQueryDto dto){
        return ghRepositoryQueryService.getUserRepositories(converter.dtoToParams(dto));
    }



}
