package com.projectoSpring.springboot.backend.apirest.models.dao;

import com.projectoSpring.springboot.backend.apirest.models.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura,Long> {


}
