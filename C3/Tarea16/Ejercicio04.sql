USE ejercicio06;

-- INSERCIONES
INSERT INTO peliculas (codigo, nombre, restriccion_edad) VALUES
    (1, 'La Casa de Papel', 18),
    (2, 'El Señor de los Anillos', 12),
    (5, 'Harry Potter y la Piedra Filosofal', 7),
    (7, 'El Rey León', 0),
    (8, 'El Padrino', 18),
    (9, 'Titanic', 12),
    (10, 'El Lobo de Wall Street', 18);
INSERT INTO peliculas (codigo, nombre) VALUES
    (3, 'Jurassic Park'),
    (4, 'Los Vengadores'),
    (6, 'Piratas del Caribe: La maldición de la Perla Negra');

INSERT INTO salas (codigo, nombre, pelicula) VALUES
    (1, 'Sala 1', 1),
    (2, 'Sala 2', 2),
    (3, 'Sala 3', 3),
    (4, 'Sala 4', 3),
    (5, 'Sala 5', 7),
    (6, 'Sala 6', 6),
    (7, 'Sala 7', 7),
    (8, 'Sala 8', 4);
INSERT INTO salas (codigo, nombre) VALUES
    (9, 'Sala 9'),
    (10, 'Sala 10');

-- 4.1
SELECT nombre FROM peliculas;

-- 4.2
SELECT restriccion_edad FROM peliculas GROUP BY restriccion_edad;
-- SELECT restriccion_edad FROM peliculas GROUP BY restriccion_edad ORDER BY restriccion_edad DESC;

-- 4.3
SELECT * FROM peliculas WHERE restriccion_edad IS NULL;

-- 4.4
SELECT nombre FROM salas WHERE pelicula IS NULL;

-- 4.5
SELECT salas.*, peliculas.* FROM salas LEFT JOIN peliculas ON salas.pelicula=peliculas.codigo;

-- 4.6
SELECT peliculas.*, salas.* FROM peliculas LEFT JOIN salas ON peliculas.codigo=salas.pelicula;

-- 4.7
SELECT nombre FROM peliculas WHERE codigo NOT IN (SELECT pelicula FROM salas); /* No me va */

-- 4.8
INSERT INTO peliculas (codigo, nombre, restriccion_edad) VALUES (11, 'Uno, Dos, Tres', 7);

-- 4.9
UPDATE peliculas SET restriccion_edad=13 WHERE restriccion_edad IS NULL;

-- 4.10
-- SELECT * FROM salas WHERE pelicula IS NOT NULL AND pelicula IN (SELECT codigo FROM  peliculas WHERE restriccion_edad IS NULL);
DELETE FROM salas WHERE pelicula IS NOT NULL AND pelicula IN (SELECT codigo FROM  peliculas WHERE restriccion_edad IS NULL);