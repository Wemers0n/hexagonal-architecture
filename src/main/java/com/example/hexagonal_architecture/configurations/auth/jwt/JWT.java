package com.example.hexagonal_architecture.configurations.auth.jwt;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.example.hexagonal_architecture.adapters.in.user.dtos.AuthTokenResponse;
import com.example.hexagonal_architecture.adapters.out.database.model.UserCollection;
import com.example.hexagonal_architecture.adapters.out.database.repository.UserCollectionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JWT {

    private final JwtEncoder encoder;
    private final UserCollectionRepository userCollectionRepository;

    public AuthTokenResponse generateToken(Authentication authentication){
        Instant now = Instant.now();
        long expiry = 3600L;

        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        final var user = this.getUser(authentication);

        var claims = JwtClaimsSet.builder()
                        .issuer("hexagonal")
                        .issuedAt(now)
                        .expiresAt(now.plusSeconds(expiry))
                        .subject(user.getEmail())
                        .claim("scope", scope)
                        .build();

        var token = encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        user.setAuthenticated(true);
        userCollectionRepository.save(user);

        return AuthTokenResponse.builder()
        .token_type("Bearer")
        .access_token(token)
        .email(user.getEmail())
        .build();
    }

    public UserCollection getUser(Authentication authentication){
        return (UserCollection) authentication.getPrincipal();
    }

}
