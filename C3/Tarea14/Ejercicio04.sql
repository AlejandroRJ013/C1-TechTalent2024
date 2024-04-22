CREATE DATABASE ejercicio04;
USE ejercicio04;

CREATE TABLE departamentos (
codigo INT,
nombre NVARCHAR(100),
presupuesto INT,
PRIMARY KEY (codigo)
);

CREATE TABLE empleados (
dni NVARCHAR(8),
nombre NVARCHAR(100),
apellidos NVARCHAR(255),
departamento INT,
PRIMARY KEY (dni),
FOREIGN KEY (departamento) REFERENCES departamentos (codigo) ON DELETE CASCADE ON UPDATE CASCADE
);