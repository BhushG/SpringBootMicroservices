package com.example.springboot.controller;

import com.example.springboot.model.Topic;
import com.example.springboot.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
//SpringBoot will send the the REST api request to the RestControllers
public class TopicController {

    @Autowired
    private TopicService topicService;


    //If the RequestMapping is not present, API will throw exception
    @RequestMapping("/topics")
    public Set<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Optional<Topic> getAllTopics(@PathVariable  int id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(value = "/topics/", method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public void removeTopic(@PathVariable  int id) {
        topicService.removeTopic(id);
    }
}
