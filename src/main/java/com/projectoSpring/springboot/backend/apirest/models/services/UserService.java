package com.projectoSpring.springboot.backend.apirest.models.services;

import com.projectoSpring.springboot.backend.apirest.models.entity.User;
import com.projectoSpring.springboot.backend.apirest.models.entity.UserRequest;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface  UserService {

    List<User> findAll();

    Optional<User> findById(@NotNull Long id);

    User save(User user);

    Optional<User> update(UserRequest user, Long id);

    void deleteById(Long id);
}
