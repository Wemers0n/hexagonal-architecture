package com.example.hexagonal_architecture.adapters.out.database.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.hexagonal_architecture.adapters.out.database.model.TaskCollection;

public interface TaskCollectionRepository extends MongoRepository<TaskCollection, String>{

    @Query(value = "{'userId': ?0}")
    List<TaskCollection> findAllById(String userId);

}
