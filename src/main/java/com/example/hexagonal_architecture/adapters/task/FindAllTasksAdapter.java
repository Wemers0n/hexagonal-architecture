package com.example.hexagonal_architecture.adapters.task;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.hexagonal_architecture.adapters.mappers.TaskMapper;
import com.example.hexagonal_architecture.adapters.out.database.model.TaskCollection;
import com.example.hexagonal_architecture.adapters.out.database.repository.TaskCollectionRepository;
import com.example.hexagonal_architecture.application.core.domains.Task;
import com.example.hexagonal_architecture.application.ports.out.task.FindAllTasksByIdUserOutputPort;
import com.example.hexagonal_architecture.application.ports.out.user.FindUserByIdOutputPort;

@Component
public class FindAllTasksAdapter implements FindAllTasksByIdUserOutputPort {

    private final TaskCollectionRepository taskCollectionRepository;
    private final FindUserByIdOutputPort findUserByIdOutputPort;
    private final TaskMapper mapper;

    public FindAllTasksAdapter(TaskCollectionRepository taskCollectionRepository, TaskMapper mapper, FindUserByIdOutputPort findUserByIdOutputPort) {
        this.taskCollectionRepository = taskCollectionRepository;
        this.findUserByIdOutputPort = findUserByIdOutputPort;
        this.mapper = mapper;
    }

    @Override
    public List<Task> findAllUserTasks(String userId) throws Exception {

        this.findUserByIdOutputPort.findUser(userId);

        List<TaskCollection> allTasksCollections = this.taskCollectionRepository.findAllById(userId);

        var allTasks = allTasksCollections.stream().map(mapper::toDomain).toList();

        return allTasks;
        
    }

}
