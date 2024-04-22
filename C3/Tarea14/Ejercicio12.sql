CREATE DATABASE ejercicio12;
USE ejercicio12;

CREATE TABLE profesores (
dni VARCHAR(8),
nombre NVARCHAR(60),
apellidos NVARCHAR(255),
direccion VARCHAR(60),
titulo NVARCHAR(60),
gana INT NOT NULL,
PRIMARY KEY (dni),
UNIQUE (nombre)
);

CREATE TABLE cursos (
nombre_curso NVARCHAR(100),
cod_curso INT,
dni_profesor VARCHAR(8),
max_alumnos int,
fecha_inicio DATE, 
fecha_fin DATE,
num_horas INT,
PRIMARY KEY (cod_curso),
INDEX (num_horas),
UNIQUE (nombre_curso),
CHECK (fecha_inicio < fecha_fin),
FOREIGN KEY ( dni_profesor) REFERENCES profesores (dni) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE alumnos (
dni VARCHAR(8),
nombre NVARCHAR(60),
apellidos NVARCHAR(255),
direccion VARCHAR(60),
sexo CHAR,
fecha_nacimiento DATE,
curso INT,
PRIMARY KEY (dni),
INDEX (curso),
FOREIGN KEY (curso) REFERENCES cursos (cod_curso) ON DELETE CASCADE ON UPDATE CASCADE
-- CHECK (sexo = 'H' OR sexo = 'M')
);