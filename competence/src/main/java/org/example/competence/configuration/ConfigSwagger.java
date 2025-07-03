package org.example.competence.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Competence API", version = "v1", description = "API for managing competences and sub-competences"))
public class ConfigSwagger {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("competence-api")
                .pathsToMatch("/api/v1/**")
                .packagesToScan("org.example.competence.controller")
                .build();
    }
}