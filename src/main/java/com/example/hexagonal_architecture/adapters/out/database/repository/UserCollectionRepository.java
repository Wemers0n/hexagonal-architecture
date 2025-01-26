package com.example.hexagonal_architecture.adapters.out.database.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.hexagonal_architecture.adapters.out.database.model.UserCollection;

public interface UserCollectionRepository extends MongoRepository<UserCollection, String>{

    @Query(value = "{'email': ?0}")
    Optional<UserCollection> findByEmail(String email);
}
