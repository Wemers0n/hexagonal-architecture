package com.example.hexagonal_architecture.application.core.usecases.task;

import com.example.hexagonal_architecture.application.core.domains.Task;
import com.example.hexagonal_architecture.application.ports.in.task.InsertTaskInputPort;
import com.example.hexagonal_architecture.application.ports.out.task.InsertTaskOutputPort;
import com.example.hexagonal_architecture.application.ports.out.user.FindUserByIdOutputPort;

public class InsertTaskUseCase implements InsertTaskInputPort {

    private final InsertTaskOutputPort insertTaskOutputPort;
    private final FindUserByIdOutputPort findUserByIdOutputPort;

    public InsertTaskUseCase(InsertTaskOutputPort insertTaskOutputPort,
    FindUserByIdOutputPort findUserByIdOutputPort) {
        this.insertTaskOutputPort = insertTaskOutputPort;
        this.findUserByIdOutputPort = findUserByIdOutputPort;
    }

    @Override
    public void insertTask(Task task) throws Exception {
        this.findUserByIdOutputPort.findUser(task.getUserId());

        this.insertTaskOutputPort.saveTask(task);
    }

}
