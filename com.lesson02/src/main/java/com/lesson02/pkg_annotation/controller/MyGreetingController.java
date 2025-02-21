package com.lesson02.pkg_annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class MyGreetingController {
    @Autowired
    private final MyGreetingController myGreetingController;

    public MyGreetingController(MyGreetingController greetingService) {
        this.myGreetingController = greetingService;
    }

    @GetMapping("/my-greet")
    public String greet() {
        return myGreetingController.greet();
    }
}
