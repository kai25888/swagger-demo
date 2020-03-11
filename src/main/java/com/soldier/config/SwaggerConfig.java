package com.soldier.config;

import com.google.common.base.Predicate;
import com.soldier.interfaceDemo.NotIncludeSwagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

/**
 * @Author soldier
 * @Date 2020/3/11 11:42
 * @Version 1.0
 * @Description: Swagger配置
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerDemoApiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.soldier.controller"))
                // 自定义注解设置不需要生成接口文档的方法
//                .apis(not(withMethodAnnotation(NotIncludeSwagger.class)))
                // 设置范围：以/demo/开头的 url 才能被 swagger 生成接口文档
                // 如何希望全部扫描可以使用 paths(PathSelectors.any())
//                .paths(allowPaths())
                .build();
    }

    private ApiInfo swaggerDemoApiInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact("百度", "www.baidu.com", "baidu@163.com"))
                // 标题
                .title("这是Swagger的标题")
                // 描述
                .description("这是Swagger的描述")
                // 版本
                .version("1.0.0")
                .build();
    }

    private Predicate<String> allowPaths() {
        return or(regex("/demo/.*"));
    }
}
