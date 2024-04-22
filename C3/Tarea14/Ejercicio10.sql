CREATE DATABASE ejercicio10;
USE ejercicio10;

CREATE TABLE cajeros (
codigo INT,
nombre_apellidos NVARCHAR(255),
PRIMARY KEY (codigo)
);

CREATE TABLE maquinas_registradoras (
codigo INT,
piso INT,
PRIMARY KEY (codigo)
);

CREATE TABLE productos (
codigo INT,
nombre NVARCHAR(100),
precio INT,
PRIMARY KEY (codigo)
);

CREATE TABLE venta (
cajero INT,
maquina INT,
producto INT,
PRIMARY KEY (cajero, maquina, producto),
FOREIGN KEY (cajero) REFERENCES cajeros (codigo) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (maquina) REFERENCES maquinas_registradoras (codigo) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (producto) REFERENCES productos (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);