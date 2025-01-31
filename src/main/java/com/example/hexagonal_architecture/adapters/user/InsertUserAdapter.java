package com.example.hexagonal_architecture.adapters.user;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.hexagonal_architecture.adapters.mappers.UserMapper;
import com.example.hexagonal_architecture.adapters.out.database.model.UserCollection;
import com.example.hexagonal_architecture.adapters.out.database.repository.UserCollectionRepository;
import com.example.hexagonal_architecture.application.core.domains.User;
import com.example.hexagonal_architecture.application.ports.out.user.InsertUserOutputPort;
import com.example.hexagonal_architecture.configurations.handler.exceptions.EmailAlreadyRegisteredException;

@Component
public class InsertUserAdapter implements InsertUserOutputPort {

    private static final String ID_PATTERN = "%s_%s"; 

    private final UserCollectionRepository userCollectionRepository;
    private final UserMapper mapper;

    public InsertUserAdapter(UserCollectionRepository userCollectionRepository, UserMapper mapper) {
        this.userCollectionRepository = userCollectionRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(User user) throws Exception {
        Optional<UserCollection> possibleUser = userCollectionRepository.findByEmail(user.getEmail());

        if (possibleUser.isPresent()) {
            throw new EmailAlreadyRegisteredException(user.getEmail());
        }

        UserCollection collection = mapper.toDatabase(user);

        collection.setId(String.format(ID_PATTERN, Instant.now().toEpochMilli(), UUID.randomUUID()));
        this.userCollectionRepository.save(collection);

    }
}
