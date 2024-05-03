USE ejercicio04;

-- INSERCIONES
INSERT INTO departamentos (codigo, nombre, presupuesto) VALUES
    (1, 'Ventas', 50000),
    (2, 'Marketing', 60000),
    (3, 'Recursos Humanos', 45000),
    (4, 'Finanzas', 70000),
    (5, 'Producción', 80000),
    (14, 'Informatica', 65000),
    (7, 'Soporte Tecnico', 55000),
    (37, 'Gramatica', 48000),
    (77, 'Investigacion', 60000),
    (55, 'Arquitectura', 90000),
    (21, 'Administracion', 70000);

INSERT INTO empleados (dni, nombre, apellidos, departamento) VALUES
    ('12345678', 'Juan', 'Gonzalez', 1),
    ('23456789', 'María', 'Perez', 21),
    ('34567890', 'Pedro', 'Rodriguez', 77),
    ('45678901', 'Ana', 'Lopez', 2),
    ('56789012', 'David', 'Lopez', 14),
    ('67890123', 'Laura', 'Diaz', 3),
    ('78901234', 'Carlos', 'Rodriguez', 4),
    ('89012345', 'Sofía', 'Hernandez', 7),
    ('90123456', 'Elena', 'Diaz', 5),
    ('01234567', 'Javier', 'Fernandez', 37),
    ('11234567', 'Luis', 'Gómez', 77),
    ('22345678', 'Ana', 'Martínez', 77),
    ('33456789', 'Mario', 'Sánchez', 4);

-- 2.1
SELECT apellidos FROM empleados;

-- 2.2
SELECT apellidos FROM empleados GROUP BY apellidos;
SELECT DISTINCT apellidos FROM empleados;
-- SELECT apellidos, COUNT(apellidos) FROM empleados GROUP BY apellidos;

-- 2.3
SELECT * FROM empleados WHERE apellidos='Lopez';

-- 2.4
SELECT * FROM empleados WHERE apellidos='Lopez' OR apellidos='Perez';

-- 2.5
SELECT * FROM empleados WHERE departamento=14;

-- 2.6
SELECT * FROM empleados WHERE departamento IN (37, 77);
-- SELECT * FROM empleados WHERE departamento=37 OR departamento=77

-- 2.7
SELECT * FROM empleados WHERE apellidos LIKE 'P%';

-- 2.8
SELECT SUM(presupuesto) FROM departamentos;

-- 2.9
SELECT COUNT(departamento), dep.nombre FROM empleados em INNER JOIN departamentos dep ON em.departamento=dep.codigo GROUP BY departamento;

-- 2.10
SELECT em.*, dep.* FROM empleados em INNER JOIN departamentos dep ON em.departamento=dep.codigo;
-- SELECT empleados.*, departamentos.nombre, departamentos.presupuesto FROM empleados INNER JOIN departamentos ON empleados.departamento=departamentos.codigo;

-- 2.11
SELECT em.nombre, apellidos, dep.nombre, presupuesto FROM empleados em INNER JOIN departamentos dep ON em.departamento=dep.codigo;

-- 2.12
SELECT em.nombre, apellidos FROM empleados em INNER JOIN departamentos dep ON em.departamento=dep.codigo WHERE presupuesto>=60000;

-- 2.13
SELECT * FROM departamentos WHERE presupuesto > (SELECT AVG(presupuesto) FROM departamentos);

-- 2.14
SELECT dep.nombre FROM empleados em INNER JOIN departamentos dep ON em.departamento=dep.codigo GROUP BY departamento HAVING COUNT(departamento)>2;

-- 2.15
INSERT INTO departamentos (codigo, nombre, presupuesto) VALUES (11, 'Calidad', 40000);
INSERT INTO empleados (dni, nombre, apellidos, departamento) VALUES ('89267109', 'Esther', 'Vázquez', 11);

-- 2.16
UPDATE departamentos SET presupuesto=presupuesto*0.9;

-- 2.17
UPDATE empleados SET departamento=14 WHERE departamento=77;

-- 2.18
DELETE FROM empleados WHERE departamento=14;

-- 2.19
DELETE FROM empleados em INNER JOIN departamentos dep ON em.departamento=dep.codigo WHERE presupuesto>=60000;

-- 2.20
DELETE FROM empleados;