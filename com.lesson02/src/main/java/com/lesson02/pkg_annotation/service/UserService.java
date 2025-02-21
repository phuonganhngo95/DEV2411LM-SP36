package com.lesson02.pkg_annotation.service;

import com.lesson02.pkg_annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    public String getUserDetails() {
        return "<h1>User details";
    }
}
