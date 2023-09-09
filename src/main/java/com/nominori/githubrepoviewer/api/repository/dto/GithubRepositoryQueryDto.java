package com.nominori.githubrepoviewer.api.repository.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 0, max = 39)
    private String username;

}


