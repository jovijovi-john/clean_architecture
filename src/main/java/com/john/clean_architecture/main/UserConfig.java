package com.john.clean_architecture.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.john.clean_architecture.application.gateways.UserGateway;
import com.john.clean_architecture.application.usecases.CreateUserInteractor;
import com.john.clean_architecture.infrastructure.controllers.UserDTOMapper;
import com.john.clean_architecture.infrastructure.gateways.UserEntityMapper;
import com.john.clean_architecture.infrastructure.gateways.UserRepositoryGateway;
import com.john.clean_architecture.infrastructure.persistence.UserRepository;

@Configuration
public class UserConfig {

  @Bean
  CreateUserInteractor createUserInteractor(UserGateway userGateway) {
    return new CreateUserInteractor(userGateway);
  }

  @Bean
  UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
    return new UserRepositoryGateway(userRepository, userEntityMapper);
  }

  @Bean
  UserEntityMapper userEntityMapper() {
    return new UserEntityMapper();
  }

  @Bean
  UserDTOMapper userDTOMapper() {
    return new UserDTOMapper();
  }
}
