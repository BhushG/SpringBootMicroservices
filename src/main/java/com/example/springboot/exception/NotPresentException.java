package com.example.springboot.exception;

public class NotPresentException extends Exception{
    Class notPresent;

    public NotPresentException(Class notPresent, String message){
        super(message);
        this.notPresent=notPresent;
    }
}
