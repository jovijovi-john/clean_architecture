package com.john.clean_architecture.application.gateways;

import com.john.clean_architecture.domain.entity.User;

// Estrutura genérica
public interface UserGateway {
  User createUser(User user);
}