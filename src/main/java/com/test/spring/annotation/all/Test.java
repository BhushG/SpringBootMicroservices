package com.test.spring.annotation.all;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        // we only want to use annotations here, so creating AnnotationConfigApplicationContext
        // SpringConfig is configuration class, which tells spring which package to scan for components
        // have a look at SpringCofig class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        // Student class is annotated with @Component, so Student class bean will be created with student id by Spring IOC
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
        student.getActions().read();
        student.getActions().write();

        // College class is not annotated with @Component, but we have created @Bean annotated method getCollege in Config class
        College college = context.getBean("getCollege", College.class);
        System.out.println(college);

        // @Configuration, @Service are all advanced types of @Component
        // So classes annotated with @Configuration, @Service etc, their Objects are also added in Spring container.
        SpringConfig config = context.getBean("springConfig", SpringConfig.class);
        System.out.println(config.getType());

        // we need to register shutdownHook, if we need to call preDestroy method in any bean
        context.registerShutdownHook();

    }
}
