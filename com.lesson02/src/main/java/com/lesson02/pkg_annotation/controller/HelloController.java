package com.lesson02.pkg_annotation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class HelloController {
    @GetMapping("/hello")

    public String sayHelllo() {
        return "Hello World";
    }
}
