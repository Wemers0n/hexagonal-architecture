package com.example.hexagonal_architecture.adapters.out.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hexagonal_architecture.adapters.out.database.model.TaskCollection;

public interface TaskCollectionRepository extends MongoRepository<TaskCollection, String>{

}
