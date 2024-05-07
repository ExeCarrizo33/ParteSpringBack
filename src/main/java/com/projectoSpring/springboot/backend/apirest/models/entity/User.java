package com.projectoSpring.springboot.backend.apirest.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(unique = true, length = 20)
    private String username;

    @Column(length = 60)
    private String password;
    private transient PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private Boolean enabled;

    private String name;
    private String lastname;
    private String email;

    @JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_authorities", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","role_id"})})
    private List<Role> roles;


    public User() {

    }
    public void setPassword(String password) {
        // Encrypamos la contraseña antes de almacenarla
        this.password = passwordEncoder.encode(password);
    }
    private static final long serialVersionUID = 1L;

}