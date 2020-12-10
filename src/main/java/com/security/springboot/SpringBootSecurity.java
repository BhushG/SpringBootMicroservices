package com.security.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * If you want to add security to your project, you need to use spring-boot-starter-security dependency
 * spring-security adds authentication to all URLs, it adds logic form automatically and handles login error
 * By default spring-security creates a user: user and it's password gets printed in console
 * we can change username and password for default customer using application.properties:
 *  spring.security.user.name: bhush
 *  spring.security.user.password: pass
 *
 */

@SpringBootApplication
public class SpringBootSecurity
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootSecurity.class, args);
    }
}
