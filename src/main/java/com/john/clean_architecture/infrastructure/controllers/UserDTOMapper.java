package com.john.clean_architecture.infrastructure.controllers;

import com.john.clean_architecture.domain.entity.User;

public class UserDTOMapper {
  public CreateUserResponse toResponse(User user) {
    return new CreateUserResponse(user.username(), user.email());
  };

  public User toUser(CreateUserRequest request) {
    return new User(request.username(), request.email(), request.password());
  };
}
