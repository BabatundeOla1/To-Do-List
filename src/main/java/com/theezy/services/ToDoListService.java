package com.theezy.services;

import com.theezy.data.model.ToDoList;
import com.theezy.dto.request.ToDoListRequest;
import com.theezy.dto.response.ToDoListResponse;

public interface ToDoListService {

   ToDoListResponse createToDoList (ToDoListRequest toDoListRequest);

   ToDoListResponse deleteTaskByTitle(String title);

   ToDoListResponse updateToDoList(String toDoTiTle, ToDoListRequest toDoListRequest);

    ToDoListResponse clearAll();

    ToDoList searchWithTitle(String title);

    void markAsComplete(String description);
}
