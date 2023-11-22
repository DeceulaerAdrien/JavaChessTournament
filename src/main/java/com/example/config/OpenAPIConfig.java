package com.example.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig
{

//    @Bean
//    public OpenAPI custumOpenApi(){
//        final String securityShemeName = "bearerAuth";
//        return new OpenAPI()
//                .addSecurityItem(new SecurityRequirement().addList(securityShemeName))
//                .components(new Components().addSecuritySchemes(securityShemeName,new SecurityScheme()
//                        .name(securityShemeName)
//                        .type(securityShemeName.Type.HTTP)
//                        .scheme("bearer")
//                        .bearerFormat("JWT")
//                ));
//    }
}
