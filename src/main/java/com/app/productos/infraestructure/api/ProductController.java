package com.app.productos.infraestructure.api;

import com.app.productos.domain.ports.ProductServicePort;
import com.app.productos.infraestructure.dto.ProductDTO;
import com.app.productos.infraestructure.mappers.ProductMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api-product")
public class ProductController {

    private final ProductServicePort productServicePort;
    private final ProductMapper productMapper;
    public ProductController(ProductServicePort productServicePort,
                             ProductMapper productMapper) {
        this.productServicePort = productServicePort;
        this.productMapper = productMapper;
    }
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        var products = productServicePort.findAllProducts()
                .stream().map(productMapper::modelToDto)
                .toList();
        return ResponseEntity.ok(products);
    }
}
