package com.ms.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.productos.models.entity.Producto;
import com.ms.productos.models.service.IProductoService;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Value("${eureka.instance.instance-id}")
    private String port;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService
                .findAll()
                .stream()
                .map(p -> {
                    p.setPort(port);
                    return p;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) {
        var p = productoService.findById(id);
        p.setPort(port);
        return p;
    }

}
