package com.app.productos.infraestructure.mappers;

import com.app.commons.dto.ProductDTO;
import com.app.commons.entities.EntityProduct;
import com.app.commons.models.Product;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-04T21:56:38-0500",
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
    public EntityProduct modelToEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        EntityProduct entityProduct = new EntityProduct();

        entityProduct.setId( product.getId() );
        entityProduct.setNombre( product.getNombre() );
        entityProduct.setPrecio( product.getPrecio() );
        entityProduct.setCreateAt( product.getCreateAt() );

        return entityProduct;
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

    @Override
    public Product dtoToModel(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.id() );
        product.setNombre( productDTO.nombre() );
        product.setPrecio( productDTO.precio() );

        return product;
    }
}
