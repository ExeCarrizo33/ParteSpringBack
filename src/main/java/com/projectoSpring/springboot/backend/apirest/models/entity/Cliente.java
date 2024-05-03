package com.projectoSpring.springboot.backend.apirest.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.Date;


@Setter
@Getter
@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 12)
    @Column(nullable = false)
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    private String foto;

    @NotNull(message = "la región no puede estar vacia")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Region region;


    private static final long serialVersionUID = 1L;
}
