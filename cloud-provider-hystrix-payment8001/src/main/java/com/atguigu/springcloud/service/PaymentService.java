package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    /**
     * 正常访问 肯定OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_OK:"+id+"\t"+"O(∩_∩)O~~";
    }

    /**
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber=3;
        // int age=10/0;
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut:"+id+"\t"+"O(∩_∩)O~~"+"耗时(s)："+timeNumber;
    }

    public String paymentInfo_TimeOutHandler (Integer id){
        return "线程池："+Thread.currentThread().getName()+",8001系统繁忙，请稍后重试，paymentInfo_TimeOut:"+id+"\t"+"/(ㄒoㄒ)/~~";

    }
}
