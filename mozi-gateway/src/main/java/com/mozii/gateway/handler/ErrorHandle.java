package com.mozii.gateway.handler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mozi
 * @ClassName ErrorHandle
 * @description: [用一句话描述此类]
 * @author: GUO
 * @create: 2020-07-09 22:20
 **/
@RestController
public class ErrorHandle {

    @RequestMapping("/default-error")
    public String DefaultErrorHandle(){
        return "这是通用错误处理返回的信息。";
    }

    @RequestMapping("/service-provider-error")
    public String ServiceProviderErrorHandle(){
        return "这是ServiceProvider服务专属的错误处理信息。";
    }
}