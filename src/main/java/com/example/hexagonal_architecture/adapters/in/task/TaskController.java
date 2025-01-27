package com.example.hexagonal_architecture.adapters.in.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonal_architecture.adapters.in.task.dtos.TaskRequest;
import com.example.hexagonal_architecture.application.core.domains.Task;
import com.example.hexagonal_architecture.application.ports.in.task.InsertTaskInputPort;

@RequestMapping("/api/tasks")
@RestController
public class TaskController {

    private final InsertTaskInputPort insertTaskInputPort;

    public TaskController(InsertTaskInputPort insertTaskInputPort) {
        this.insertTaskInputPort = insertTaskInputPort;
    }

    @PostMapping
    public ResponseEntity<TaskRequest> saveTask(@RequestBody TaskRequest request) throws Exception{
        insertTaskInputPort.insertTask(new Task(request.getTitle(), request.getDescription(), request.getUserId()));
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

}
