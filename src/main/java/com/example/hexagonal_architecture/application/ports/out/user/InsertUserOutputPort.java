package com.example.hexagonal_architecture.application.ports.out.user;

import com.example.hexagonal_architecture.application.core.domains.User;

public interface InsertUserOutputPort {

    void save(User user) throws Exception;
}
