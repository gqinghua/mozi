//package com.mozi.gateway.config;
//
//import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @program: mozi
// * @ClassName HystrixConfig
// * @description: [用一句话描述此类]
// * @author: GUO
// * @create: 2020-07-09 14:59
// **/
//@Configuration
//public class HystrixConfig {
//
//    @Bean
//    public HystrixCommandAspect hystrixCommandAspect() {
//        return new HystrixCommandAspect();
//    }
//
//    /**
//     * 向监控中心Dashboard发送stream消息
//     */
//    @Bean
//    public ServletRegistrationBean hystrixMetricsStreamServlet() {
//        ServletRegistrationBean registrationBean =
//                new ServletRegistrationBean();
//        registrationBean.addUrlMappings("/hystrix.stream");
//        return registrationBean;
//    }
//}
