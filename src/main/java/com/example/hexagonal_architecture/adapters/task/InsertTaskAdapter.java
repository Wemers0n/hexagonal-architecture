package com.example.hexagonal_architecture.adapters.task;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.hexagonal_architecture.adapters.mappers.TaskMapper;
import com.example.hexagonal_architecture.adapters.out.database.model.TaskCollection;
import com.example.hexagonal_architecture.adapters.out.database.repository.TaskCollectionRepository;
import com.example.hexagonal_architecture.application.core.domains.Task;
import com.example.hexagonal_architecture.application.ports.out.task.InsertTaskOutputPort;
import com.example.hexagonal_architecture.application.ports.out.user.FindUserByIdOutputPort;
import com.example.hexagonal_architecture.configurations.handler.exceptions.InvalidDateException;

@Component
public class InsertTaskAdapter implements InsertTaskOutputPort {

    private static final String ID_PATTERN = "%s_%s";

    private final TaskCollectionRepository taskCollectionRepository;
    private final FindUserByIdOutputPort findUserByIdOutputPort;
    private final TaskMapper mapper;

    public InsertTaskAdapter(TaskCollectionRepository taskCollectionRepository, FindUserByIdOutputPort findUserByIdOutputPort, TaskMapper mapper) {
        this.taskCollectionRepository = taskCollectionRepository;
        this.findUserByIdOutputPort = findUserByIdOutputPort;
        this.mapper = mapper;
    }

    @Override
    public void saveTask(Task task) throws Exception {

        this.validateUserExists(task);
        // this.validateStartAndEndDate(task);
    
        TaskCollection collection = mapper.toDatabase(task);
        collection.setCreatedAt(LocalDateTime.now());

        this.dateValidation(collection);

        this.save(collection);
    }

    private void save(TaskCollection collection){
        collection.setId(String.format(ID_PATTERN, Instant.now().toEpochMilli(), UUID.randomUUID()));
        this.taskCollectionRepository.save(collection);
    }

    private void validateUserExists(Task task) throws Exception{
        this.findUserByIdOutputPort.findUser(task.getUserId());
    }

    private void dateValidation(TaskCollection collection) throws Exception{
        if (collection.getStartAt().isAfter(collection.getEndAt())){
            throw new InvalidDateException("The start date must be greater than the end date");
        }

        if (collection.getCreatedAt().isAfter(collection.getStartAt()) || collection.getCreatedAt().isAfter(collection.getEndAt())){
            throw new InvalidDateException("The start/end date must be greater than the current date");
        }
    }
}
