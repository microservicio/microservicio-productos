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

    @Override
    public Product save(Product product) {
        return productAdapterPort.save(product);
    }

    @Override
    public void deleteByid(Integer id) {
        Product product = findById(id);
        productAdapterPort.deleteByid(product.getId());
    }

    @Override
    public Product update(Product product) {
        if(product.getId() == null)
            throw new ProductNotFoundException("No se puede editar un producto sin su identificador");
        product = buildNewProduct(product);
        return productAdapterPort.save(product);
    }

    private Product buildNewProduct(Product newProduct){
        var oldProduct = findById(newProduct.getId());
        oldProduct.setNombre(newProduct.getNombre());
        oldProduct.setPrecio(newProduct.getPrecio());
        return oldProduct;
    }
}
