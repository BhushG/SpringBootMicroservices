package com.example.springboot.repository;

import com.example.springboot.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findByTopicId(int topicId);
}
