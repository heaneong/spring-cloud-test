package com.example.openfeign.controller;

import com.example.openfeign.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hystrix")
@DefaultProperties(defaultFallback = "dept_Global_FallbackMethod")
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @RequestMapping("ok")
    public String ok(){
        return hystrixService.test_ok();
    }

    @RequestMapping("timeout")
    @HystrixCommand
    public String timeout(){
        return hystrixService.test_timeout();
    }

    public String dept_Global_FallbackMethod() {
        return "C语言中文网提醒您，运行出错或服务端系统繁忙，请稍后再试！（客户端全局回退方法触发,）";
    }

}
