package com.concesionario.ordenes_trabajo.service;

import com.concesionario.ordenes_trabajo.entity.Vehiculo;
import com.concesionario.ordenes_trabajo.exception.GlobalExceptionHandler;
import com.concesionario.ordenes_trabajo.exception.VehiculoNotFoundException;
import com.concesionario.ordenes_trabajo.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository  vehiculoRepository;

    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        if (vehiculoRepository.existsByPlaca(vehiculo.getPlaca())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existe un vehículo con la placa " + vehiculo.getPlaca());
        }
        return vehiculoRepository.save(vehiculo);
    }
    public Vehiculo actualizarVehiculo(Long id, Vehiculo vehiculoActualizado) {
        Vehiculo existente = obtenerVehiculoPorId(id);
        existente.setPlaca(vehiculoActualizado.getPlaca());
        existente.setMarca(vehiculoActualizado.getMarca());
        existente.setModelo(vehiculoActualizado.getModelo());
        existente.setAnio(vehiculoActualizado.getAnio());
        return vehiculoRepository.save(existente);
    }


    public List<Vehiculo> listarVehiculos() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo obtenerVehiculoPorId(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new VehiculoNotFoundException(id));
    }

    public void eliminarVehiculo(Long id) {
        vehiculoRepository.deleteById(id);
    }

}
