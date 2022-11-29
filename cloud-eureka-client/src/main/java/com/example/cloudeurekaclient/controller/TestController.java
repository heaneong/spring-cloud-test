package com.example.cloudeurekaclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/getStr" , method = RequestMethod.GET)
    public String returnStr(){
        return "success!!";
    }

}
