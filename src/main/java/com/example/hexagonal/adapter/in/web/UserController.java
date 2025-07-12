package com.example.hexagonal.adapter.in.web;

import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.domain.port.in.CreateUserUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public User create(@RequestParam String name) {
        return createUserUseCase.createUser(name);
    }
}