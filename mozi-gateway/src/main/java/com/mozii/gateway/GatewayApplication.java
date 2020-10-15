package com.mozii.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: mozi
 * @ClassName GatewayApplication
 * @description: [用一句话描述此类]
 * @author: GUO
 * @create: 2020-07-05 20:59
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}