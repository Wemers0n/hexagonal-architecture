package com.example.hexagonal_architecture.configurations.usecases.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hexagonal_architecture.adapters.user.InsertUserAdapter;
import com.example.hexagonal_architecture.adapters.user.UserAuthenticationAdapter;
import com.example.hexagonal_architecture.application.core.usecases.user.InsertUserUseCase;
import com.example.hexagonal_architecture.application.core.usecases.user.UserAuthenticationUseCase;
import com.example.hexagonal_architecture.application.ports.in.user.InsertUserInputPort;
import com.example.hexagonal_architecture.application.ports.in.user.UserAuthenticationInputPort;

@Configuration
public class UserUseCaseConfiguration {

    @Bean
    InsertUserInputPort insertUserInputPort(InsertUserAdapter insertUserAdapter){
        return new InsertUserUseCase(insertUserAdapter);
    }

    @Bean
    UserAuthenticationInputPort userAuthenticationInputPort(UserAuthenticationAdapter userAuthenticationAdapter){
        return new UserAuthenticationUseCase(userAuthenticationAdapter);
    }
}
