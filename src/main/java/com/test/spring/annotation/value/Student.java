package com.test.spring.annotation.value;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Data
@ToString
public class Student {
    @Value("${student.id}")
    private int id;

    @Value("${student.name}")
    private String name;

    @Value("${student.mobile}")
    private String mobile;
}
