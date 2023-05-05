package com.app.productos.infraestructure.mappers;



import com.app.commons.dto.ProductDTO;
import com.app.commons.entities.EntityProduct;
import com.app.commons.models.Product;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "precio", source = "precio")
    @Mapping(target = "createAt", source = "createAt")
    Product entityToModel(EntityProduct entityProduct);

    @InheritConfiguration
    EntityProduct modelToEntity(Product product);

    @InheritConfiguration
    ProductDTO modelToDto(Product product);


    @Mapping(target = "createAt", ignore = true)
    Product dtoToModel(ProductDTO productDTO);
}
