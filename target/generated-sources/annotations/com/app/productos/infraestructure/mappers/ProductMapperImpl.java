package com.app.productos.infraestructure.mappers;

import com.app.productos.domain.models.Product;
import com.app.productos.infraestructure.adapters.entities.EntityProduct;
import com.app.productos.infraestructure.dto.ProductDTO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T21:53:38-0500",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product entityToModel(EntityProduct entityProduct) {
        if ( entityProduct == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( entityProduct.getId() );
        product.setNombre( entityProduct.getNombre() );
        product.setPrecio( entityProduct.getPrecio() );
        product.setCreateAt( entityProduct.getCreateAt() );

        return product;
    }

    @Override
    public ProductDTO modelToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        Integer id = null;
        String nombre = null;
        Double precio = null;
        LocalDateTime createAt = null;

        id = product.getId();
        nombre = product.getNombre();
        precio = product.getPrecio();
        createAt = product.getCreateAt();

        ProductDTO productDTO = new ProductDTO( id, nombre, precio, createAt );

        return productDTO;
    }
}
