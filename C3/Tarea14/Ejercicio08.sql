CREATE DATABASE ejercicio08;
USE ejercicio08;

CREATE TABLE piezas (
codigo INT,
nombre NVARCHAR(100),
PRIMARY KEY (codigo)
);

CREATE TABLE proveedores (
id CHAR(4),
nombre NVARCHAR(100),
PRIMARY KEY (id)
);

CREATE TABLE suministra (
codigo_pieza INT,
id_proveedor CHAR(4),
precio INT,
PRIMARY KEY (codigo_pieza, id_proveedor),
FOREIGN KEY (codigo_pieza) REFERENCES piezas (codigo) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (id_proveedor) REFERENCES proveedores (id) ON DELETE CASCADE ON UPDATE CASCADE
);