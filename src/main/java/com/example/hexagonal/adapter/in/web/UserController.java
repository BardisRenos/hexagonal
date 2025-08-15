package com.example.hexagonal.adapter.in.web;

import com.example.hexagonal.adapter.out.Persistence.UserEntity;
import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.domain.port.in.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService createUserUseCase;

    @PostMapping("/new")
    public User create(@RequestBody User user) {
        return createUserUseCase.createUser(user);
    }

    @GetMapping("/all")
    public List<UserEntity> getUsers() {
        return createUserUseCase.getUsers();
    }
}