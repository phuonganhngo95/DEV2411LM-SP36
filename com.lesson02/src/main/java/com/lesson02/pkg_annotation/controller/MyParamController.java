package com.lesson02.pkg_annotation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class MyParamController {
    @GetMapping("/my-param")
    public String searchUsers(@RequestParam(value = "name", required = false) String name) {
        if (name == null) {
            return "<h2>No name provided, returning all users";
        }
        return "<h1>Searching for users with name: " + name;
    }

    @GetMapping("/my-variable/{id}")
    public String getUserById(@RequestParam(required = false) String id) {
        return "<h1>User ID is " + id;
    }
}
