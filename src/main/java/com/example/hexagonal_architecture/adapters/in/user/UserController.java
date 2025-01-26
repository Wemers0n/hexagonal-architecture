package com.example.hexagonal_architecture.adapters.in.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonal_architecture.adapters.in.user.dtos.UserRequest;
import com.example.hexagonal_architecture.application.core.domains.User;
import com.example.hexagonal_architecture.application.ports.in.user.InsertUserInputPort;

@RequestMapping("/api/user")
@RestController
public class UserController {

    private final InsertUserInputPort insertUserInputPort;

    public UserController(InsertUserInputPort insertUserInputPort) {
        this.insertUserInputPort = insertUserInputPort;
    }

    @PostMapping
    public ResponseEntity<UserRequest> saveUser(@RequestBody UserRequest request) throws Exception{
        insertUserInputPort.insertUser(new User(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword()));
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

}
