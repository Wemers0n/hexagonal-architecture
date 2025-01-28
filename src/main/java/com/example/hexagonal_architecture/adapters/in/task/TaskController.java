package com.example.hexagonal_architecture.adapters.in.task;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonal_architecture.adapters.in.task.dtos.TaskRequestDTO;
import com.example.hexagonal_architecture.application.core.domains.Task;
import com.example.hexagonal_architecture.application.ports.in.task.InsertTaskInputPort;
import com.example.hexagonal_architecture.application.ports.out.task.FindAllTasksByIdUserOutputPort;

@RequestMapping("/api/tasks")
@RestController
public class TaskController {

    private final InsertTaskInputPort insertTaskInputPort;
    private final FindAllTasksByIdUserOutputPort findAllTasksByIdUserOutputPort;

    public TaskController(InsertTaskInputPort insertTaskInputPort, FindAllTasksByIdUserOutputPort findAllTasksByIdUserOutputPort) {
        this.insertTaskInputPort = insertTaskInputPort;
        this.findAllTasksByIdUserOutputPort = findAllTasksByIdUserOutputPort;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Task>> allTasks(@PathVariable String userId) throws Exception{
        var tasks = this.findAllTasksByIdUserOutputPort.findAllUserTasks(userId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskRequestDTO> saveTask(@RequestBody TaskRequestDTO request) throws Exception{
        insertTaskInputPort.insertTask(new Task(request.getTitle(), request.getDescription(), request.getUserId()));
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

}
