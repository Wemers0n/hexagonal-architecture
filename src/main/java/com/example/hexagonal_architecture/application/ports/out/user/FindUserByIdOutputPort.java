package com.example.hexagonal_architecture.application.ports.out.user;

import com.example.hexagonal_architecture.application.core.domains.User;

public interface FindUserByIdOutputPort {

    User findUser(String id) throws Exception;
}
