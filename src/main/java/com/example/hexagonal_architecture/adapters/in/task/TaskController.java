package com.example.hexagonal_architecture.adapters.in.task;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonal_architecture.adapters.in.task.dtos.TaskRequestDTO;
import com.example.hexagonal_architecture.adapters.out.database.model.UserCollection;
import com.example.hexagonal_architecture.application.core.domains.Task;
import com.example.hexagonal_architecture.application.ports.in.task.InsertTaskInputPort;
import com.example.hexagonal_architecture.application.ports.out.task.FindAllTasksByIdUserOutputPort;
import com.example.hexagonal_architecture.application.ports.out.user.FindUserByEmailOutputPort;

@RequestMapping("/api/tasks")
@RestController
public class TaskController {

    private final InsertTaskInputPort insertTaskInputPort;
    private final FindAllTasksByIdUserOutputPort findAllTasksByIdUserOutputPort;
    private final FindUserByEmailOutputPort findUserByEmailOutputPort;   

    public TaskController(InsertTaskInputPort insertTaskInputPort,
            FindAllTasksByIdUserOutputPort findAllTasksByIdUserOutputPort,
            FindUserByEmailOutputPort findUserByEmailOutputPort) {
        this.insertTaskInputPort = insertTaskInputPort;
        this.findAllTasksByIdUserOutputPort = findAllTasksByIdUserOutputPort;
        this.findUserByEmailOutputPort = findUserByEmailOutputPort;
    }

    @GetMapping()
    public ResponseEntity<List<Task>> allTasks(Authentication authentication) throws Exception{

        UserCollection user = (UserCollection) authentication.getPrincipal();
        String userId = user.getId();
        var tasks = this.findAllTasksByIdUserOutputPort.findAllUserTasks(userId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskRequestDTO> saveTask(@RequestBody TaskRequestDTO request, Authentication authentication) throws Exception{
        var user = this.findUserByEmailOutputPort.findByEmail(extractUserIdFromToken(authentication));        
        
        insertTaskInputPort.insertTask(new Task(user.getId(), request.getTitle(), request.getDescription(), request.getPriority(), request.getStartAt(), request.getEndAt()));
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    private String extractUserIdFromToken(Authentication authentication){
        if (authentication == null || !(authentication.getPrincipal() instanceof Jwt jwt)){
            throw new IllegalArgumentException("JWT invalido ou nao autenticado");
        }
        System.out.println("Claims" + jwt.getClaims());
        return jwt.getClaimAsString("sub");
    }

}
