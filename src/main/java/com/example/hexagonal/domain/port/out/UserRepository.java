package com.example.hexagonal.domain.port.out;

import com.example.hexagonal.domain.model.User;

public interface UserRepository {
    User save(User user);
}