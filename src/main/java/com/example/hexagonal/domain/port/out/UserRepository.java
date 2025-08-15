package com.example.hexagonal.domain.port.out;

import com.example.hexagonal.adapter.out.Persistence.UserEntity;

import java.util.List;

public interface UserRepository {
    UserEntity save(UserEntity user);
    List<UserEntity> getUsers();
}