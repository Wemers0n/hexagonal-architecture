package com.example.hexagonal_architecture.application.ports.out.task;

import java.util.List;

import com.example.hexagonal_architecture.application.core.domains.Task;

public interface FindAllTasksByIdUserOutputPort {

    List<Task> findAllUserTasks(String userId) throws Exception;
}
