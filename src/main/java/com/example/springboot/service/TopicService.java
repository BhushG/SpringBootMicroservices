package com.example.springboot.service;

import com.example.springboot.exception.NotPresentException;
import com.example.springboot.model.Topic;
import com.example.springboot.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
// In Spring Business Services are singleton, when app starts up Spring creates an instance of Service
// In other Controllers, we add the dependencies for these services
public class TopicService {

    @Autowired
    TopicRepository topicRepository;


    public Set<Topic> getAllTopics() {
        Set<Topic> topics = new HashSet<Topic>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public Topic removeTopic(int id) throws NotPresentException {
        Optional<Topic> topic = topicRepository.findById(id);
        if(!topic.isPresent())
            throw new NotPresentException(Topic.class, "The id " + id +" is not present");
        topicRepository.deleteById(id);
        return topic.get();
    }

    public Optional<Topic> getTopic(int id) {
        return topicRepository.findById(id);
    }
}
