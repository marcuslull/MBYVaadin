package com.marcuslull.mbyvaadin.repository;

import com.marcuslull.mbyvaadin.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findUserByEmail(String email);
}