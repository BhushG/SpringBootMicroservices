package com.configuration.test.springboot;

import com.configuration.test.springboot.config.Server;
import com.example.springboot.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class ConfigTestApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConfigTestApplication.class, args);

        Server server = context.getBean("server", Server.class);
        log.info("Path: "+ server.getPath());
        log.info("Port: "+ server.getPort() + "");
        log.info("Address: "+ server.getAddress());
        log.info("Name: "+ server.getName());
    }
}
