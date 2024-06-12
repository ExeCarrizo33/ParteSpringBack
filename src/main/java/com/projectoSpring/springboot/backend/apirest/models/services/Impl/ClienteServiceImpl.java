package com.projectoSpring.springboot.backend.apirest.models.services.Impl;

import java.util.List;

import com.projectoSpring.springboot.backend.apirest.models.dao.IClienteDao;
import com.projectoSpring.springboot.backend.apirest.models.dao.IFacturaDao;
import com.projectoSpring.springboot.backend.apirest.models.dao.IProdutoDao;
import com.projectoSpring.springboot.backend.apirest.models.entity.Cliente;
import com.projectoSpring.springboot.backend.apirest.models.entity.Factura;
import com.projectoSpring.springboot.backend.apirest.models.entity.Producto;
import com.projectoSpring.springboot.backend.apirest.models.entity.Region;
import com.projectoSpring.springboot.backend.apirest.models.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private IFacturaDao facturaDao;

    @Autowired
    private IProdutoDao produtoDao;


    public ClienteServiceImpl(IClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {

        return clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegions() {
        return clienteDao.findAllRegions();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findFacturaById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Factura saveFactura(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    @Transactional
    public void deleteFacturaById(Long id) {
        facturaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findProductoByNombre(String term) {
        return produtoDao.findByNombreContainingIgnoreCase(term);
    }


}
