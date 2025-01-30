package com.example.hexagonal_architecture.adapters.in.task.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {

    private String userId;
    private String title;
    private String description;
    private String priority;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
}
