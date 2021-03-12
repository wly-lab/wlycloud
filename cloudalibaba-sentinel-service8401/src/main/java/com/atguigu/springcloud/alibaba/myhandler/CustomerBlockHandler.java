package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException ex){
        return new CommonResult(4444,"按客户自定义，global handlerException-----1");
    }
    public static CommonResult handlerException2(BlockException ex){
        return new CommonResult(5555,"按客户自定义，global handlerException-----2");
    }
}
