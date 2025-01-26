package com.example.hexagonal_architecture.application.ports.in.user;

import com.example.hexagonal_architecture.application.core.domains.User;

public interface InsertUserInputPort {

    void insertUser(User user) throws Exception;
}
