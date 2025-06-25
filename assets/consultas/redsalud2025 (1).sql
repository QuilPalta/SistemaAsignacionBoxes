CREATE DATABASE IF NOT EXISTS RedSalud2025;
USE RedSalud2025;


CREATE TABLE Coordinadores (
    id_coordinador INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    especialidad VARCHAR(100),
    telefono VARCHAR(20)
);


CREATE TABLE Medicos (
    id_medico INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    especialidad VARCHAR(100),
    correo VARCHAR(100) UNIQUE NOT NULL
);


CREATE TABLE Boxes (
    id_box INT PRIMARY KEY AUTO_INCREMENT,
    nombre_box VARCHAR(50) NOT NULL,
    piso TINYINT UNSIGNED NOT NULL CHECK (piso BETWEEN 1 AND 20),
    tipo ENUM('consulta', 'is', 'vacunatorio', 'oficina', 'otro') NOT NULL,
    estado ENUM('libre', 'asignado', 'ocupado', 'mantención') DEFAULT 'libre'
);


CREATE TABLE ReglasOfertaRecurrente (
    id_regla INT PRIMARY KEY AUTO_INCREMENT,
    id_medico INT NOT NULL,
    dia_semana ENUM('lunes', 'martes', 'miércoles', 'jueves', 'viernes', 'sábado', 'domingo') NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    fecha_inicio DATE NOT NULL,
    semanas INT NOT NULL,
    creada_en DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_medico) REFERENCES Medicos(id_medico)
);


CREATE TABLE Ofertas (
    id_oferta INT PRIMARY KEY AUTO_INCREMENT,
    id_medico INT NOT NULL,
    id_regla INT,
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    creada_en DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_medico) REFERENCES Medicos(id_medico),
    FOREIGN KEY (id_regla) REFERENCES ReglasOfertaRecurrente(id_regla) ON DELETE SET NULL
);


CREATE TABLE Asignaciones (
    id_asignacion INT PRIMARY KEY AUTO_INCREMENT,
    id_box INT NOT NULL,
    id_oferta INT NOT NULL,
    asignado_por INT NOT NULL,
    fecha_asignacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_box) REFERENCES Boxes(id_box),
    FOREIGN KEY (id_oferta) REFERENCES Ofertas(id_oferta),
    FOREIGN KEY (asignado_por) REFERENCES Coordinadores(id_coordinador)
);

INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Gustavo Valderrama Burmeister', 'gustavo.valderrama.burmeister@redsalud.cl', 'Enfermedades del Niño y Adolescente', '');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Alvaro Urizar Garrido', 'alvaro.urizar.garrido@redsalud.cl', 'Cirugía', '9XXXX XXXX');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('David Delgado Rojas', 'david.delgado.rojas@redsalud.cl', 'Medicina Interna', '');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Ricardo Trewhela', 'ricardo.trewhela@redsalud.cl', 'Ginecología y Obstetricia', '9XXXX XXXX');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Javier garate Sagredo', 'javier.garate.sagredo@redsalud.cl', 'Enfermedades Cardiovasculares', '');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Nicolas Saez', 'nicolas.saez@redsalud.cl', 'Urología', '');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Alex Espinoza Giacomozzi', 'alex.espinoza.giacomozzi@redsalud.cl', 'Enfermedades del Sistema nervioso', '9XXXX XXXX');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Marcelo Costa', 'marcelo.costa@redsalud.cl', 'Traumatología y Ortopedia', '');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Christian Durán Besoain', 'christian.durán.besoain@redsalud.cl', 'Oftalmología', '');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Alfredo Urrutia', 'alfredo.urrutia@redsalud.cl', 'Otorrinolaringología', '');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Juan Calderon Donoso', 'juan.calderon.donoso@redsalud.cl', 'Endoscopía', '');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Nicolas Rojas del Rio', 'nicolas.rojas.del.rio@redsalud.cl', 'Oncología Infantil', '');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Rodrigo Santander P', 'rodrigo.santander.p@redsalud.cl', 'Anestesiología', '');
INSERT INTO Coordinadores (nombre, correo, especialidad, telefono) VALUES ('Patricio Agurto Urrutia', 'patricio.agurto.urrutia@redsalud.cl', 'Radiología', '9XXXX XXXX');
INSERT INTO Medicos (nombre, especialidad, correo) VALUES ('Ana Torres', 'Pediatría', 'ana.torres@redsalud.cl');
INSERT INTO Medicos (nombre, especialidad, correo) VALUES ('Carlos Pérez', 'Cardiología', 'carlos.perez@redsalud.cl');
INSERT INTO Medicos (nombre, especialidad, correo) VALUES ('Laura Gómez', 'Ginecología', 'laura.gomez@redsalud.cl');
INSERT INTO Boxes (nombre_box, piso, tipo, estado) VALUES
('Box 101', 4, 'consulta', 'libre'),
('Box 102', 4, 'consulta', 'asignado'),
('Box 103', 5, 'is', 'ocupado'),
('Box 104', 5, 'vacunatorio', 'mantención'),
('Box 105', 6, 'consulta', 'libre'),
('Box 106', 6, 'oficina', 'asignado'),
('Box 107', 7, 'otro', 'ocupado'),
('Box 108', 8, 'consulta', 'libre'),
('Box 109', 9, 'consulta', 'mantención');
INSERT INTO ReglasOfertaRecurrente (id_medico, dia_semana, hora_inicio, hora_fin, fecha_inicio, semanas)
VALUES (1, 'lunes', '08:00', '12:00', '2025-01-06', 10);
INSERT INTO ReglasOfertaRecurrente (id_medico, dia_semana, hora_inicio, hora_fin, fecha_inicio, semanas)
VALUES (2, 'miércoles', '14:00', '18:00', '2025-01-08', 8);
INSERT INTO Ofertas (id_medico, id_regla, fecha, hora_inicio, hora_fin)
VALUES (1, 1, '2025-01-06', '08:00', '12:00');
INSERT INTO Ofertas (id_medico, id_regla, fecha, hora_inicio, hora_fin)
VALUES (2, 2, '2025-01-08', '14:00', '18:00');
INSERT INTO Ofertas (id_medico, id_regla, fecha, hora_inicio, hora_fin)
VALUES (3, NULL, '2025-01-10', '09:00', '11:00');
INSERT INTO Asignaciones (id_box, id_oferta, asignado_por)
VALUES (1, 1, 1);
INSERT INTO Asignaciones (id_box, id_oferta, asignado_por)
VALUES (2, 2, 2);
INSERT INTO Asignaciones (id_box, id_oferta, asignado_por)
VALUES (3, 3, 3);