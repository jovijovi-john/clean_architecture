package com.john.clean_architecture.infrastructure.persistence;

import java.util.UUID;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}
