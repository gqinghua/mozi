//package com.mozi.gateway.config;
//
//import io.swagger.annotations.ApiOperation;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @program: mozi
// * @ClassName SwaggerConfig
// * @description: [用一句话描述此类]
// * @author: GUO
// * @create: 2020-07-10 11:24
// **/
//@Configuration
//@EnableSwagger2
////prefix+name通过application.yml文件配置是否启动swagger在线生成文档
//@ConditionalOnProperty(prefix = "swagger", name = "open", havingValue = "true")
//public class SwaggerConfig {
//    /**
//     * 通过createRestApi函数创建Docket的Bean之后，
//     * apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
//     * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
//     * apis()函数扫描所有Controller中定义的API， 并产生文档内容（除了被@ApiIgnore指定的请求）
//     * @return
//     */
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                /**RequestHandlerSelectors,配置要扫描接口的方式
//                 * 参数说明:
//                 * basePackage:基于包扫描
//                 * class:基于类扫描
//                 * any():扫描全部
//                 * none():全部都不扫描
//                 * withMethodAnnotation:通过方法的注解扫描
//                 * // withMethodAnnotation(GetMapping.class))
//                 * withClassAnnotation:通过类的注解扫描
//                 */
//                //这里采用包含注解的方式来确定要显示的接口(建议使用这种)
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                // .paths()过滤,不扫描哪些接口
//                .paths(PathSelectors.any())
//                .build();
//    }
//    /**
//     * 配置swagger文档显示的相关内容标识(信息会显示到swagger页面)
//     * @return
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("远程测试")
//                .description("测试接口说明")
//                .contact(new Contact("ma", "https://swagger.io/", "945630551@qq.com"))
//                .version("1.0").build();
//    }
//}