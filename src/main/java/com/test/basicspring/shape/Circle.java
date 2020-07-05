package com.test.basicspring.shape;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Circle extends Shape {
    private Point center;
    private float radius;
}
