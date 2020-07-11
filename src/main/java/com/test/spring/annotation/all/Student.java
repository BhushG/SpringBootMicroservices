package com.test.spring.annotation.all;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@Component
// by default the ID of bean created from @Component will be name of the class, starting with lower-case
// so id for this class is student
public class Student {
    @Autowired
    private Actions actions;

    @Autowired
    // College class is not annotated with @Component, but we have created @Bean annotated method getCollege in Config class
    // Autowired first searches by type if there are conflict then it searches by name
    // as there is only single College type object, there is no conflict
    private College college;

    @Value("${student.id}")
    private int id;

    @Value("${student.name}")
    private String name;

    @Value("${student.mobile}")
    private String mobile;


    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating Student Object..");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Destroying Student Object..");
    }

}
