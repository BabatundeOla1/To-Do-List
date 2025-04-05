package com.theezy.utils.exception;

public class TaskAlreadyCompletedException extends RuntimeException{
    public TaskAlreadyCompletedException(String message){
        super(message);
    }
}
