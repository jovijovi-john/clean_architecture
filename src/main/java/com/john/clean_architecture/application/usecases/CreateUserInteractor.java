package com.john.clean_architecture.application.usecases;

import com.john.clean_architecture.application.gateways.UserGateway;
import com.john.clean_architecture.domain.entity.User;

// É o mesmo que o service do spring
public class CreateUserInteractor {

  private final UserGateway userGateway;

  // Injeção de dependências
  public CreateUserInteractor(UserGateway userGateway) {
    this.userGateway = userGateway;
  }

  public User createUser(User user) {
    return userGateway.createUser(user);
  };
}
