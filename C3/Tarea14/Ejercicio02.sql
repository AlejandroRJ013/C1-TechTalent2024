CREATE DATABASE ejercicio02;
USE ejercicio02;

CREATE TABLE tema (
clave_tema SMALLINT,
nombre VARCHAR(40),
PRIMARY KEY (clave_tema)
);

CREATE TABLE autor (
clave_autor INT,
nombre VARCHAR(60),
PRIMARY KEY (clave_autor)
);

CREATE TABLE editorial (
clave_editorial INT,
nombre VARCHAR(60),
direccion VARCHAR(60),
telefono VARCHAR(15),
PRIMARY KEY (clave_editorial)
);

CREATE TABLE libro (
clave_libro INT,
titulo VARCHAR(60),
idioma VARCHAR(15),
formato VARCHAR(15),
clave_editorial INT,
PRIMARY KEY (clave_libro),
FOREIGN KEY (clave_editorial) REFERENCES editorial (clave_editorial) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ejemplar (
clave_ejemplar INT,
clave_libro INT,
numero_orden SMALLINT,
edicion SMALLINT,
ubicacion VARCHAR(15),
categoria CHAR,
PRIMARY KEY (clave_ejemplar),
FOREIGN KEY (clave_libro) REFERENCES libro (clave_libro) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE socio (
clave_socio INT,
nombre VARCHAR(60),
direccion VARCHAR(60),
telefono VARCHAR(15),
categoria CHAR,
PRIMARY KEY (clave_socio)
);

CREATE TABLE prestamo (
clave_socio INT,
clave_ejemplar INT,
numero_orden SMALLINT,
fecha_prestamo DATE,
fecha_devolucion DATE,
notas BLOB,
FOREIGN KEY (clave_socio) REFERENCES socio (clave_socio) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (clave_ejemplar) REFERENCES ejemplar (clave_ejemplar) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE trata_sobre (
clave_libro INT,
clave_tema SMALLINT,
FOREIGN KEY (clave_libro) REFERENCES libro (clave_libro) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (clave_tema) REFERENCES tema (clave_tema) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE escrito_por (
clave_libro INT,
clave_autor INT,
FOREIGN KEY (clave_libro) REFERENCES libro (clave_libro) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (clave_autor) REFERENCES autor (clave_autor) ON DELETE CASCADE ON UPDATE CASCADE
);