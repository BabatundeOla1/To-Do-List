package com.theezy.data.repositories;

import com.theezy.data.model.ToDoList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ToDoListRepository extends MongoRepository<ToDoList, String> {

    Optional<ToDoList> findToDoListByDueDate(LocalDateTime dueDate);
    boolean existsByTitle(String title);
    ToDoList findToDoListByTitle(String title);

}
