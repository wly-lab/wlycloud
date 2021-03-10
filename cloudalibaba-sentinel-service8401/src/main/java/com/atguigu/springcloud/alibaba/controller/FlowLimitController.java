package com.atguigu.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
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

}
