CREATE DATABASE ejercicio11;
USE ejercicio11;

CREATE TABLE facultades (
codigo INT,
nombre NVARCHAR(100),
PRIMARY KEY (codigo)
);

CREATE TABLE investigadores (
dni VARCHAR(8),
nombre_apellidos NVARCHAR(255),
facultad INT,
PRIMARY KEY (dni),
FOREIGN KEY (facultad) REFERENCES facultades (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE equipos (
num_serie NVARCHAR(4),
nombre NVARCHAR(100),
facultad INT,
PRIMARY KEY (num_serie),
FOREIGN KEY (facultad) REFERENCES facultades (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE reserva (
dni VARCHAR(8),
num_serie NVARCHAR(4),
comienzo DATETIME,
fin DATETIME,
PRIMARY KEY (dni, num_serie),
FOREIGN KEY (dni) REFERENCES investigadores (dni) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (num_serie) REFERENCES equipos (num_serie) ON DELETE CASCADE ON UPDATE CASCADE
);