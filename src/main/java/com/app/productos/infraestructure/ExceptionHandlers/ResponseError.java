package com.app.productos.infraestructure.ExceptionHandlers;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class ResponseError {
    private String id;
    private String message;
}
