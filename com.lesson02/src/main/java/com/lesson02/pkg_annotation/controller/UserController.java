package com.lesson02.pkg_annotation.controller;

import com.lesson02.pkg_annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUser() {
        return userService.getUserDetails();
    }

    @GetMapping("/users")

    public String getUsers() {
        return "<h1>Get all users";
    }

    public String createUser() {
        return "<h1>User created";
    }

    public String updateUser(int id) {
        return "<h1>User with ID " + id + " updated";
    }

    public String deleteUser(int id) {
        return "<h1>User with ID " + id + " deleted";
    }
}
