package com.marcuslull.mbyvaadin.config;

import com.marcuslull.mbyvaadin.model.Plant;
import com.marcuslull.mbyvaadin.model.User;
import com.marcuslull.mbyvaadin.model.Yard;
import com.marcuslull.mbyvaadin.model.enums.*;
import com.marcuslull.mbyvaadin.repository.PlantRepository;
import com.marcuslull.mbyvaadin.repository.UserRepository;
import com.marcuslull.mbyvaadin.repository.YardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final YardRepository yardRepository;
    private final PlantRepository plantRepository;

    public BootstrapData(UserRepository userRepository, YardRepository yardRepository,
                         PlantRepository plantRepository) {
        this.userRepository = userRepository;
        this.yardRepository = yardRepository;
        this.plantRepository = plantRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("user@email.com");
        // use https://bcrypt-generator.com/
        user.setPassword("$2a$12$HCkrs1z9lygxZH5gNrLOD.YtHT6e/a09MaqBPuw22pVLMVYhlAgmC");
        user.setEnabled(true);

        Yard yard = new Yard();
        yard.setName("MyYard");
        yard.setHardinessZone(HardinessZone.ZONE_6);
        yard.setYardSubType(YardSubType.BACK_YARD);
        yard.setUser(user);

        Plant plant = new Plant();
        plant.setName("Rose");
        plant.setHardinessZone(HardinessZone.ZONE_6);
        plant.setPlantSubType(PlantSubType.FLOWER);
        plant.setSoilType(SoilType.LOAM);
        plant.setSunExposure(SunExposure.PARTIAL_SUN);
        plant.setNativeAreaType(NativeAreaType.PRAIRIE);
        plant.setWateringFrequency(WateringFrequency.EVERY_OTHER_DAY);
        plant.setYard(yard);

        userRepository.save(user);
        yardRepository.save(yard);
        plantRepository.save(plant);
    }
}
