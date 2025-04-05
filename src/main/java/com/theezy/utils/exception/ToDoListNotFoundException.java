package com.theezy.utils.exception;

public class ToDoListNotFoundException extends RuntimeException{
    public ToDoListNotFoundException(String message){
        super(message);
    }
}
