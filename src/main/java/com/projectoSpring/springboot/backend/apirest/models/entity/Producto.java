package com.projectoSpring.springboot.backend.apirest.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;


    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    @Serial
    private static final long serialVersionUID = 1L;

}
