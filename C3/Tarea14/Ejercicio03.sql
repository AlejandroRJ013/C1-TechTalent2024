CREATE DATABASE ejercicio03;
USE ejercicio03;

CREATE TABLE fabricantes (
codigo INT,
nombre NVARCHAR(100),
PRIMARY KEY (codigo)
);

CREATE TABLE articulos (
codigo INT,
nombre NVARCHAR(100),
precio INT,
fabricante INT,
PRIMARY KEY (codigo),
FOREIGN KEY (fabricante) REFERENCES fabricantes (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);