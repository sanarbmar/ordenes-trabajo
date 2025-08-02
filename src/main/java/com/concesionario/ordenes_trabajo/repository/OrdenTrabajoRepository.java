package com.concesionario.ordenes_trabajo.repository;

import com.concesionario.ordenes_trabajo.entity.OrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Long> {
    List<OrdenTrabajo> findByVehiculoId(Long vehiculoId);
    boolean existsByVehiculoIdAndActivaTrue(Long vehiculoId);
}