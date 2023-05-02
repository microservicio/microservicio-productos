package com.app.productos.infraestructure.api;

import com.app.productos.domain.ports.ProductServicePort;
import com.app.productos.infraestructure.dto.ProductDTO;
import com.app.productos.infraestructure.mappers.ProductMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Integer id) {
        var product = productMapper.modelToDto(productServicePort.findById(id));
        return ResponseEntity.ok(product);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {
        var response = buildDTO(productDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> editProduct(@RequestBody ProductDTO productDTO) {
        var response = productServicePort.update(productMapper.dtoToModel(productDTO));
        return ResponseEntity.ok(productMapper.modelToDto(response));
    }

    private ProductDTO buildDTO(ProductDTO productDTO) {
        return productMapper.modelToDto(productServicePort.save(productMapper.dtoToModel(productDTO)));
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<Void> deleteProduct(@RequestParam Integer id) {
        productServicePort.deleteByid(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
