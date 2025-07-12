package com.example.hexagonal.adapter.out.Persistence;

import com.example.hexagonal.domain.model.User;
import com.example.hexagonal.domain.port.out.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceAdapter implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserPersistenceAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        UserEntity saved = jpaUserRepository.save(entity);
        user.setId(saved.getId());
        return user;
    }
}