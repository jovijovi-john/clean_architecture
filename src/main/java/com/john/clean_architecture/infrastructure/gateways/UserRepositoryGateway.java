package com.john.clean_architecture.infrastructure.gateways;

import com.john.clean_architecture.application.gateways.UserGateway;
import com.john.clean_architecture.domain.entity.User;
import com.john.clean_architecture.infrastructure.persistence.UserEntity;
import com.john.clean_architecture.infrastructure.persistence.UserRepository;

public class UserRepositoryGateway implements UserGateway {

  private final UserRepository userRepository;
  private final UserEntityMapper userEntityMapper;

  public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
    this.userRepository = userRepository;
    this.userEntityMapper = userEntityMapper;
  }

  @Override
  public User createUser(User userDomainObj) {

    // O repository espera um objeto do tipo UserEntity, e nao userDomainObject,
    // por isso convertemos
    UserEntity userEntity = this.userEntityMapper.toEntity(userDomainObj);
    UserEntity userEntitySaved = this.userRepository.save(userEntity);

    // O retorno da interface deve ser do tipo UserDomainObject (no caso so User),
    // mas o retorno do banco é UserEntity
    // Portanto, precisamos converter UserEntity para User
    User user = this.userEntityMapper.toDomainObj(userEntitySaved);

    return user;
  }
}
