package com.example.hexagonal_architecture.adapters.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.hexagonal_architecture.adapters.out.database.model.TaskCollection;
import com.example.hexagonal_architecture.adapters.out.database.repository.TaskCollectionRepository;
import com.example.hexagonal_architecture.application.core.domains.Task;
import com.example.hexagonal_architecture.application.ports.out.task.FindAllTasksByIdUserOutputPort;

@Component
public class FindAllTasksAdapter implements FindAllTasksByIdUserOutputPort {

    private final TaskCollectionRepository taskCollectionRepository;

    public FindAllTasksAdapter(TaskCollectionRepository taskCollectionRepository) {
        this.taskCollectionRepository = taskCollectionRepository;
    }

    @Override
    public List<Task> findAllUserTasks(String userId) throws Exception {
        List<TaskCollection> allTasksCollections = this.taskCollectionRepository.findAllById(userId);
        List<Task> taskResponse = new ArrayList<>();
        
        if(!allTasksCollections.isEmpty()){
            allTasksCollections.stream().forEach(tasks -> {
                taskResponse.add(new Task(tasks.getId(), tasks.getUserId(), tasks.getTitle(), tasks.getDescription()));
            });
        }
        return taskResponse;
    }

}
