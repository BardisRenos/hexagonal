package com.example.hexagonal.domain.port.in;

import com.example.hexagonal.adapter.out.Persistence.UserEntity;
import com.example.hexagonal.domain.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<UserEntity> getUsers();
}