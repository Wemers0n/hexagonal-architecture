package com.example.hexagonal_architecture.application.ports.in.user;

import com.example.hexagonal_architecture.adapters.in.user.dtos.AuthTokenResponse;
import com.example.hexagonal_architecture.adapters.in.user.dtos.LoginRequest;

public interface UserAuthenticationInputPort {

    AuthTokenResponse authenticate(LoginRequest request) throws Exception;
}
