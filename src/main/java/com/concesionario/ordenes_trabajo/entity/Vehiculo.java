package com.concesionario.ordenes_trabajo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    private String marca;

    private String modelo;

    private int anio;

    public Vehiculo() {
    }

    public Vehiculo(Long id, String placa, String marca, String modelo, int anio) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}


/*
package com.concesionario.ordenes_trabajo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    private String marca;

    private String modelo;

    private int anio;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenTrabajo> ordenesTrabajo;
}
*/
