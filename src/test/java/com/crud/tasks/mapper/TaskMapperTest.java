package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {

    @Autowired
    TaskMapper taskMapper;

    @Test
    void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "taskDto", "content");

        //When
        Task mappedToTask = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(1L, mappedToTask.getId());
        assertEquals("taskDto", mappedToTask.getTitle());
        assertEquals("content", mappedToTask.getContent());
    }

    @Test
    void mapToTaskDto() {
        //Given
        Task task = new Task(2L, "task", "taskContent");

        //When
        TaskDto mappedToTaskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(2L, mappedToTaskDto.getId());
        assertEquals("task", mappedToTaskDto.getTitle());
        assertEquals("taskContent", mappedToTaskDto.getContent());
    }

    @Test
    void mapToTaskDtoList() {
        //Given
        Task task = new Task(2L, "task", "taskContent");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(1, taskDtoList.size());
        assertEquals(2L, taskDtoList.get(0).getId());
        assertEquals("task", taskDtoList.get(0).getTitle());
        assertEquals("taskContent", taskDtoList.get(0).getContent());
    }
}
