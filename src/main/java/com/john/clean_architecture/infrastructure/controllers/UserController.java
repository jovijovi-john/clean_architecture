package com.john.clean_architecture.infrastructure.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.john.clean_architecture.application.usecases.CreateUserInteractor;
import com.john.clean_architecture.domain.entity.User;

@RestController
@RequestMapping("users")
public class UserController {

  private final CreateUserInteractor createUserInteractor;
  private final UserDTOMapper userDTOMapper;

  public UserController(CreateUserInteractor createUserInteractor, UserDTOMapper userDTOMapper) {
    this.createUserInteractor = createUserInteractor;
    this.userDTOMapper = userDTOMapper;
  };

  @PostMapping
  public CreateUserResponse create(@RequestBody CreateUserRequest request) {

    User user = this.userDTOMapper.toUser(request);
    User userSaved = this.createUserInteractor.createUser(user);

    return this.userDTOMapper.toResponse(userSaved);
  };

}
