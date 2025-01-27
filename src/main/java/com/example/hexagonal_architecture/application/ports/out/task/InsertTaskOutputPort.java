package com.example.hexagonal_architecture.application.ports.out.task;

import com.example.hexagonal_architecture.application.core.domains.Task;

public interface InsertTaskOutputPort {

    void saveTask(Task task) throws Exception;
}
