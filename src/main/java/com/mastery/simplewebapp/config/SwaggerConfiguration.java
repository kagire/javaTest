package com.mastery.simplewebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;

@Configuration
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        final ArrayList<Response> getResponseMessages = new ArrayList<>(),
                postResponseMessages  = new ArrayList<>(),
                putResponseMessages  = new ArrayList<>(),
                deleteResponseMessages = new ArrayList<>();
        getResponseMessages.add(new ResponseBuilder()
                .code("200")
                .description("Employee successfully returned")
                .build());
        getResponseMessages.add(new ResponseBuilder()
                .code("404")
                .description("Cant get data")
                .build());
        postResponseMessages.add(new ResponseBuilder()
                .code("404")
                .description("Cant get data")
                .build());
        postResponseMessages.add(new ResponseBuilder()
                .code("400")
                .description("Provided data is invalid")
                .build());
        postResponseMessages.add(new ResponseBuilder()
                .code("201")
                .description("Employee created")
                .build());
        putResponseMessages.add(new ResponseBuilder()
                .code("404")
                .description("Cant get data")
                .build());
        putResponseMessages.add(new ResponseBuilder()
                .code("400")
                .description("Provided data is invalid")
                .build());
        deleteResponseMessages.add(new ResponseBuilder()
                .code("200")
                .description("Employee deleted")
                .build());
        deleteResponseMessages.add(new ResponseBuilder()
                .code("404")
                .description("Cant get data")
                .build());
        deleteResponseMessages.add(new ResponseBuilder()
                .code("400")
                .description("Provided data is invalid")
                .build());
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.GET,getResponseMessages)
                .globalResponses(HttpMethod.PUT,putResponseMessages)
                .globalResponses(HttpMethod.POST,postResponseMessages)
                .globalResponses(HttpMethod.DELETE,deleteResponseMessages);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Simple web app",
                "For check.",
                "0.1",
                "Terms of service",
                new Contact("Roma", "www.no.com", "da@gmail.com"),
                "licence", "cho-to tam", Collections.emptyList());
    }
}
