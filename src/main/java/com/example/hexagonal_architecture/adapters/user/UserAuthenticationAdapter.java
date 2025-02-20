package com.example.hexagonal_architecture.adapters.user;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.hexagonal_architecture.adapters.in.user.dtos.AuthTokenResponse;
import com.example.hexagonal_architecture.adapters.in.user.dtos.LoginRequest;
import com.example.hexagonal_architecture.adapters.out.database.model.UserCollection;
import com.example.hexagonal_architecture.application.ports.out.user.UserAuthenticationOutputPort;
import com.example.hexagonal_architecture.configurations.auth.jwt.JWT;
import com.example.hexagonal_architecture.configurations.handler.exceptions.BadCredentialException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserAuthenticationAdapter implements UserAuthenticationOutputPort{

    private final AuthenticationManager authenticationManager;
    private final JWT jwt;

    public UserAuthenticationAdapter(AuthenticationManager authenticationManager, JWT jwt) {
        this.authenticationManager = authenticationManager;
        this.jwt = jwt;
    }

    @Override
    public AuthTokenResponse authenticate(LoginRequest request) throws Exception {
       Authentication authentication = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

       UserCollection user;

       try{
        authentication = authenticationManager.authenticate(authentication);
        user = jwt.getUser(authentication);
       } catch (Exception e){
        log.error("Bad credentials");
        throw new BadCredentialException();
       }
       return jwt.generateToken(authentication);
    }

}
