package com.test.spring.annotation.all;

import org.springframework.stereotype.Component;

@Component
public class Actions {
    public void read() {
        System.out.println("Reading...");
    }

    public void write() {
        System.out.println("Writing...");
    }
}
