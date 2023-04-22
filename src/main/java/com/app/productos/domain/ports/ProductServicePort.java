package com.app.productos.domain.ports;

import com.app.productos.domain.models.Product;

import java.util.List;

public interface ProductServicePort {
    List<Product> findAllProducts();
    Product findById(Integer id);
}
