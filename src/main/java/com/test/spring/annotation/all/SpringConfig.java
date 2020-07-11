package com.test.spring.annotation.all;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// This is Spring Configuration class. Here we are defining which package to scan for Components
// For each @Component class a Spring Bean will be created and it will be added in Spring container
@Data
@Configuration
@ComponentScan("com.test.spring.annotation.all")
@PropertySource("classpath:myspring.properties") // here we are defining the file where we have stored properties for this app
public class SpringConfig {

    private String type= "Configuration Class";

    @Bean
    public College getCollege() {
        return new College("Walchand");
    }
}
