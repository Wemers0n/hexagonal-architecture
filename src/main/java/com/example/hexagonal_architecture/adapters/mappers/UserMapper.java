package com.example.hexagonal_architecture.adapters.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.hexagonal_architecture.adapters.out.database.model.UserCollection;
import com.example.hexagonal_architecture.application.core.domains.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    User toDomain(UserCollection collection);

    UserCollection toDatabase(User domain);

}
