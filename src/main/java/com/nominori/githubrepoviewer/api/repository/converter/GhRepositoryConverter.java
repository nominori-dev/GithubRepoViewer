package com.nominori.githubrepoviewer.api.repository.converter;

import com.nominori.githubrepoviewer.api.repository.dto.GithubRepositoryQueryDto;
import com.nominori.githubrepoviewer.application.repository.RepositoryQueryParams;
import com.nominori.githubrepoviewer.application.user.GhUserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GhRepositoryConverter {

    private final GhUserQueryService userQueryService;

    public RepositoryQueryParams dtoToParams(GithubRepositoryQueryDto dto){
        return RepositoryQueryParams.builder()
                .size(dto.getSize())
                .page(dto.getPage())
                .user(userQueryService.getUserByName(dto.getUsername()))
                .build();
    }


}
