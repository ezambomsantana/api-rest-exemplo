package com.teste.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket((DocumentationType.SWAGGER_2))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.teste.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "User API",
                "API que controla usuários",
                "API v1",
                "Termos de Serviço",
                new Contact("Eduardo", "www.teste.com", "teste@teste.com"),
                "Lincese", "url", Collections.emptyList());
    }

}
