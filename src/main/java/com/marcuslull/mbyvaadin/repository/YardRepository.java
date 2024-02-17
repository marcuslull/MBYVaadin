package com.marcuslull.mbyvaadin.repository;

import com.marcuslull.mbyvaadin.model.Yard;
import org.springframework.data.repository.CrudRepository;

public interface YardRepository extends CrudRepository<Yard, Long> {
    Yard findYardByName(String name);
}