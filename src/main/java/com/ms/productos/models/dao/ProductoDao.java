package com.ms.productos.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.ms.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{
        
}
