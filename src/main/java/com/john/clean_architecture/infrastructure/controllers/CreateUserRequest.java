package com.john.clean_architecture.infrastructure.controllers;

public record CreateUserRequest(String username, String email, String password) {
};