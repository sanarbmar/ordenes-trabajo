package com.concesionario.ordenes_trabajo.exception;

public class VehiculoNotFoundException extends RuntimeException {
    public VehiculoNotFoundException(Long id) {
        super("Vehículo con ID " + id + " no encontrado");
    }
}
