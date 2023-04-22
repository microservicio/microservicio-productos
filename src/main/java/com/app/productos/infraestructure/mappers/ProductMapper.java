package com.app.productos.infraestructure.mappers;

import com.app.productos.domain.models.Product;
import com.app.productos.infraestructure.adapters.entities.EntityProduct;
import com.app.productos.infraestructure.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product entityToModel(EntityProduct entityProduct);
    ProductDTO modelToDto(Product product);
}
