package com.example.springboot.service;

import com.example.springboot.model.Topic;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
// In Spring Business Services are singleton, when app starts up Spring creates an instance of Service
// In other Controllers, we add the dependencies for these services
public class TopicService {

    Set<Topic> topics = new HashSet<Topic>(Arrays.asList(new Topic(1, "First", "FirstDesc"),
            new Topic(2, "Second", "SecondDesc")));

    public Set<Topic> getAllTopics() {
        return topics;
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void removeTopic(int id) {
        Optional<Topic> filteredTopic= topics.stream().filter(topic -> topic.getId()==id).findFirst();
        filteredTopic.ifPresent(topic -> topics.remove(topic));
    }

    public Optional<Topic> getTopic(int id) {
        Stream<Topic> filteredTopics= topics.stream().filter(topic -> topic.getId()==id);
        return filteredTopics.findFirst();
    }
}
