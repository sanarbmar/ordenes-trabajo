package com.concesionario.ordenes_trabajo.controller;

import com.concesionario.ordenes_trabajo.entity.Vehiculo;
import com.concesionario.ordenes_trabajo.service.VehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping
    public ResponseEntity<Vehiculo> crearVehiculo(@RequestBody Vehiculo vehiculo) {
        Vehiculo nuevoVehiculo = vehiculoService.crearVehiculo(vehiculo);
        return ResponseEntity.ok(nuevoVehiculo);
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> listarVehiculos() {
        return ResponseEntity.ok(vehiculoService.listarVehiculos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerVehiculo(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoService.obtenerVehiculoPorId(id));
    }

    // Opcional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVehiculo(@PathVariable Long id) {
        vehiculoService.eliminarVehiculo(id);
        return ResponseEntity.noContent().build();
    }
}

