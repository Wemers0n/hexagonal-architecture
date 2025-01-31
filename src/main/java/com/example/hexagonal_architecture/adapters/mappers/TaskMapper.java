package com.example.hexagonal_architecture.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.hexagonal_architecture.adapters.out.database.model.TaskCollection;
import com.example.hexagonal_architecture.application.core.domains.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);

    Task toDomain(TaskCollection collection);

    TaskCollection toDatabase(Task task);

}
