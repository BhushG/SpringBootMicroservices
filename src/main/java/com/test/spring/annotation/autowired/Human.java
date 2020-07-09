package com.test.spring.annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human {

    //first searches heart dependency by type in Spring IOC container
    //if multiple Heart objects are present in Spring container searches object with id='heart'
    @Autowired
    @Qualifier("heart1") //if multiple Heart objects present with id other than heart then use Qualifier
    Heart heart;

    public void breath() {
        heart.pump();
    }

    public void setHeart(Heart heart) {
        this.heart = heart;
    }

}
