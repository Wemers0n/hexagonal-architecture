package com.example.hexagonal_architecture.application.ports.in.task;

import java.util.List;

import com.example.hexagonal_architecture.application.core.domains.Task;

public interface FindAllTasksByIdUserInputPort {

    List<Task> findAllTasks(String userId) throws Exception;
}
