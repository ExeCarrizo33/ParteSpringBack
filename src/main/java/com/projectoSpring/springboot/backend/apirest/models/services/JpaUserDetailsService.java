package com.projectoSpring.springboot.backend.apirest.models.services;

import com.projectoSpring.springboot.backend.apirest.models.dao.IUserDao;
import com.projectoSpring.springboot.backend.apirest.models.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> OpUser = iUserDao.findByUsername(username);

        if (OpUser.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Username %s not found", username));
        }
        User user = OpUser.get();
        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(username,
                passwordEncoder.encode(user.getPassword()),
                true,
                true,
                true,
                true,
                authorities);
    }
}
