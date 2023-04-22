package com.app.productos.domain.services;

import com.app.productos.domain.models.Product;
import com.app.productos.domain.ports.ProductAdapterPort;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private final ProductAdapterPort productAdapterPort;

    public ProductService(ProductAdapterPort productAdapterPort) {
        this.productAdapterPort = productAdapterPort;
    }

    public List<Product> findAllProducts() {
        return productAdapterPort.findAll();
    }

    public Optional<Product> findById(Integer id){
        return productAdapterPort.findById(id);
    }
}
