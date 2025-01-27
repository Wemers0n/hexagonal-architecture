package com.example.hexagonal_architecture.adapters.in.task.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {

    private String userId;
    private String title;
    private String description;
}
