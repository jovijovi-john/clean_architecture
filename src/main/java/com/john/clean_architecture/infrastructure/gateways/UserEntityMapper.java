package com.john.clean_architecture.infrastructure.gateways;

import com.john.clean_architecture.domain.entity.User;
import com.john.clean_architecture.infrastructure.persistence.UserEntity;

public class UserEntityMapper {

  public UserEntity toEntity(User userDomainObj) {
    return new UserEntity(userDomainObj.username(), userDomainObj.email(), userDomainObj.password());
  };

  public User toDomainObj(UserEntity userEntity) {
    return new User(userEntity.getUsername(), userEntity.getEmail(), userEntity.getPassword(null));
  }
}
