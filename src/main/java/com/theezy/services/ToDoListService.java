package com.theezy.services;

import com.theezy.dto.request.ToDoListRequest;
import com.theezy.dto.response.ToDoListResponse;

public interface ToDoListService {

   ToDoListResponse createToDoList (ToDoListRequest toDoListRequest);

    void deleteTaskByTitle(String title);

    ToDoListResponse updateToDoList(String toDoTiTle, ToDoListRequest toDoListRequest);

    void clearAll();

    ToDoListRequest searchWithTitle(String title);
}
