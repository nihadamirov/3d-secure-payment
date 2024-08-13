package com.securepayment.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("3D-Secure-Payment")
                        .version("0.0.1")
                        .description("A Payment Processing System")
                        .contact(new Contact()
                                .url("/api/**")
                                .url("/v3/api-docs/**")
                                .url("/swagger-ui/**")
                                .name("3D-Secure-Payment")));

    }

}
