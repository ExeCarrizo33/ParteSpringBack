package com.projectoSpring.springboot.backend.apirest.models.dao;

import com.projectoSpring.springboot.backend.apirest.models.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProdutoDao extends CrudRepository<Producto,Long> {

    @Query("select p from Producto p where p.nombre like %?1%")
    public List<Producto> findByNombre(String term);

    //con este metodo obtenemos lo mismo que la query de arriba, ya que esta incluido el *Containing*
    public List<Producto> findByNombreContainingIgnoreCase(String term);

    public List<Producto> findByNombreStartingWithIgnoreCase(String term);


}
