package com.test.spring.core;

import com.test.spring.core.shape.Shape;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Inversion of Control and Dependency injection : https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring
// Spring Container/ IOC (Inversion Of Control) container takes care of Objects creation, we just need to focus on business logic


public class BasicSpringTest {
    public static void main(String[] args) {
        // when we initialize ApplicationContext, Spring will initialize all the Bean objects at a time and
        // it will add those objects in Spring Container
        // all those Bean objects that we want to initialize are in CoreSpringTest.xml here
        // all these initialized objects will be initialized only once and added in Spring Container
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("CoreSpringTest.xml");

        // destroy method will be called for beans after ApplicationContext shutdown
        context.registerShutdownHook();

        // when we want to get reference to object present in Spring Container we call context.getBean(OBJECT_ID)
        // if we want to create new object for each getBean call, we should define the scope as prototype
       // Opposite to singleton, prototype scope produces a new instance each and every time a bean is requested.
        Shape shape = context.getBean("triangle", Shape.class);

        shape.draw();

        // Note: singleton scope here is different than singleton pattern in java
        // here singleton means per spring container there will be singleton initialization but
        // there can be multiple SpringContainers under single JVM
    }
}
