package com.example.springboot.controller;

import com.example.springboot.model.Course;
import com.example.springboot.model.Topic;
import com.example.springboot.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    //Get all courses under this topic
    @RequestMapping("/topics/{topicId}/courses")
    public ResponseEntity<Set<Course>> getAllCoursesUnderTopic(@PathVariable  int topicId) {
        log.info("Getting all Courses under Topic ID: "+topicId);
        Set<Course> courses = courseService.getAllCoursesUnderTopic(topicId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String , String>();
        headers.add("count", courses.size()+"");
        return new ResponseEntity<Set<Course>>(courses, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public ResponseEntity<Course> addTopic(@RequestBody Course course, @PathVariable  int topicId){
        log.info("Adding Course with ID: " + course.getId() +" under Topic ID: " + topicId);
        course.setTopic(new Topic(topicId));
        courseService.addCourse(course);
        return new ResponseEntity<Course>(null, null, HttpStatus.OK);
    }

}
