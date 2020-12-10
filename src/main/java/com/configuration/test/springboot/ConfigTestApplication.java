package com.configuration.test.springboot;

import com.configuration.test.springboot.config.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * application.properties and application.yml, both files can be used to store configs. Only format different
 * Bootstrap.yml or Bootstrap.properties is used to fetch the config from Spring Cloud Server.
 *  eg.
 *  spring.application.name=Calculation-service
 *  spring.cloud.config.uri=http://localhost:8888
 *
 * application-dev.yml is used for dev profile. This profile can be enabled using -Dspring.profiles.active=dev in VM options
 */

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
