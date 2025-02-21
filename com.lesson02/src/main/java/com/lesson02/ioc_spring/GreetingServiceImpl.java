package com.lesson02.ioc_spring;

import org.springframework.stereotype.Service;

public class GreetingServiceImpl implements GreetingService {
    public String greet(String name) {
        return "<h2>Devmaster[Spring Boot] Xin chào,</h2>" +
                "<h1 style='color: red; text-align: center'>" + name;
    }
}
