CREATE DATABASE ejercicio06;
USE ejercicio06;

CREATE TABLE peliculas (
codigo INT,
nombre NVARCHAR(100),
restriccion_edad INT,
PRIMARY KEY (codigo)
);

CREATE TABLE salas (
codigo INT,
nombre NVARCHAR(100),
pelicula INT,
PRIMARY KEY (codigo),
FOREIGN KEY (pelicula) REFERENCES peliculas (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);