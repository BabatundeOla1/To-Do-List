package com.theezy.services;

import com.theezy.data.model.ToDoList;
import com.theezy.data.repositories.ToDoListRepository;
import com.theezy.dto.request.ToDoListRequest;
import com.theezy.dto.response.ToDoListResponse;
import com.theezy.utils.exception.ToDoListAlreadyExistException;
import com.theezy.utils.exception.ToDoListCanNotBeNullException;
import com.theezy.utils.mapper.ToDoListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListServiceImpl implements ToDoListService{

    @Autowired
    private ToDoListRepository toDoListRepository;
    @Override
    public ToDoListResponse createToDoList(ToDoListRequest toDoListRequest) {

        if (toDoListRepository.existsByTitle(toDoListRequest.getTitle())){
            throw new ToDoListAlreadyExistException("Task Already Exist");
        }

        ToDoList newToDoList = ToDoListMapper.mapRequestToToDoList(toDoListRequest);
        ToDoList savedToDoList = toDoListRepository.save(newToDoList);
        return ToDoListMapper.mapToDoListToResponse(savedToDoList);
    }

    @Override
    public ToDoListResponse deleteTaskByTitle(String title) {
        toDoListRepository.deleteToDoListByTitle(title);
        return ToDoListMapper.mapToDeleteToDoList("Successfully deleted");
    }

    @Override
    public ToDoListResponse updateToDoList(String toDoTiTle, ToDoListRequest toDoListRequest) {
        ToDoList foundToDoList = toDoListRepository.findToDoListByTitle(toDoTiTle);
        if (foundToDoList == null){
            throw new ToDoListCanNotBeNullException("Task can not be null");
        }

        foundToDoList.setTitle(toDoListRequest.getTitle());
        foundToDoList.setDescription(toDoListRequest.getDescription());
        toDoListRepository.save(foundToDoList);
        return ToDoListMapper.mapToDoListToResponse(foundToDoList);
    }

    @Override
    public void clearAll() {
        toDoListRepository.deleteAll();
    }
//
//    @Override
//    public ToDoList searchWithTitle(String title) {
//        ToDoList foundToDoList = toDoListRepository.findToDoListByTitle(title);
//        if (foundToDoList == null) {
//            throw new ToDoListNotFoundException("Task with title \"" + title + "\" not found");
//        }
//        return foundToDoList;
//    }
//
//
//    @Override
//    public void markAsComplete(String id) {
//        ToDoList foundToDoList = toDoListRepository.findToDoListById(id);
//
//        if (foundToDoList.isComplete()) {
//            throw new TaskAlreadyCompletedException("Task already marked as complete");
//        }
//
//        foundToDoList.setComplete(true);
//        toDoListRepository.save(foundToDoList);
//    }
}
