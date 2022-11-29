package com.example.openfeign.controller;

import com.example.openfeign.api.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private TestFeignService testFeignService;

    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public String feignTest(){
        return testFeignService.test();
    }

}
