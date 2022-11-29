package com.example.openfeign.service;

public interface HystrixService {

    public String test_ok();

    public String test_timeout();

}
