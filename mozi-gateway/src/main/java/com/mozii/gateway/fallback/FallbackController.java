package com.mozii.gateway.fallback;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 响应超时熔断处理器
 *
 * @author zuihou
 */
@RestController
public class FallbackController {

    @RequestMapping("/fallback")
    public  String fallback() {
        return  "ssss";
    }
}
