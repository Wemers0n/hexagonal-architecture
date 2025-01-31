package com.example.hexagonal_architecture.application.core.domains;

import java.time.LocalDateTime;

public class Task {

    private String id;
    private String userId;
    private String title;
    private String description;
    private String priority;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private LocalDateTime createdAt;

    public Task() {
    }

    public Task(String id, String userId, String title, String description, String priority, LocalDateTime startAt, LocalDateTime endAt, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.startAt = startAt;
        this.endAt = endAt;
        this.createdAt = createdAt;
        }

    public Task(String userId, String title, String description, String priority, LocalDateTime startAt, LocalDateTime endAt) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public Task(String title, String description, String priority, LocalDateTime startAt, LocalDateTime endAt) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}