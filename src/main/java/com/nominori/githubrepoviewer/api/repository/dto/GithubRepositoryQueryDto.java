package com.nominori.githubrepoviewer.api.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GithubRepositoryQueryDto {

    private int page = 1;
    private int size = 30;
    private String username;

}


