package com.marcuslull.mbyvaadin.repository;

import com.marcuslull.mbyvaadin.model.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long> {
    Plant findPlantByName(String name);
}