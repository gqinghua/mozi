package com.mozi.NacosConsumer.controller;


import cn.hutool.core.lang.UUID;
import com.mozi.common.sequence.sequence.Sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * @program: mozi
 * @ClassName SysSchoolController
 * @description: [用一句话描述此类]
 * @author: GUO
 * @create: 2020-07-30 15:48
 **/

@RestController
//@RequestMapping("/school")
public class SysSchoolController {


    @Autowired
    private Sequence redisSequence;



    /**
     * ss
     * @param
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public String save( String str) {

        String uuid = UUID.randomUUID().toString(true);


//        System.out.println(uuid);
        String s = redisSequence.nextNo();
        System.out.println(s);
        return s;
    }
}
