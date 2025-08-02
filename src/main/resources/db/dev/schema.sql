CREATE TABLE vehiculos (
    id SERIAL PRIMARY KEY,
    placa VARCHAR(50),
    marca VARCHAR(50),
    modelo VARCHAR(50),
    anio INTEGER
);

CREATE TABLE ordenes_trabajo (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(100),
    fecha_orden DATE,
    activa BOOLEAN,
    vehiculo_id BIGINT,
    CONSTRAINT fk_vehiculo FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id)
);
