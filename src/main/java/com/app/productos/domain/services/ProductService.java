package com.app.productos.domain.services;

import com.app.productos.domain.models.Product;
import com.app.productos.domain.ports.ProductAdapterPort;
import com.app.productos.domain.ports.ProductServicePort;
import com.app.productos.infraestructure.ExceptionHandlers.ProductNotFoundException;

import java.util.List;

public class ProductService implements ProductServicePort {

    private final ProductAdapterPort productAdapterPort;

    public ProductService(ProductAdapterPort productAdapterPort) {
        this.productAdapterPort = productAdapterPort;
    }

    public List<Product> findAllProducts() {
        return productAdapterPort.findAll();
    }

    public Product findById(Integer id) {
        return productAdapterPort.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Producto no encontrado"));
    }
}
