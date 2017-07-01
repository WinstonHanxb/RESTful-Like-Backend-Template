package com.bupt.util.tools;


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
 * Created by 韩宪斌 on 2017/6/30.
 * swagger2配置文件
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()       .apis(RequestHandlerSelectors.basePackage("com.bupt.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf(){
        return new ApiInfoBuilder()
                //页面标题
                .title("SSM后台API示例")
                //创建人
                .contact(new Contact("WinstonHan","https://github.com/WinstonHanxb","winstonhan@163.com"))
                //版本号
                .version("0.1")
                //描述
                .description("本项目为类RESTful接口的后台框架API")
                .build();

    }
}