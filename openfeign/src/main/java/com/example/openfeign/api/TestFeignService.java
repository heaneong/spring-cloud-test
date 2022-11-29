package com.example.openfeign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "EUREKA-CLIENT")
public interface TestFeignService {

    @RequestMapping(value = "/test/getStr",method = RequestMethod.GET)
    public String test();

}
