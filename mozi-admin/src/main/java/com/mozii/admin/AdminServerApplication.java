package com.mozii.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: mozi
 * @ClassName AdminServerApplication
 * @description: [用一句话描述此类]
 * @author: GUO
 * @create: 2020-07-06 14:00
 **/
@SpringBootApplication
@EnableAdminServer
public class AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run( AdminServerApplication.class, args );
    }

}
