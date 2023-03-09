package com.ms.productos.models.service;

import java.util.List;

import com.ms.productos.models.entity.Producto;

public interface IProductoService {
    
    public List<Producto> findAll();
    public Producto findById(Long id);
}
