package com.example.hexagonal_architecture.application.core.usecases.user;

import com.example.hexagonal_architecture.application.core.domains.User;
import com.example.hexagonal_architecture.application.ports.in.user.InsertUserInputPort;
import com.example.hexagonal_architecture.application.ports.out.user.InsertUserOutputPort;

public class InsertUserUseCase implements InsertUserInputPort{

    private final InsertUserOutputPort insertUserOutputPort;

    public InsertUserUseCase(InsertUserOutputPort insertUserOutputPort) {
        this.insertUserOutputPort = insertUserOutputPort;
    }

    @Override
    public void insertUser(User user) throws Exception {
        this.insertUserOutputPort.save(user);
    }

}
