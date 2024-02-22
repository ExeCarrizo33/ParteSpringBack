package com.projectoSpring.springboot.backend.apirest.models.services;

import com.projectoSpring.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface IClienteService {

    public List<Cliente> findAll();

    @Transactional
    void save(Cliente cliente);

    @Transactional(readOnly = true)
    Cliente findById(Long id);

    @Transactional
    void delete(Cliente cliente);
}
