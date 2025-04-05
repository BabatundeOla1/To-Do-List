package com.theezy.utils.exception;

public class ToDoListCanNotBeNullException extends RuntimeException{
    public ToDoListCanNotBeNullException(String message){
        super(message);
    }
}
