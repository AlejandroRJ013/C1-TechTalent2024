USE ejercicio05;

-- INSERCIONES
INSERT INTO almacenes (codigo, lugar, capacidad) VALUES
    (1, 'Sevilla', 10),
    (2, 'Bilbao', 45),
    (3, 'Madrid', 10),
    (4, 'Caceres', 12),
    (5, 'Valencia', 7),
    (6, 'Málaga', 2),
    (7, 'Zaragoza', 4),
    (8, 'Palma de Mallorca', 30),
    (9, 'Valladolid', 20),
    (10, 'Granada', 10);

INSERT INTO cajas (num_referencia, contenido, valor, almacen) VALUES
    ('CA001', 'Libros', 50, 1),
    ('CA002', 'Ropa', 20, 10),
    ('CA003', 'Electrónicos', 200, 2),
    ('CA004', 'Juguetes', 180, 2),
    ('CA005', 'Herramientas', 120, 3),
    ('CA006', 'Comestibles', 70, 3),
    ('CA007', 'Cosméticos', 90, 4),
    ('CA008', 'Decoración', 140, 4),
    ('CA009', 'Equipamiento deportivo', 150, 6),
    ('CA010', 'Artículos de oficina', 60, 5),
    ('CA011', 'DVDs', 30, 6),
    ('CA012', 'Instrumentos musicales', 180, 6),
    ('CA013', 'Artículos de cocina', 90, 7),
    ('CA014', 'Joyería', 200, 9),
    ('CA015', 'Material de arte', 130, 8);

-- 3.1
SELECT * FROM almacenes;

-- 3.2
SELECT * FROM cajas WHERE valor<150;

-- 3.3
SELECT num_referencia, contenido FROM cajas;

-- 3.4
SELECT AVG(valor) FROM cajas;

-- 3.5
SELECT AVG(valor) FROM cajas GROUP BY almacen;
-- SELECT almacenes.codigo, AVG(valor) FROM cajas INNER JOIN almacenes ON cajas.num_referencia=almacenes.codigo GROUP BY almacen;

-- 3.6
SELECT almacen FROM cajas GROUP BY almacen HAVING AVG(valor)>150;

-- 3.7
SELECT num_referencia, lugar FROM cajas ca INNER JOIN almacenes al ON ca.almacen=al.codigo;

-- 3.8
SELECT COUNT(num_referencia), codigo, lugar FROM cajas ca INNER JOIN almacenes al ON ca.almacen=al.codigo GROUP BY almacen;

-- 3.9
SELECT almacen, lugar, capacidad FROM cajas ca INNER JOIN almacenes al ON ca.almacen=al.codigo GROUP BY almacen HAVING capacidad<COUNT(num_referencia);

-- 3.10
SELECT num_referencia FROM cajas ca INNER JOIN almacenes al ON ca.almacen=al.codigo WHERE lugar='Bilbao';

-- 3.11
INSERT INTO almacenes (codigo, lugar, capacidad) VALUES (11, 'Barcelona', 3);

-- 3.12
INSERT INTO cajas (num_referencia, contenido, valor, almacen) VALUES ('H5RT', 'Papel', 200, 2);

-- 3.13
UPDATE cajas SET valor=valor*0.85;

-- 3.14
UPDATE cajas SET valor=valor*0.8 WHERE valor>(SELECT AVG(valor) FROM cajas);

-- 3.15
DELETE FROM cajas WHERE valor<100;

-- 3.16
DELETE FROM cajas WHERE almacen IN (SELECT codigo FROM almacenes a JOIN (SELECT almacen, COUNT(*) AS 'conteo' FROM cajas GROUP BY almacen ) c ON a.codigo = c.almacen WHERE capacidad < conteo);
-- DELETE FROM cajas WHERE almacen IN (SELECT codigo FROM almacenes al INNER JOIN cajas ca ON al.codigo=ca.almacen GROUP BY almacen HAVING capacidad<COUNT(*));
-- DELETE FROM cajas ca INNER JOIN almacenes al ON ca.almacen=al.codigo GROUP BY almacen HAVING capacidad<COUNT(num_referencia);