
DROP TABLE IF EXISTS orden_trabajo;
DROP TABLE IF EXISTS vehiculo;


CREATE TABLE vehiculo (
    id SERIAL PRIMARY KEY,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    anio INT NOT NULL,
    placa VARCHAR(20) UNIQUE NOT NULL
);


CREATE TABLE orden_trabajo (
    id SERIAL PRIMARY KEY,
    descripcion TEXT NOT NULL,
    fecha_orden DATE NOT NULL,
    activa BOOLEAN NOT NULL DEFAULT TRUE,
    vehiculo_id INT NOT NULL,
    FOREIGN KEY (vehiculo_id) REFERENCES vehiculo(id) ON DELETE CASCADE
);


INSERT INTO vehiculo (marca, modelo, anio, placa) VALUES
('Toyota', 'Corolla', 2020, 'ABC123'),
('Honda', 'Civic', 2018, 'XYZ987'),
('Ford', 'Fiesta', 2015, 'FST456');


INSERT INTO orden_trabajo (descripcion, fecha_orden, activa, vehiculo_id) VALUES
('Cambio de aceite y filtro', CURRENT_DATE, true, 1),
('Revisión de frenos', CURRENT_DATE, false, 2),
('Alineación y balanceo', CURRENT_DATE, true, 3);

