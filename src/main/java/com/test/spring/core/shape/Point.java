package com.test.spring.core.shape;

import lombok.Data;

@Data
public class Point {
    private float x;
    private float y;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
