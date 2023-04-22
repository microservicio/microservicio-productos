package com.app.productos.infraestructure.mappers;

import com.app.productos.domain.models.Product;
import com.app.productos.infraestructure.adapters.entities.EntityProduct;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T20:00:29-0500",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
*/
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product entityToModel(EntityProduct entityProduct) {
        if ( entityProduct == null ) {
            return null;
        }

        Product product = new Product();

        return product;
    }
}
