package com.projectoSpring.springboot.backend.apirest.repositories;

import com.projectoSpring.springboot.backend.apirest.models.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String name);
}
