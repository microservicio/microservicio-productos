package com.app.productos.infraestructure.adapters;

import com.app.productos.domain.models.Product;
import com.app.productos.domain.ports.ProductAdapterPort;
import com.app.productos.infraestructure.adapters.repositories.ProductRepository;
import com.app.productos.infraestructure.mappers.ProductMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductAdapter implements ProductAdapterPort {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.productMapper = Mappers.getMapper(ProductMapper.class);
    }

    public List<Product> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::entityToModel).toList();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id).map(productMapper::entityToModel);
    }

}
