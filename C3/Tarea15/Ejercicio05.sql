USE ejercicio11;

INSERT INTO facultades VALUES 
    (0, 'Facultad de Arquitectura'), 
    (1, 'Facultad de Artes y Diseño'), 
    (2, 'Facultad de Ciencias'), 
    (3, 'Facultad de Derecho'), 
    (4, 'Facultad de Buceo'), 
    (5, 'Facultad de Hosteleria'), 
    (6, 'Facultad de Odontologia'), 
    (7, 'Facultad de Filosofia y Letras'), 
    (8, 'Facultad de Ingenieria'), 
    (9, 'Facultad de Educacion');

INSERT INTO investigadores VALUES 
    ('00000000', 'James Hospock', 1),
    (11111111, 'Gabriela Sanchez', 6),
    (22222222, 'Josep Capdevila', 2),
    (33333333, 'Ignacio Berzosa Engemann', 5),
    (44444444, 'Ariadna Rodriguez', 9),
    (55555555, 'Xavier Bahamonde', 7),
    (66666666, 'Blaca Fuster', 8),
    (77777777, 'Maria Ortega', 3),
    (88888888, 'Angel Caballero', 4),
    (99999999, 'Joaquin Yuchark', 0);

INSERT INTO equipos VALUES 
    ('0000', 'Equipo Marroqui', 8),
    (1111, 'Equipo mexicano', 6),
    (2222, 'Equipo Indones', 7),
    (3333, 'Equipo Español', 4),
    (4444, 'Equipo Frances', 3),
    (5555, 'Equipo Americano', 5),
    (6666, 'Equipo Azteca', 1),
    (7777, 'Equipo Israeli', 0),
    (8888, 'Equipo Mongolo', 9),
    (9999, 'Equipo Danes', 2);

INSERT INTO reserva VALUES 
    ('00000000', 1111, '2020-05-10', '2024-05-10'),
    (11111111, 2222, '2020-06-15', '2024-06-15'),
    (22222222, 3333, '2020-07-20', '2024-07-20'),
    (33333333, 4444, '2020-08-25', '2024-08-25'),
    (44444444, 5555, '2020-09-30', '2024-09-30'),
    (55555555, 6666, '2020-10-05', '2024-10-05'),
    (66666666, 7777, '2020-11-10', '2024-11-10'),
    (77777777, 8888, '2020-12-15', '2024-12-15'),
    (88888888, 9999, '2021-01-20', '2025-01-20'),
    (99999999, '0000', '2021-02-25', '2025-02-25');
