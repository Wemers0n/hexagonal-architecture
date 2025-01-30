package com.example.hexagonal_architecture.adapters.task;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.hexagonal_architecture.adapters.out.database.model.TaskCollection;
import com.example.hexagonal_architecture.adapters.out.database.repository.TaskCollectionRepository;
import com.example.hexagonal_architecture.application.core.domains.Task;
import com.example.hexagonal_architecture.application.ports.out.task.InsertTaskOutputPort;

@Component
public class InsertTaskAdapter implements InsertTaskOutputPort {

    private static final String ID_PATTERN = "%s_%s";

    private final TaskCollectionRepository taskCollectionRepository;

    public InsertTaskAdapter(TaskCollectionRepository taskCollectionRepository) {
        this.taskCollectionRepository = taskCollectionRepository;
    }

    @Override
    public void saveTask(Task task) throws Exception {
        this.taskCollectionRepository.save(TaskCollection.builder()
            .id(String.format(ID_PATTERN, Instant.now().toEpochMilli(), UUID.randomUUID()))
            .userId(task.getUserId())
            .title(task.getTitle())
            .description(task.getDescription())
            .priority(task.getPriority())
            .startAt(task.getStartAt())
            .endAt(task.getEndAt())
            .createdAt(LocalDateTime.now())
            .build());
    }
}
