package com.mozi.NacosConsumer.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@RequestMapping("/hello")
	public String Hello(@RequestParam String name){
//		System.out.println(1 / 0);
		return "你好！" + name + ",这是第一个微服务。";
	}
}
