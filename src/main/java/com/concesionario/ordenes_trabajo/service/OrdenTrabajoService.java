package com.concesionario.ordenes_trabajo.service;

import com.concesionario.ordenes_trabajo.entity.OrdenTrabajo;
import com.concesionario.ordenes_trabajo.entity.Vehiculo;
import com.concesionario.ordenes_trabajo.repository.OrdenTrabajoRepository;
import com.concesionario.ordenes_trabajo.repository.VehiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrdenTrabajoService {

    private final VehiculoRepository vehiculoRepository;
    private final OrdenTrabajoRepository ordenTrabajoRepository;

    @Autowired
    public OrdenTrabajoService(VehiculoRepository vehiculoRepository, OrdenTrabajoRepository ordenTrabajoRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.ordenTrabajoRepository = ordenTrabajoRepository;
    }

    @Transactional
    public OrdenTrabajo crearOrden(Long vehiculoId, OrdenTrabajo orden) {
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado"));


        boolean tieneOrdenActiva = ordenTrabajoRepository.existsByVehiculoIdAndActivaTrue(vehiculoId);
        if (tieneOrdenActiva) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El vehículo ya tiene una orden activa.");
        }
        orden.setVehiculo(vehiculo);
        orden.setFechaOrden(LocalDate.now());
        orden.setActiva(true);

        return ordenTrabajoRepository.save(orden);
    }

    @Transactional
    public OrdenTrabajo cerrarOrden(Long ordenId) {
        OrdenTrabajo orden = ordenTrabajoRepository.findById(ordenId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden no encontrada"));

        orden.setActiva(false);
        return ordenTrabajoRepository.save(orden);
    }

    public List<OrdenTrabajo> obtenerOrdenesPorVehiculo(Long vehiculoId) {
        if (!vehiculoRepository.existsById(vehiculoId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado");
        }

        return ordenTrabajoRepository.findByVehiculoId(vehiculoId);
    }

    public OrdenTrabajo obtenerOrdenPorId(Long id) {
        return ordenTrabajoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden no encontrada"));
    }

    public List<OrdenTrabajo> obtenerTodas() {
        return ordenTrabajoRepository.findAll();
    }

    @Transactional
    public OrdenTrabajo actualizarOrden(Long id, OrdenTrabajo ordenActualizada) {
        OrdenTrabajo orden = ordenTrabajoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden no encontrada"));

        orden.setTipo(ordenActualizada.getTipo());
        orden.setFechaOrden(ordenActualizada.getFechaOrden());
        orden.setActiva(ordenActualizada.isActiva());

        if (ordenActualizada.getVehiculo() != null) {
            Long nuevoVehiculoId = ordenActualizada.getVehiculo().getId();
            Vehiculo nuevoVehiculo = vehiculoRepository.findById(nuevoVehiculoId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehículo no encontrado con ID: " + nuevoVehiculoId));
            orden.setVehiculo(nuevoVehiculo);
        }

        return ordenTrabajoRepository.save(orden);
    }

    @Transactional
    public void eliminarOrden(Long id) {
        OrdenTrabajo orden = ordenTrabajoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden no encontrada"));
        ordenTrabajoRepository.delete(orden);
    }
}
