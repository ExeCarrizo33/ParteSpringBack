package com.projectoSpring.springboot.backend.apirest.controllers;

import com.projectoSpring.springboot.backend.apirest.models.entity.Factura;
import com.projectoSpring.springboot.backend.apirest.models.entity.Producto;
import com.projectoSpring.springboot.backend.apirest.models.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class FacturaRestController {

    @Autowired
    private IClienteService clienteService;

    @Secured({"ADMIN", "USER"})
    @GetMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Factura show(@PathVariable Long id){
        return clienteService.findFacturaById(id);
    }

    @Secured({"ADMIN"})
    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.deleteFacturaById(id);
    }

    @Secured({"ADMIN"})
    @GetMapping("/facturas/filtrar-productos/{term}")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> filtrarProductos(@PathVariable String term){
        return clienteService.findProductoByNombre(term);
    }

    @Secured({"ADMIN"})
    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura create(@RequestBody Factura factura){
        return clienteService.saveFactura(factura);
    }

}
