package com.theezy.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class ToDoList {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDateTime createdTime;
    private LocalDateTime dueDate;
    private LocalDateTime dueTime;
    private boolean isComplete;
}
