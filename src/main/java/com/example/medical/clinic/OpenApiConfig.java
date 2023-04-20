package com.example.medical.clinic;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Medical Clinic")
                        .description("Manage your medical appointments through this API")
                        .version("2.0")).components(
                        new Components().addSecuritySchemes(
                                "api",
                                new SecurityScheme()
                                        .scheme("bearer")
                                        .type(SecurityScheme.Type.HTTP)
                                        .in(SecurityScheme.In.HEADER)
                                        .bearerFormat("jwt")
                                        .name("api")
                        )
                );
    }
}
