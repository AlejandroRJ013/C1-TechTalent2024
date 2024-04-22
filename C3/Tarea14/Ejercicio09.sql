CREATE DATABASE ejercicio09;
USE ejercicio09;

CREATE TABLE cientificos (
dni VARCHAR(8),
nombre_apellidos NVARCHAR(255),
PRIMARY KEY (dni)
);

CREATE TABLE proyectos (
id CHAR(4),
nombre NVARCHAR(255),
horas INT,
PRIMARY KEY (id)
);

CREATE TABLE asignado_a (
cientifico VARCHAR(8),
proyecto CHAR(4),
PRIMARY KEY (cientifico, proyecto),
FOREIGN KEY (cientifico) REFERENCES cientificos (dni) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (proyecto) REFERENCES proyectos (id) ON DELETE CASCADE ON UPDATE CASCADE
);