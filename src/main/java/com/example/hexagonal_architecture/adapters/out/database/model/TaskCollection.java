package com.example.hexagonal_architecture.adapters.out.database.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "task_collection")
public class TaskCollection {

    @Id
    private String id;
    private String userId;
    private String title;
    private String description;
    private Boolean isDone;

}
