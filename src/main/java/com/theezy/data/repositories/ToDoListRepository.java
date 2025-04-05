package com.theezy.data.repositories;

import com.theezy.data.model.ToDoList;
import com.theezy.dto.request.ToDoListRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ToDoListRepository extends MongoRepository<ToDoList, String> {

    Optional<ToDoList> findToDoListByDescription(String description);
    boolean existsByTitle(String title);

    void deleteToDoListByTitle(String title);
    ToDoList findToDoListByTitle(String title);

    ToDoList findToDoListById(String id);
}
