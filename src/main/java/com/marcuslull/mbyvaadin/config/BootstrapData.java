package com.marcuslull.mbyvaadin.config;

import com.marcuslull.mbyvaadin.model.User;
import com.marcuslull.mbyvaadin.model.Yard;
import com.marcuslull.mbyvaadin.model.enums.HardinessZone;
import com.marcuslull.mbyvaadin.model.enums.YardSubType;
import com.marcuslull.mbyvaadin.repository.UserRepository;
import com.marcuslull.mbyvaadin.repository.YardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final YardRepository yardRepository;

    public BootstrapData(UserRepository userRepository, YardRepository yardRepository) {
        this.userRepository = userRepository;
        this.yardRepository = yardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("user@email.com");
        // use https://bcrypt-generator.com/
        user.setPassword("$2a$12$HCkrs1z9lygxZH5gNrLOD.YtHT6e/a09MaqBPuw22pVLMVYhlAgmC");
        user.setEnabled(true);
        userRepository.save(user);

        Yard yard = new Yard();
        yard.setName("MyYard");
        yard.setHardinessZone(HardinessZone.ZONE_6);
        yard.setYardSubType(YardSubType.BACK_YARD);
        yard.setUser(user);
        yardRepository.save(yard);
    }
}
