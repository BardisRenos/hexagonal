package com.example.hexagonal.adapter.db;

import com.example.hexagonal.adapter.out.Persistence.UserEntity;
import com.example.hexagonal.domain.port.out.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class UserDataInitializer {

    private final UserRepository userRepository;
    private final Random random = new Random();

    @PostConstruct
    public void init() {
        List<String> firstNames = List.of("John", "Jane", "Alex", "Emily", "Chris", "Sarah", "Michael", "Emma", "David", "Sophia");
        List<String> lastNames = List.of("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez");

        IntStream.range(0, 10).forEach(i -> {
            UserEntity user = new UserEntity();
            user.setName(firstNames.get(random.nextInt(firstNames.size())));
            user.setLastName(lastNames.get(random.nextInt(lastNames.size())));
            user.setAge(18 + random.nextInt(50));
            userRepository.save(user);
        });

        System.out.println("✅ Inserted 10 random users into the database.");
    }
}
