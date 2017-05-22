package com.janita.log.config;

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
 * @author Janita
 * create on 2017/3/4
 * 使用swagger来管理restful接口文档
 *
 * http://localhost:9001/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String API_PACKAGE= "com.janita.log.controller";
	private static final String TITLE = "log-aop";
	private static final String DESC = "log-aop";
	
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(API_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESC)
                .termsOfServiceUrl("")
                .contact(new Contact("janita", "www.janita.cn/", ""))
                .version("v1")
                .build();
    }
}
