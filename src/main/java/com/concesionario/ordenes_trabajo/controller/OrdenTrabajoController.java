package com.concesionario.ordenes_trabajo.controller;

import com.concesionario.ordenes_trabajo.entity.OrdenTrabajo;
import com.concesionario.ordenes_trabajo.service.OrdenTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenTrabajoController {

    @Autowired
    private OrdenTrabajoService ordenTrabajoService;

    // Crear orden de trabajo para un vehículo
    @PostMapping("/vehiculo/{vehiculoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrdenTrabajo crearOrden(@PathVariable Long vehiculoId, @RequestBody OrdenTrabajo orden) {
        return ordenTrabajoService.crearOrden(vehiculoId, orden);
    }

    // Cerrar una orden de trabajo (cambiar activa a false)
    @PutMapping("/{ordenId}/cerrar")
    public OrdenTrabajo cerrarOrden(@PathVariable Long ordenId) {
        return ordenTrabajoService.cerrarOrden(ordenId);
    }

    // Obtener todas las órdenes de un vehículo
    @GetMapping("/vehiculo/{vehiculoId}")
    public List<OrdenTrabajo> obtenerOrdenesPorVehiculo(@PathVariable Long vehiculoId) {
        return ordenTrabajoService.obtenerOrdenesPorVehiculo(vehiculoId);
    }

    @GetMapping
    public List<OrdenTrabajo> obtenerTodasLasOrdenes() {
        return ordenTrabajoService.obtenerTodas();
    }

    @PutMapping("/{ordenId}")
    public ResponseEntity<OrdenTrabajo> actualizarOrden(
            @PathVariable Long ordenId,
            @RequestBody OrdenTrabajo ordenActualizada) {
        OrdenTrabajo actualizada = ordenTrabajoService.actualizarOrden(ordenId, ordenActualizada);
        return ResponseEntity.ok(actualizada);
    }

    // Eliminar una orden de trabajo
    @DeleteMapping("/{ordenId}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable Long ordenId) {
        ordenTrabajoService.eliminarOrden(ordenId);
        return ResponseEntity.noContent().build();
    }
}
