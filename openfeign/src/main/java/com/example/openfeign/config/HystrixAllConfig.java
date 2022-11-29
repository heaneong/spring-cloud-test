package com.example.openfeign.config;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.stereotype.Component;

@Component
@DefaultProperties(defaultFallback = "dept_Global_FallbackMethod")
public class HystrixAllConfig {

    public String dept_Global_FallbackMethod() {
        return "C语言中文网提醒您，运行出错或服务端系统繁忙，请稍后再试！（客户端全局回退方法触发,）";
    }

}
