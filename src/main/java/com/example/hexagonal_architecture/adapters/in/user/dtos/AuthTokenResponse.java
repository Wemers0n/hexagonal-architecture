package com.example.hexagonal_architecture.adapters.in.user.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthTokenResponse {

    private String token_type;
    private String access_token;
    private String username;
}
