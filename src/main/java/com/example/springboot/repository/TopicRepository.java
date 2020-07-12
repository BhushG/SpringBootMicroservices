package com.example.springboot.repository;

import com.example.springboot.model.Topic;
import org.springframework.data.repository.CrudRepository;

// The CrudRepository has all the basic CRUD operations.
// If we want all the basic CRUD operations, we just need to extend CrudRepository
public interface TopicRepository extends CrudRepository<Topic, Integer> {
    //JPA stands for JAVA Persistance API
    //JPA allows us to do Object-Relational mapping i.e mapping Java Classes to a relational table
    // Spring Data JPA makes JPA for us simpler. With just @Entity annotation, table for that class is created
}
