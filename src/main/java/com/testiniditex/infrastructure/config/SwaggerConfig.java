package com.testiniditex.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product Sorting API")
                        .version("1.0")
                        .description("API REST que ordena productos por criterios ponderados como ventas y stock disponible.")
                        .contact(new Contact()
                                .name("Enrique Navarro")
                                .email("enrique.navarro@example.com")
                        )
                );
    }
}
