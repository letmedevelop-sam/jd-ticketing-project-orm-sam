package com.cybertek.service;

import com.cybertek.dto.TaskDTO;
import com.cybertek.entity.Task;

import java.util.List;

public interface TaskService {

    TaskDTO findByID(Long id);
    List<TaskDTO> listAllTasks();
    Task save (TaskDTO dto);
    void update(TaskDTO dto);
    void  delete(long id);


}
