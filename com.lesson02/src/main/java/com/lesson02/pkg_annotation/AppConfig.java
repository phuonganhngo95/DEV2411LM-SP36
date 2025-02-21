package com.lesson02.pkg_annotation;

import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean
    public String appName() {
        return "<h1>Devmaster </h1><h2>Spring Boot";
    }
}
