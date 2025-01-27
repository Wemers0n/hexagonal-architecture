package com.example.hexagonal_architecture.application.core.domains;

public class Task {

    private String id;
    private String userId;
    private String title;
    private String description;
    private Boolean isDone;

    public Task(Boolean isDone) {
        this.isDone = false;
    }

    public Task(String id, String userId, String title, String description, Boolean isDone) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.isDone = isDone;
    }

    public Task(String id, String userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.isDone = false;
    }

    public Task(String userId, String title, String description, Boolean isDone) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.isDone = isDone;
    }

    public Task(String title, String description, String userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.isDone = false;
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isDone = false;
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

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

}
