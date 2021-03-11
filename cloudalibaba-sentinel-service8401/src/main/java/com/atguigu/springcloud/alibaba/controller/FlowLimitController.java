package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sun.deploy.security.BlockedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public  String testA(){
        // try {
        //     TimeUnit.MILLISECONDS.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        return "--------testA";
    }

    @GetMapping("/testB")
    public  String testB(){
        return "--------testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHostKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p1",required = false) String p2){
        return ".......testHotKey";
    }

    public  String deal_testHostKey(String p1, String p2, BlockedException ex){
        return "----deal_testHostKey,o(╥﹏╥)o";
    }
}
