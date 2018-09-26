package com.demospringboot.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.ant;

/**
 * @Description swagger控制
 * @Author xg
 * @Date 2018/9/17 16:14
 */

@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {

    @Value("${app.key}")
    private String appKey;
    @Value("${app.name}")
    private String appName;
    @Value("${app.desc}")
    private String appDesc;
    @Value("${app.version}")
    private String appVersion;
    @Value("${app.termsOfServiceUrl}")
    private String termsOfServiceUrl;
    @Value("${app.contact.name}")
    private String contactName;
    @Value("${app.contact.url}")
    private String contactUrl;
    @Value("${app.contact.email}")
    private String contactEmail;
    @Value("${app.license}")
    private String license;
    @Value("${app.licenseUrl}")
    private String licenseUrl;

    @Value("${security.userOauth.clientId}")
    private String authClientId;

    @Value("${security.userOauth.clientSecret}")
    private String authClientSecret;

    @Value("${security.userOauth.type}")
    private String type;

    @Value("${security.userOauth.authorizationUrl}")
    private String authorizationUrl;

    @Value("${security.userOauth.tokenUrl}")
    private String tokenUrl;

    @Value("${security.userOauth.tokenName}")
    private String tokenName;

    @Value("${security.userOauth.scope.code}")
    private String scopeCode;

    @Value("${security.userOauth.scope.desc}")
    private String scopeDesc;


    //private String chag(String result) {
    //    String c = null;
    //    try {
    //        c = new String(result.getBytes("ISO-8859-1"), "utf-8");
    //    } catch (Exception e) {
    //    }
    //    return c;
    //}
    //
    //ApiInfo apiInfo() {
    //    return new ApiInfoBuilder()
    //            .title(appName)
    //            .description(appDesc)
    //            .license(license)
    //            .licenseUrl(licenseUrl)
    //            .termsOfServiceUrl(termsOfServiceUrl)
    //            .version(appVersion)
    //            .contact(new Contact(contactName, contactUrl, contactEmail))
    //            .build();
    //}
    //
    //
    //@Bean
    //public Docket createRestApi() {
    //    return new Docket(DocumentationType.SWAGGER_2)
    //            .apiInfo(apiInfo())
    //            .select()
    //            .apis(RequestHandlerSelectors.basePackage("com.demospringboot.controller"))
    //            .paths(PathSelectors.any())
    //            .build();
    //}

    /**
     * Api分组，可以定义多个组
     */
    @Bean
    public Docket jackApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("jack")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demospringboot.controller"))
                .build()
                .securitySchemes(newArrayList(oauth()))
                .securityContexts(newArrayList(securityContext()))
                .apiInfo(jyxApiInfo());
    }

    private ApiInfo jyxApiInfo() {
        ApiInfo apiInfo = new ApiInfo(appName, appDesc, appVersion, termsOfServiceUrl,
                new Contact(contactName, contactUrl, contactEmail),
                license, licenseUrl);


        return apiInfo;
    }

    @Bean
    SecurityScheme apiKey() {
        return new ApiKey(appName, appKey, "header");
    }


    @Bean
    SecurityContext securityContext() {
        AuthorizationScope[] scopes = new AuthorizationScope[]{new AuthorizationScope(scopeCode, scopeDesc)};

        SecurityReference securityReference = SecurityReference
                .builder()
                .reference(type)
                .scopes(scopes)
                .build();


        return SecurityContext
                .builder()
                .securityReferences(newArrayList(securityReference))
                .forPaths(ant("/api/**"))
                .build();
    }

    @Bean
    SecurityScheme oauth() {
        return new OAuthBuilder()
                .name(type)
                .grantTypes(grantTypes())
                .scopes(scopes())
                .build();
    }

    List<AuthorizationScope> scopes() {
        return newArrayList(new AuthorizationScope(scopeCode, scopeDesc));
    }

    List<GrantType> grantTypes() {
        List<GrantType> grants = newArrayList(new AuthorizationCodeGrant(
                new TokenRequestEndpoint(authorizationUrl, authClientId, authClientSecret),
                new TokenEndpoint(tokenUrl, tokenName)));
        return grants;
    }

    @Bean
    public SecurityConfiguration securityInfo() {
        return new SecurityConfiguration(authClientId, authClientSecret, scopeCode,
                appKey, appKey, ApiKeyVehicle.HEADER, "", ",");
    }


}
