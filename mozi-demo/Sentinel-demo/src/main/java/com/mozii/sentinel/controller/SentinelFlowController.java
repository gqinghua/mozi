package com.mozii.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mozi
 * @ClassName SentinelFlowController
 * @description: [用一句话描述此类]
 * @author: GUO
 * @create: 2020-07-05 21:55
 **/
@RestController
public class SentinelFlowController {

    @GetMapping("/flow")
    public String flow() {
        return "success";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @SentinelResource(value = "test", blockHandler = "block")
    public String save() {
        return "test";
    }

    public String block(BlockException e) {
        return "block";
    }

}