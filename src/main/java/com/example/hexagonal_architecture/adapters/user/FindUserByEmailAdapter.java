package com.example.hexagonal_architecture.adapters.user;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexagonal_architecture.adapters.out.database.model.UserCollection;
import com.example.hexagonal_architecture.adapters.out.database.repository.UserCollectionRepository;
import com.example.hexagonal_architecture.application.core.domains.User;
import com.example.hexagonal_architecture.application.ports.out.user.FindUserByEmailOutputPort;

@Component
public class FindUserByEmailAdapter implements FindUserByEmailOutputPort{

    private final UserCollectionRepository userCollectionRepository;

    public FindUserByEmailAdapter(UserCollectionRepository userCollectionRepository) {
        this.userCollectionRepository = userCollectionRepository;
    }

    @Override
    public User findByEmail(String email) throws Exception{
        Optional<UserCollection> userByEmail = userCollectionRepository.findByEmail(email);
    
        if (userByEmail.isEmpty()) {
            throw new RuntimeException("Email not found");
        }
    
        UserCollection user = userByEmail.get();
    
        return new User(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword());
    }
}
