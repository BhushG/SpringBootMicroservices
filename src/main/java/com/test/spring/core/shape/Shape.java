package com.test.spring.core.shape;

public abstract class Shape {
    public void draw() {
        System.out.println("\n\n------------------ Drawing " + this.getClass().getName() + " -----------------");
        System.out.println(toString());
        System.out.println("\n\n");
    }
}
