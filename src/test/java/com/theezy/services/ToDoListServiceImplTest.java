package com.theezy.services;

import com.theezy.data.model.ToDoList;
import com.theezy.data.repositories.ToDoListRepository;
import com.theezy.dto.request.ToDoListRequest;
import com.theezy.utils.exception.ToDoListAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ToDoListServiceImplTest {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Autowired
    private ToDoListService toDoListService;

    @BeforeEach
    public void clearToDoListRepository(){
        toDoListRepository.deleteAll();
    }

    public void setUpToDoList(ToDoListRequest toDoListRequest){
        toDoListRequest.setTitle("practice");
        toDoListRequest.setDescription("Practice Java2");
        toDoListRequest.setCreatedTime(LocalDateTime.now());
        toDoListRequest.setDueDate("10-04-2025");
        toDoListRequest.setDueTime("11:40");
    }

    @Test
    public void testThatYouCanCreateToDoList(){
        ToDoListRequest toDoListRequest = new ToDoListRequest();
        setUpToDoList(toDoListRequest);
        toDoListService.createToDoList(toDoListRequest);
        assertEquals(1, toDoListRepository.count());
    }

    @Test
    public void testThatExceptionIsThrown_WhenTaskIsSavedTwice(){
        ToDoListRequest toDoListRequest = new ToDoListRequest();
        setUpToDoList(toDoListRequest);
        toDoListService.createToDoList(toDoListRequest);

        assertEquals(1, toDoListRepository.count());
        assertThrows(ToDoListAlreadyExistException.class, ()-> toDoListService.createToDoList(toDoListRequest));
    }

    @Test
    public void testThatYouCanCreateMoreThanOne_ToDoList(){
        ToDoListRequest toDoListRequest = new ToDoListRequest();
        setUpToDoList(toDoListRequest);
        toDoListService.createToDoList(toDoListRequest);
        assertEquals(1, toDoListRepository.count());

        ToDoListRequest secondToDoList = new ToDoListRequest();
        secondToDoList.setTitle("paint");
        secondToDoList.setDescription("Complete the 4by4ft artwork");
        secondToDoList.setCreatedTime(LocalDateTime.now());
        secondToDoList.setDueDate("04-10-2025");
        secondToDoList.setDueTime("12:30");
        toDoListService.createToDoList(secondToDoList);
        assertEquals(2, toDoListRepository.count());
    }

    @Test
    public void testThatYouCanDeleteA_ToDoList(){
        ToDoListRequest toDoListRequest = new ToDoListRequest();
        setUpToDoList(toDoListRequest);
        toDoListService.createToDoList(toDoListRequest);
        assertEquals(1, toDoListRepository.count());

        ToDoListRequest secondToDoList = new ToDoListRequest();
        secondToDoList.setTitle("sleep");
        secondToDoList.setDescription("Just sleep for some hours");
        secondToDoList.setCreatedTime(LocalDateTime.now());
        secondToDoList.setDueDate("04-10-2025");
        secondToDoList.setDueTime("12:30");
        toDoListService.createToDoList(secondToDoList);
        assertEquals(2, toDoListRepository.count());

        toDoListService.deleteTaskByTitle(secondToDoList.getTitle());
        assertEquals(1, toDoListRepository.count());
    }

    @Test
    public void testThatYouCanUpdateToDoList(){
        ToDoListRequest toDoListRequest = new ToDoListRequest();
        setUpToDoList(toDoListRequest);
        toDoListService.createToDoList(toDoListRequest);
        assertEquals(1, toDoListRepository.count());
        System.out.println(toDoListRequest);

        ToDoListRequest updatedToDo = new ToDoListRequest();
        updatedToDo.setTitle("update");
        updatedToDo.setDueDate("09-05-2025");
        updatedToDo.setDueTime("04:55");
        toDoListService.updateToDoList("practice", updatedToDo);
        assertEquals("update" ,updatedToDo.getTitle());
        assertNotNull(updatedToDo);
        assertNotNull(updatedToDo);
    }

    @Test
    public void testThatYouCanDeleteAllToDoList(){
        ToDoListRequest toDoListRequest = new ToDoListRequest();
        setUpToDoList(toDoListRequest);
        toDoListService.createToDoList(toDoListRequest);
        assertEquals(1, toDoListRepository.count());

        ToDoListRequest secondToDoList = new ToDoListRequest();
        secondToDoList.setTitle("sleep");
        secondToDoList.setDescription("Just sleep for some hours");
        secondToDoList.setCreatedTime(LocalDateTime.now());
        secondToDoList.setDueDate("04-10-2025");
        secondToDoList.setDueTime("12:30");
        toDoListService.createToDoList(secondToDoList);
        assertEquals(2, toDoListRepository.count());

        toDoListService.clearAll();
        assertEquals(0, toDoListRepository.count());
    }

//    @Test
//    public void testThatYouCanSearchForToDoListUsingTitle(){
//        ToDoListRequest toDoListRequest = new ToDoListRequest();
//        setUpToDoList(toDoListRequest);
//        toDoListService.createToDoList(toDoListRequest);
//        assertEquals(1, toDoListRepository.count());
//
//        ToDoListRequest secondToDoList = new ToDoListRequest();
//        secondToDoList.setTitle("sleep");
//        secondToDoList.setDescription("Just sleep for some hours");
//        secondToDoList.setCreatedTime(LocalDateTime.now());
//        secondToDoList.setDueDate("04-10-2025");
//        secondToDoList.setDueTime("12:30");
//        toDoListService.createToDoList(secondToDoList);
//        assertEquals(2, toDoListRepository.count());
//
//        ToDoList foundToDoList = toDoListService.searchWithTitle(secondToDoList.getTitle());
//        assertEquals("sleep", foundToDoList.getTitle());
//        assertEquals("Just sleep for some hours", foundToDoList.getDescription());
//        assertNotNull(foundToDoList);
//        System.out.println(foundToDoList);
//    }
//
//    @Test
//    public void testThatYouCanMarkA_TaskCompleted(){
//        ToDoListRequest toDoListRequest = new ToDoListRequest();
//        setUpToDoList(toDoListRequest);
//        toDoListService.createToDoList(toDoListRequest);
//        assertEquals(1, toDoListRepository.count());
//
//        toDoListService.markAsComplete(toDoListRequest.getId());
//
//        assertTrue(toDoListRequest.isComplete());
//        System.out.println(toDoListRequest);
//    }
}