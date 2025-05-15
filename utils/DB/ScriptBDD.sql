-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS SistemaAsignacionBoxes;
USE SistemaAsignacionBoxes;

-- Crear tabla Estados (para boxes y médicos)
CREATE TABLE Estados (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Insertar estados base
INSERT INTO Estados (id, nombre) VALUES
(0, 'Disponible'),
(1, 'Ocupado'),
(2, 'En Mantenimiento');

-- Crear tabla Boxes
CREATE TABLE Boxes (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(100) NOT NULL,
    estado INT NOT NULL,
    FOREIGN KEY (estado) REFERENCES Estados(id)
);

-- Crear tabla Medicos
CREATE TABLE Medicos (
    RUT VARCHAR(100) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    estado INT NOT NULL,
    FOREIGN KEY (estado) REFERENCES Estados(id)
);

-- Crear tabla Asignaciones
CREATE TABLE Asignaciones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    box_id INT NOT NULL,
    medico_rut VARCHAR(100) NOT NULL,
    hora_inicio DATETIME NOT NULL,
    hora_fin DATETIME NOT NULL,
    FOREIGN KEY (box_id) REFERENCES Boxes(ID),
    FOREIGN KEY (medico_rut) REFERENCES Medicos(RUT)
);