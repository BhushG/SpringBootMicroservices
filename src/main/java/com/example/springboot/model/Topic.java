package com.example.springboot.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity // because of this Annotation JPA creates a topic table with fields as its columns
public class Topic {
    @Id // this will be the primary key of the table
    private int id;
    private String name;
    private String description;

    public Topic(int id){
        this.id=id;
    }
}
