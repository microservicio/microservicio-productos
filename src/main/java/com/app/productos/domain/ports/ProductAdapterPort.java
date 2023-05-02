package com.app.productos.domain.ports;

import com.app.productos.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductAdapterPort {
    List<Product> findAll();
    Optional<Product> findById(Integer id);
    Product save(Product product);

    void deleteByid(Integer id);
}
