package com.theezy.dto.request;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class ToDoListRequest {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDateTime createdTime;
    private String dueDate;
    private String dueTime;
    private boolean isComplete;
}
