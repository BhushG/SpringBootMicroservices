package com.test.spring.annotation.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ValueSpringTest.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }
}
