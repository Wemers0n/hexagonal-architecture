package com.example.hexagonal_architecture.application.ports.out.user;

import com.example.hexagonal_architecture.adapters.in.user.dtos.AuthTokenResponse;
import com.example.hexagonal_architecture.adapters.in.user.dtos.LoginRequest;

public interface UserAuthenticationOutputPort {

    AuthTokenResponse authenticate(LoginRequest request) throws Exception;
}
