package com.app.productos.infraestructure.adapters.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class EntityProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private Double precio;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    private void addInformationDate() {
        createAt = LocalDateTime.now();
    }
}
