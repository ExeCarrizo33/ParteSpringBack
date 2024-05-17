package com.projectoSpring.springboot.backend.apirest.repositories;

import com.projectoSpring.springboot.backend.apirest.models.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
