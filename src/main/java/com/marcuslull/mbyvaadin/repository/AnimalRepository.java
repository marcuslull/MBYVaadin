package com.marcuslull.mbyvaadin.repository;

import com.marcuslull.mbyvaadin.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
}