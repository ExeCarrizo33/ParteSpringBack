package com.projectoSpring.springboot.backend.apirest.models.services;

import com.projectoSpring.springboot.backend.apirest.models.entity.Role;
import com.projectoSpring.springboot.backend.apirest.models.entity.User;
import com.projectoSpring.springboot.backend.apirest.models.entity.UserRequest;
import com.projectoSpring.springboot.backend.apirest.repositories.RoleRepository;
import com.projectoSpring.springboot.backend.apirest.repositories.UserRepository;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(@NonNull Long id) {
        return repository.findById(id);
    }


    @Transactional
    @Override
    public User save(User user) {
        user.setRoles(getRoles((IUser) user));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    @Transactional
    public Optional<User> update(UserRequest user,Long id) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            User userDb = optionalUser.get();
            userDb.setName(user.getName());
            userDb.setEmail(user.getEmail());
            userDb.setLastname(user.getLastname());
            userDb.setUsername(user.getUsername());

            userDb.setRoles(getRoles(user));
            return Optional.of(repository.save(userDb));
        }
        return Optional.empty();


    }


    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private List<Role> getRoles(IUser user) {
        List<Role> roles = new ArrayList<>();
        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
        optionalRoleUser.ifPresent(roles::add);

        if (user.isAdmin()){
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }
        return roles;
    }
}
