package com.example.hexagonal.application.service;

import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.domain.port.in.CreateUserUseCase;
import com.example.hexagonal.domain.port.out.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name) {
        User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }
}