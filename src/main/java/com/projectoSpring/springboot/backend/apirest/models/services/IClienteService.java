package com.projectoSpring.springboot.backend.apirest.models.services;

import com.projectoSpring.springboot.backend.apirest.models.entity.Cliente;
import com.projectoSpring.springboot.backend.apirest.models.entity.Factura;
import com.projectoSpring.springboot.backend.apirest.models.entity.Producto;
import com.projectoSpring.springboot.backend.apirest.models.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface IClienteService {

    public List<Cliente> findAll();

    public Page<Cliente> findAll(Pageable pageable);

    @Transactional
    Cliente save(Cliente cliente);

    @Transactional(readOnly = true)
    Cliente findById(Long id);

    @Transactional
    void delete(Long id);

    public List<Region> findAllRegions();

    Factura findFacturaById(Long id);

    Factura saveFactura(Factura factura);

    void deleteFacturaById(Long id);

    public List<Producto> findProductoByNombre(String term);

}
