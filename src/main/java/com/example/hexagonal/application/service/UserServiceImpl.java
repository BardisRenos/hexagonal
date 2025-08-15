package com.example.hexagonal.application.service;

import com.example.hexagonal.adapter.out.Persistence.UserEntity;
import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.domain.port.in.UserService;
import com.example.hexagonal.domain.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        UserEntity toSave = toEntity(user);
        UserEntity saved = userRepository.save(toSave);
        return toDomain(saved);
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.getUsers();
    }

    private UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setLastName(user.getLastName());
        userEntity.setAge(user.getAge());
        return userEntity;
    }

    private User toDomain(UserEntity e) {
        return User.builder()
                .name(e.getName())
                .lastName(e.getLastName())
                .age(e.getAge())
                .build();
    }
}