package com.marcuslull.mbyvaadin.config;

import com.marcuslull.mbyvaadin.model.User;
import com.marcuslull.mbyvaadin.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final UserRepository userRepository;

    public BootstrapData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("user@email.com");
        // use https://bcrypt-generator.com/
        user.setPassword("$2a$12$HCkrs1z9lygxZH5gNrLOD.YtHT6e/a09MaqBPuw22pVLMVYhlAgmC");
        userRepository.save(user);
    }
}
