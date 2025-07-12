package com.example.hexagonal.domain.port.in;

import com.example.hexagonal.domain.model.User;

public interface CreateUserUseCase {
    User createUser(String name);
}