package com.projectoSpring.springboot.backend.apirest.models.dao;

import com.projectoSpring.springboot.backend.apirest.models.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserDao extends CrudRepository<User,Long> {

    Optional<User> findByUsername(String username);


}
