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

@Component
public class InsertTaskAdapter implements InsertTaskOutputPort {

    private static final String ID_PATTERN = "%s_%s";

    private final TaskCollectionRepository taskCollectionRepository;
    private final TaskMapper mapper;

    public InsertTaskAdapter(TaskCollectionRepository taskCollectionRepository, TaskMapper mapper) {
        this.taskCollectionRepository = taskCollectionRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveTask(Task task) throws Exception {
        
        TaskCollection collection = mapper.toDatabase(task);

        collection.setId(String.format(ID_PATTERN, Instant.now().toEpochMilli(), UUID.randomUUID()));
        collection.setCreatedAt(LocalDateTime.now());

        this.taskCollectionRepository.save(collection);
    }
}
