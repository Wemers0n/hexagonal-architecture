package com.example.hexagonal_architecture.configurations.auth.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hexagonal_architecture.adapters.out.database.repository.UserCollectionRepository;

@Service
public class UserDetailsConfig implements UserDetailsService{

    private final UserCollectionRepository collectionRepository;

    public UserDetailsConfig(UserCollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return collectionRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found whith email" + email)); 
    }

}
