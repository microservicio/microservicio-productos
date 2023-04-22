package com.app.productos.application;

import com.app.productos.domain.ports.ProductServicePort;
import com.app.productos.domain.services.ProductService;
import com.app.productos.infraestructure.adapters.ProductAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationService {

    @Bean
    public ProductServicePort buildServiceProduct(ProductAdapter productAdapter){
        return new ProductService(productAdapter);
    }
}
