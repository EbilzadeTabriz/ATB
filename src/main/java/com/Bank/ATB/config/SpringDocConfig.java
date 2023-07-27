package com.Bank.ATB.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SpringDocConfig {
    @Bean
    public OpenAPI openAPI(){
        return  new OpenAPI().info(
                new Info()
                        .title("Created by Kenan")
                        .version("0.0.1")
                        .description("For Bank procces")
                        .contact(
                                new Contact()
                                        .url("www.Bank.com")
                                        .email("ebilovKenan99@gmail.com")
                                        .name("Kenan Ebilov")
                        )

        );

    }


}
