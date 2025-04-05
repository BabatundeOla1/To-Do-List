package com.theezy.utils.mapper;

import com.theezy.data.model.ToDoList;
import com.theezy.dto.request.ToDoListRequest;
import com.theezy.dto.response.ToDoListResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ToDoListMapper {

    public static ToDoList mapRequestToToDoList(ToDoListRequest toDoListRequest){
        if (toDoListRequest == null) {
            throw new IllegalArgumentException("ToDoListRequest cannot be null");
        }

        ToDoList toDoList = new ToDoList();
        toDoList.setTitle(toDoListRequest.getTitle());
        toDoList.setDescription(toDoListRequest.getDescription());
        toDoList.setCreatedTime(LocalDateTime.now());

        if (toDoListRequest.getDueDate() != null && !toDoListRequest.getDueDate().isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDate dueDate = LocalDate.parse(toDoListRequest.getDueDate(), formatter);
            toDoList.setDueDate(dueDate.atStartOfDay());

            if (toDoListRequest.getDueTime() != null && !toDoListRequest.getDueTime().isEmpty()) {
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime dueTime = LocalTime.parse(toDoListRequest.getDueTime(), timeFormatter);
                toDoList.setDueTime(LocalDateTime.of(dueDate, dueTime));            }
        }

        toDoList.setComplete(false);
        return toDoList;
    }

    public static ToDoListResponse mapToDoListToResponse(ToDoList toDoList){
        ToDoListResponse toDoListResponse = new ToDoListResponse();
        toDoListResponse.setMessage("Successfully");
        toDoListResponse.setData(toDoList.getId());
        return toDoListResponse;
    }

    public static ToDoListResponse mapToDeleteToDoList(String message){
        ToDoListResponse toDoListResponse = new ToDoListResponse();
        toDoListResponse.setMessage("Successfully deleted");
        return toDoListResponse;
    }
}
