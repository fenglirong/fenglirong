package com.example.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.example.hello";
    public static final String VERSION = "1.0.0";

    public Swagger2Configuration() {
    }

    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("Token").description("JwtToken").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        return (new Docket(DocumentationType.SWAGGER_2)).apiInfo(this.apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.example.hello")).paths(PathSelectors.any()).paths(PathSelectors.ant("/v1/**")).build().globalOperationParameters(pars).groupName("JwtToken required Interface");

    }
    @Bean
    public Docket publicApi() {
        return (new Docket(DocumentationType.SWAGGER_2)).apiInfo(this.apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.example.hello")).paths(PathSelectors.any()).paths(PathSelectors.ant("/login")).build().groupName("Login Interface");

    }
    private ApiInfo apiInfo() {
        return (new ApiInfoBuilder()).title("hello Demo").description("API Document").version("1.0.0").build();
    }
}
