package com.theezy.controller;

import com.theezy.data.model.ToDoList;
import com.theezy.dto.request.ToDoListRequest;
import com.theezy.dto.response.ToDoListResponse;
import com.theezy.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ToDoList")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @PostMapping("/createToDoList")
    public ResponseEntity<ToDoListResponse> createToDoList(@RequestBody ToDoListRequest toDoListRequest){
        return new ResponseEntity<>(toDoListService.createToDoList(toDoListRequest), HttpStatus.OK);
    }

    @DeleteMapping("/deleteTask/{title}")
    public ResponseEntity<ToDoListResponse> deleteTask(@PathVariable("title") String title){
        return new ResponseEntity<>(toDoListService.deleteTaskByTitle(title), HttpStatus.OK);
    }

    @PutMapping("/editTask/{title}")
    public ResponseEntity<ToDoListResponse> updateTask(@PathVariable("title") String title,
                                                       @RequestBody ToDoListRequest request) {
        return new ResponseEntity<>(toDoListService.updateToDoList(title, request), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<ToDoListResponse> deleteAll(){
        return new ResponseEntity<>(toDoListService.clearAll(), HttpStatus.OK);
    }

    @GetMapping("/searchTask/{title}")
    public ResponseEntity<ToDoList> searchWithTitle(@PathVariable("title") String title){
        return new ResponseEntity<>(toDoListService.searchWithTitle(title), HttpStatus.OK);
    }

    @PutMapping("/completeTask")
    public


}
