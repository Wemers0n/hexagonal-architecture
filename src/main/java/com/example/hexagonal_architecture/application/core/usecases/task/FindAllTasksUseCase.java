package com.example.hexagonal_architecture.application.core.usecases.task;

import java.util.List;

import com.example.hexagonal_architecture.application.core.domains.Task;
import com.example.hexagonal_architecture.application.ports.in.task.FindAllTasksByIdUserInputPort;
import com.example.hexagonal_architecture.application.ports.out.task.FindAllTasksByIdUserOutputPort;

public class FindAllTasksUseCase implements FindAllTasksByIdUserInputPort{

    private final FindAllTasksByIdUserOutputPort findAllTasksByIdUserOutputPort;

    public FindAllTasksUseCase(FindAllTasksByIdUserOutputPort findAllTasksByIdUserOutputPort) {
        this.findAllTasksByIdUserOutputPort = findAllTasksByIdUserOutputPort;
    }

    @Override
    public List<Task> findAllTasks(String userId) throws Exception {
        return findAllTasksByIdUserOutputPort.findAllUserTasks(userId);
    }

}
