package com.concesionario.ordenes_trabajo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ordenes_trabajo")
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Mantenimiento, pintura, reparación...

    @Column(name = "fecha_orden")
    private LocalDate fechaOrden;

    private boolean activa;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    // Constructor vacío
    public OrdenTrabajo() {}

    // Constructor completo
    public OrdenTrabajo(Long id, String tipo, LocalDate fechaOrden, boolean activa, Vehiculo vehiculo) {
        this.id = id;
        this.tipo = tipo;
        this.fechaOrden = fechaOrden;
        this.activa = activa;
        this.vehiculo = vehiculo;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getFechaOrden() {
        return fechaOrden;
    }

    public boolean isActiva() {
        return activa;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}


/*
package com.concesionario.ordenes_trabajo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "ordenes_trabajo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Mantenimiento, pintura, reparación...

    @Column(name = "fecha_orden")
    private LocalDate fechaOrden;

    private boolean activa;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;
}
*/
