package com.projectoSpring.springboot.backend.apirest.models.dao;

import com.projectoSpring.springboot.backend.apirest.models.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User,Long> {

    public User findByUsername(String username);


}
