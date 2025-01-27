package com.example.hexagonal_architecture.adapters.user;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.hexagonal_architecture.adapters.out.database.model.UserCollection;
import com.example.hexagonal_architecture.adapters.out.database.repository.UserCollectionRepository;
import com.example.hexagonal_architecture.application.core.domains.User;
import com.example.hexagonal_architecture.application.ports.out.user.FindUserByIdOutputPort;

@Component
public class FindUserByIdAdapter implements FindUserByIdOutputPort{

    private final UserCollectionRepository userCollectionRepository;

    public FindUserByIdAdapter(UserCollectionRepository userCollectionRepository) {
        this.userCollectionRepository = userCollectionRepository;
    }

    @Override
    public User findUser(String id) throws Exception {

       Optional<UserCollection> userId = this.userCollectionRepository.findById(id);

       if(userId.isEmpty()){
        throw new RuntimeException("User not found");
       }
       
       UserCollection user = userId.get();

       return new User(user.getId(),
       user.getFirstName(),
       user.getLastName(),
       user.getEmail(),
       user.getPassword());
    }

}
