CREATE DATABASE ejercicio05;
USE ejercicio05;

CREATE TABLE almacenes (
codigo INT,
lugar NVARCHAR(100),
capacidad INT,
PRIMARY KEY (codigo)
);

CREATE TABLE cajas (
num_referencia CHAR(5),
contenido NVARCHAR(100),
valor INT,
almacen int,
PRIMARY KEY (num_referencia),
FOREIGN KEY (almacen) REFERENCES almacenes (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);