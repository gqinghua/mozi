package com.mozi.NacosConsumer.controller;

import com.mozi.NacosConsumer.Edas.EchoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @program: sw
 * @ClassName TestController
 * @description: [用一句话描述此类]
 * @author: GUO
 * @create: 2020-06-13 16:19
 **/
@RestController
@RefreshScope
public class TestController {

//    @Value("$(moke)")

    @Value("${user.name}")
    private String title;

//    @GetMapping("/test")
//    public String hello() {
//        return title;
//    }

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EchoService echoService;

    @RequestMapping(value = "/echo-rest/{str}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "hiError")
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://service-provider-skywalking-02/echo/" + str, String.class);
    }

    public String hiError(String str) {
        return  "sorry "+str+"参数违法,经本大侠鉴定设计服务之间的调用出错,无法为你进行后续服务,请滚蛋";

    }
    @Trace
    @RequestMapping(value = "/echo-liuxk", method = RequestMethod.GET)
    public String liuxk(String str) {
        test1("123123123123");
        return "123";
    }

    @Trace
    @RequestMapping(value = "/echo-feign", method = RequestMethod.GET)
    public String feign(String str) {
//        test1("123123123123");
//        rest(str);
//        System.out.println("fff");
        return echoService.echo(str);
    }


    @Trace
    public void test1(String str) {
        System.out.println("test11111111111");
    }

    public void test2(String str) {
//        restTemplate.getForObject()
        System.out.println("test22222222222");
    }

    public void test3(String str) {
        System.out.println("test3");
    }

}