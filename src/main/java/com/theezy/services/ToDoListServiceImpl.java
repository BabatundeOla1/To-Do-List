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
        toDoListRepository.save(newToDoList);
        return ToDoListMapper.mapToDoListToResponse(newToDoList);
    }

    @Override
    public void deleteTaskByTitle(String title) {
       ToDoList foundToDo = toDoListRepository.findToDoListByTitle(title);
       toDoListRepository.delete(foundToDo);
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

    @Override
    public ToDoListRequest searchWithTitle(String title) {
        ToDoList foundToDoList = toDoListRepository.findToDoListByTitle(title);
        if (foundToDoList.getTitle() == title){
            
        }
        return null;
    }
}
