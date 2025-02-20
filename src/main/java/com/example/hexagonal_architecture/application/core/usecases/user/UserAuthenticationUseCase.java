package com.example.hexagonal_architecture.application.core.usecases.user;

import com.example.hexagonal_architecture.adapters.in.user.dtos.AuthTokenResponse;
import com.example.hexagonal_architecture.adapters.in.user.dtos.LoginRequest;
import com.example.hexagonal_architecture.application.ports.in.user.UserAuthenticationInputPort;
import com.example.hexagonal_architecture.application.ports.out.user.UserAuthenticationOutputPort;

public class UserAuthenticationUseCase implements UserAuthenticationInputPort{

    private final UserAuthenticationOutputPort authenticationOutputPort;
    
    public UserAuthenticationUseCase(UserAuthenticationOutputPort authenticationOutputPort) {
        this.authenticationOutputPort = authenticationOutputPort;
    }

    @Override
    public AuthTokenResponse authenticate(LoginRequest request) throws Exception {
      return authenticationOutputPort.authenticate(request);
    }

}
