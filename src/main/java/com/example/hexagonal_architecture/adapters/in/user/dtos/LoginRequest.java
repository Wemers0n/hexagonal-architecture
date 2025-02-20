package com.example.hexagonal_architecture.adapters.in.user.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    private String email;
    private String password;
}
