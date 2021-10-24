package com.efutures.sample_product_app.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("api").apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/api/products.*"), regex("/api/category.*"));
    }

    private Predicate<String> or(Object regex, Object regex1) {
        Predicate<String> pred = new Predicate<String>() {
            @Override
            public boolean apply(String s) {
                return false;
            }
        };
        return pred;
    }

    private Object regex(String s) {
        return s;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Sample Product Api")
                .description("Product , Category , Comments API reference for developers")
                .termsOfServiceUrl("http://javainuse.com")
                .contact("javainuse@gmail.com").license("JavaInUse License")
                .licenseUrl("javainuse@gmail.com").version("1.0").build();
    }
}
