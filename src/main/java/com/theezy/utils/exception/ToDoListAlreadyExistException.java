package com.theezy.utils.exception;

public class ToDoListAlreadyExistException extends RuntimeException{

    public ToDoListAlreadyExistException(String message){
        super(message);
    }
}
