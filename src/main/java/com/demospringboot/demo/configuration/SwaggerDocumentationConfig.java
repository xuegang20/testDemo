package com.demospringboot.demo.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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

    private String chag(String result) {
        String c = null;
        try {
            c = new String(result.getBytes("ISO-8859-1"), "utf-8");
        } catch (Exception e) {
        }
        return c;
    }

    //ApiInfo apiInfo() {
    //    return new ApiInfoBuilder()
    //            .title(chag(appName))
    //            .description(chag(appDesc))
    //            .license(chag(license))
    //            .licenseUrl(chag(licenseUrl))
    //            .termsOfServiceUrl(chag(termsOfServiceUrl))
    //            .version(chag(appVersion))
    //            .contact(new Contact(chag(contactName), chag(contactUrl), chag(contactEmail)))
    //            .build();
    //}
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(appName)
                .description(appDesc)
                .license(license)
                .licenseUrl(licenseUrl)
                .termsOfServiceUrl(termsOfServiceUrl)
                .version(appVersion)
                .contact(new Contact(contactName, contactUrl, contactEmail))
                .build();
    }


    /**
     * @return
     */
    //@Bean
    //public Docket customImplementation() {
    //    return new Docket(DocumentationType.SWAGGER_2)
    //            .select()
    //            .apis(RequestHandlerSelectors.basePackage("com.demospringboot.demo.controller"))
    //            .build().apiInfo(apiInfo());
    //}

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demospringboot.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }


}
