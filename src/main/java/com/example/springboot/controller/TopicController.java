package com.example.springboot.controller;

import com.example.springboot.exception.NotPresentException;
import com.example.springboot.model.Topic;
import com.example.springboot.service.TopicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Slf4j
//SpringBoot will send the the REST api request to the RestControllers
public class TopicController {

    @Autowired
    private TopicService topicService;


    //If the RequestMapping is not present, API will throw exception
    @RequestMapping("/topics")
    public ResponseEntity<Set<Topic>> getAllTopics() {
        log.info("Getting all topics..");
        Set<Topic> topics = topicService.getAllTopics();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String , String>();
        headers.add("count", topics.size()+"");
        return new ResponseEntity<Set<Topic>>(topics, headers, HttpStatus.OK);
    }

    @RequestMapping("/topics/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable  int id) {
        log.info("Get Topic with ID: " + id);
        Optional<Topic> topic = topicService.getTopic(id);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String , String>();
        if(topic.isPresent()){
            headers.add("present", "true");
            return new ResponseEntity<Topic>(topic.get(), headers, HttpStatus.OK);
        }
        else
        {
            headers.add("present", "false");
            headers.add("message", "id " + id + " is not present!");
            return new ResponseEntity<Topic>(null, headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic){
        log.info("Adding Topic with ID: " + topic.getId());
        topicService.addTopic(topic);
        return new ResponseEntity<Topic>(null, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Topic> removeTopic(@PathVariable  int id) {
        log.info("Removing Topic with ID: " + id);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String , String>();
        try {
            Topic removedTopic = topicService.removeTopic(id);
            headers.add("removed", "true");
            return new ResponseEntity<Topic>(removedTopic, headers, HttpStatus.OK);
        }
        catch (NotPresentException exception){
            headers.add("removed", "false");
            headers.add("message", exception.getMessage());
            return new ResponseEntity<Topic>(null, headers, HttpStatus.BAD_REQUEST);
        }
    }
}
