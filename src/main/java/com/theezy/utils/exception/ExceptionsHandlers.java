package com.theezy.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandlers {

    @ExceptionHandler(ToDoListAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleToDoListAlreadyExistException(ToDoListAlreadyExistException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ToDoListCanNotBeNullException.class)
    public ResponseEntity<ErrorResponse> handleToDoListCanNotBeNullException(ToDoListCanNotBeNullException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(TaskAlreadyCompletedException.class)
    public ResponseEntity<ErrorResponse> handleTaskAlreadyCompletedException(TaskAlreadyCompletedException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ToDoListNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleToDoListNotFoundException(ToDoListNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

}
