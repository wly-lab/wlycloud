package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZKController {

    public static final  String INCOKER_URL="http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/payment/zk")
    public  String paymentInfo(){
        String result=restTemplate.getForObject(INCOKER_URL+"/payment/zk",String.class);
        return  result;
    }
}
