package com.example.hexagonal_architecture.adapters.user;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.hexagonal_architecture.adapters.out.database.model.UserCollection;
import com.example.hexagonal_architecture.adapters.out.database.repository.UserCollectionRepository;
import com.example.hexagonal_architecture.application.core.domains.User;
import com.example.hexagonal_architecture.application.ports.out.user.InsertUserOutputPort;

@Component
public class InsertUserAdapter implements InsertUserOutputPort {

    private static final String ID_PATERN = "%s_%s"; 

    private final UserCollectionRepository userCollectionRepository;

    public InsertUserAdapter(UserCollectionRepository userCollectionRepository) {
        this.userCollectionRepository = userCollectionRepository;
    }

    @Override
    public void save(User user) throws Exception {
        Optional<UserCollection> possibleUser = userCollectionRepository.findByEmail(user.getEmail());

        if (possibleUser.isPresent()) {
            throw new IllegalArgumentException("Email ja esta sendo usado");
        }

        userCollectionRepository.save(UserCollection.builder()
            .id(String.format(ID_PATERN, Instant.now().toEpochMilli(), UUID.randomUUID()))
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .email(user.getEmail())
            .password(user.getPassword())
            .build());
    }
}
