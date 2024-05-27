package com.projectoSpring.springboot.backend.apirest.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.projectoSpring.springboot.backend.apirest.models.services.IUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable, IUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, length = 20)
    private String username;

    @NotBlank
    @Column(length = 60)
    private String password;

    private Boolean enabled;

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @NotEmpty
    @Email
    private String email;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean admin;

    @JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_authorities", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","role_id"})})
    private List<Role> roles;


    public User() {
        this.roles = new ArrayList<>();
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    private static final long serialVersionUID = 1L;



}
