package com.app.productos.infraestructure.adapters.repositories;


import com.app.commons.entities.EntityProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<EntityProduct,Integer> {}
