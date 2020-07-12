package com.example.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan("com.example.springboot")
@Slf4j
public class SpringBootConfig {

    @Value("${server.path}")
    String serverPath;


    @PostConstruct
    public void postConstruct() {
        log.info("Server Path: " + serverPath);
    }
}
