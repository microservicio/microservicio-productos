package com.app.productos.infraestructure.dto;

import java.time.LocalDateTime;

public record ProductDTO (Integer id, String nombre, Double precio, LocalDateTime createAt){}
