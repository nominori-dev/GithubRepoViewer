package com.nominori.githubrepoviewer.infrastructure;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "GithubRepoViewer",
                description = "REST API for fetching information about GitHub users repositories.",
                contact = @Contact(
                        name = "nominori-dev",
                        url = "https://github.com/nominori-dev",
                        email = "a.shymchyts@gmail.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://github.com/nominori-dev/GithubRepoViewer/LICENSE"
                )
        )
)
public class OpenAPIConfiguration {
}
