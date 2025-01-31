package com.example.hexagonal_architecture.adapters.task;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.hexagonal_architecture.adapters.mappers.TaskMapper;
import com.example.hexagonal_architecture.adapters.out.database.model.TaskCollection;
import com.example.hexagonal_architecture.adapters.out.database.repository.TaskCollectionRepository;
import com.example.hexagonal_architecture.application.core.domains.Task;
import com.example.hexagonal_architecture.application.ports.out.task.FindAllTasksByIdUserOutputPort;

@Component
public class FindAllTasksAdapter implements FindAllTasksByIdUserOutputPort {

    private final TaskCollectionRepository taskCollectionRepository;
    private final TaskMapper mapper;

    public FindAllTasksAdapter(TaskCollectionRepository taskCollectionRepository, TaskMapper mapper) {
        this.taskCollectionRepository = taskCollectionRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Task> findAllUserTasks(String userId) throws Exception {
        List<TaskCollection> allTasksCollections = this.taskCollectionRepository.findAllById(userId);

          var allTasks = allTasksCollections.stream().map(mapper::toDomain).toList();

          return allTasks;
        
    }

}
