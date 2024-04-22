CREATE DATABASE ejercicio07;
USE ejercicio07;

CREATE TABLE despachos (
numero INT,
capacidad INT,
PRIMARY KEY (numero)
);

CREATE TABLE directores (
dni VARCHAR(8),
nombre_apellidos NVARCHAR(255),
dni_jefe VARCHAR(8),
despacho INT,
PRIMARY KEY (dni),
FOREIGN KEY (dni_jefe) REFERENCES directores (dni) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (despacho) REFERENCES despachos (numero) ON DELETE CASCADE ON UPDATE CASCADE
);