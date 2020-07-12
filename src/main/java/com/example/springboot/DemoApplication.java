package com.example.springboot;

import com.example.springboot.config.SpringBootConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class DemoApplication {

	//SpringBoot allows you to create stand-alone, production-grade Spring based applications, 'that you can just run'
	// stand alone -> because it runs on its own -> it has embedded tomcat server.
	// SpringBoot prefers conventions over configuration. It uses default configurations to just run the application
	// User can modify these default conventions according to needs
	public static void main(String[] args) {

		// SpringApplication class has static method run, to which we pass a class annotated with @SpringBootApplication
		// to start SpringBoot app.
		// This static run method does following things -> set default config, start spring ApplicationContext, perform
		// classpath scan and start TomCat server.
		// check pom.xml for dependencies
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		// SpringBoot by default is configured to use application.properties in resources for properties.
	}

}
