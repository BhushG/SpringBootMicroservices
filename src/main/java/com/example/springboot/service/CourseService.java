package com.example.springboot.service;

import com.example.springboot.exception.NotPresentException;
import com.example.springboot.model.Course;
import com.example.springboot.model.Course;
import com.example.springboot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Set<Course> getAllCoursesUnderTopic(int topicId) {
        return new HashSet<Course>(courseRepository.findByTopicId(topicId));
    }

    public Set<Course> getAllCourses() {
        Set<Course> courses = new HashSet<Course>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public Course removeCourse(int id) throws NotPresentException {
        Optional<Course> course = courseRepository.findById(id);
        if(!course.isPresent())
            throw new NotPresentException(Course.class, "The id " + id +" is not present");
        courseRepository.deleteById(id);
        return course.get();
    }

    public Optional<Course> getCourse(int id) {
        return courseRepository.findById(id);
    }
}
