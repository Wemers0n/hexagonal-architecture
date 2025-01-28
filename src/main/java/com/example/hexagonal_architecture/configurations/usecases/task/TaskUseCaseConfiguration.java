package com.example.hexagonal_architecture.configurations.usecases.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hexagonal_architecture.application.core.usecases.task.FindAllTasksUseCase;
import com.example.hexagonal_architecture.application.core.usecases.task.InsertTaskUseCase;
import com.example.hexagonal_architecture.application.ports.in.task.FindAllTasksByIdUserInputPort;
import com.example.hexagonal_architecture.application.ports.in.task.InsertTaskInputPort;
import com.example.hexagonal_architecture.application.ports.out.task.FindAllTasksByIdUserOutputPort;
import com.example.hexagonal_architecture.application.ports.out.task.InsertTaskOutputPort;
import com.example.hexagonal_architecture.application.ports.out.user.FindUserByIdOutputPort;

@Configuration
public class TaskUseCaseConfiguration {

    @Bean
    InsertTaskInputPort insertTaskInputPort(InsertTaskOutputPort insertTaskOutputPort, FindUserByIdOutputPort findUserByIdOutputPort){
        return new InsertTaskUseCase(insertTaskOutputPort, findUserByIdOutputPort);
    }

    @Bean
    FindAllTasksByIdUserInputPort findAllTasksByIdUserInputPort(FindAllTasksByIdUserOutputPort findAllTasksByIdUserOutputPort){
        return new FindAllTasksUseCase(findAllTasksByIdUserOutputPort);
    }

}
