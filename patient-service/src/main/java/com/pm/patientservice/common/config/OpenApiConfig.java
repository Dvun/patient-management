package com.pm.patientservice.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {

            License mitLicense = new License().name("MIT License");

            Info info = new Info()
                    .title("Patient Service API")
                    .version("1.0")
                    .description("Patient Service API")
                    .license(mitLicense);

            return new OpenAPI().info(info);
    }

}
