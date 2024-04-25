USE ejercicio03;

-- INSERCIONES
INSERT INTO fabricantes VALUES 
    (0, 'Juan Magan'),
    (1, 'Antonio Sobera'),
    (2, 'Prince Royce'),
    (3, 'Javier Ibarra'),
    (4, 'Luciano Pavarotti'),
    (5, 'Ramon Ramirez'),
    (6, 'Pedro Ruibal'),
    (7, 'Jose Alvarez'),
    (8, 'Joaquin Sanchez'),
    (9, 'Antonio Banderas');

INSERT INTO articulos VALUES 
    (0, 'Pollo', 12, 2),
    (1, 'Agua', 200, 1),
    (2, 'Helado', 12, 0),
    (3, 'Jamon', 300, 8),
    (4, 'Almidon', 15, 6),
    (5, 'Aceite', 74, 4),
    (6, 'Gasolina', 750,5),
    (7, 'Peine', 10, 3),
    (8, 'Harina', 400, 9),
    (9, 'Queso', 8, 7);

-- 1.1
SELECT nombre FROM articulos;

-- 1.2
SELECT nombre,precio FROM articulos;

-- 1.3
SELECT nombre,precio FROM articulos WHERE precio<=200;

-- 1.4
SELECT nombre,precio FROM articulos WHERE precio BETWEEN 60 AND 120;

-- 1.5
SELECT nombre,precio*166.386 FROM articulos;

-- 1.6
SELECT AVG(precio) FROM articulos;

-- 1.7
SELECT AVG(precio) FROM articulos WHERE fabricante=2;

-- 1.8
SELECT COUNT(*) FROM articulos WHERE precio>=180;

-- 1.9
SELECT nombre,precio FROM articulos WHERE precio>=180 ORDER BY precio DESC, nombre ASC;

-- 1.10
SELECT * FROM articulos INNER JOIN fabricantes ON articulos.fabricante=fabricantes.codigo;

-- 1.11
SELECT articulos.nombre, precio, fabricantes.nombre FROM articulos INNER JOIN fabricantes ON articulos.fabricante=fabricantes.codigo;

--1.12
SELECT articulos.codigo, AVG(precio) FROM articulos INNER JOIN fabricantes ON articulos.fabricante=fabricantes.codigo GROUP BY fabricante;

-- 1.13
SELECT articulos.codigo, fabricantes.nombre, AVG(precio) FROM articulos INNER JOIN fabricantes ON articulos.fabricante=fabricantes.codigo GROUP BY fabricante;

-- 1.14
SELECT fabricantes.nombre, precio FROM articulos INNER JOIN fabricantes ON articulos.fabricante=fabricantes.codigo GROUP BY fabricante HAVING AVG(precio)>=150;

-- 1.15
SELECT nombre, precio FROM articulos ORDER BY precio ASC LIMIT 1;

-- 1.16
SELECT fabricantes.nombre, articulos.nombre, precio FROM articulos INNER JOIN fabricantes ON articulos.fabricante = fabricantes.codigo WHERE precio IN (SELECT MAX(precio) FROM articulos GROUP BY fabricante);

-- 1.17
INSERT INTO articulos (codigo, nombre, precio, fabricante) VALUES (13, 'Altavoces', 70, 2);

-- 1.18
UPDATE articulos SET nombre='Impresora Laser' WHERE codigo=8;

-- 1.19
UPDATE articulos SET precio=precio*0.9;

--1.20
UPDATE articulos SET precio=precio-10 WHERE precio>=120;