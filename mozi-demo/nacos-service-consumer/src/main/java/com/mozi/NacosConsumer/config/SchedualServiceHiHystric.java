package com.mozi.NacosConsumer.config;

import com.mozi.NacosConsumer.Edas.EchoService;
import org.springframework.stereotype.Component;

/**
 * @program: mozi
 * @ClassName SchedualServiceHiHystric
 * @description: [用一句话描述此类]
 * @author: GUO
 * @create: 2020-07-09 23:57
 **/
@Component
public class SchedualServiceHiHystric implements EchoService {

    @Override
    public String echo(String str) {
        return  "sorry "+str+"参数违法,经本大侠鉴定设计服务之间的调用出错,无法为你进行后续服务,请滚蛋";
    }
}
