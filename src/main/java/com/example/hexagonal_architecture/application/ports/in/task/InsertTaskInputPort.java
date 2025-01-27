package com.example.hexagonal_architecture.application.ports.in.task;

import com.example.hexagonal_architecture.application.core.domains.Task;

public interface InsertTaskInputPort {

    void insertTask(Task task) throws Exception;
}
