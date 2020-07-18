package com.configuration.test.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ComponentScan("com.configuration.test.springboot.config")
@ConfigurationProperties("server")
public class Server {
    @Value("${name}")
    private String name;
    private String address;
    private int port;
    private String path;
}
