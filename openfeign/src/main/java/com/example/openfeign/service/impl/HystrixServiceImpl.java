package com.example.openfeign.service.impl;

import com.example.openfeign.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixServiceImpl implements HystrixService {
    @Override
    public String test_ok() {
        return "线程池ok：" + Thread.currentThread().getName();
    }

    @HystrixCommand(fallbackMethod = "dept_TimeoutHandler",
            commandProperties =
                    //规定 5 秒钟以内就不报错，正常运行，超过 5 秒就报错，调用指定的方法
                    {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
//    @HystrixCommand(fallbackMethod = "deptCircuitBreaker_fallback", commandProperties = {
//            //以下参数在 HystrixCommandProperties 类中有默认配置
//            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启熔断器
//            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "1000"), //统计时间窗
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //统计时间窗内请求次数
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗口期
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //在统计时间窗口期以内，请求失败率达到 60% 时进入熔断状态
//    })
    @Override
    public String test_timeout() {
        int outTime = 6;
        try {
            TimeUnit.SECONDS.sleep(outTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池timeout：" + Thread.currentThread().getName();
    }

    public String dept_TimeoutHandler() {
        return  "C语言中文网提醒您，系统繁忙请稍后再试！"+"线程池：" + Thread.currentThread().getName() ;
    }
}
