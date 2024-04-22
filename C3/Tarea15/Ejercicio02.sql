USE ejercicio08;

INSERT INTO piezas VALUES 
    (0, 'anilla'),
    (1, 'Tuerca'),
    (2, 'Tornillo'),
    (3, 'Alfajores'),
    (4, 'Libro'),
    (5, 'Libreta'),
    (6, 'Lapiz'),
    (7, 'Marcador'),
    (8, 'Termo'),
    (9, 'Mesa');

INSERT INTO proveedores VALUES 
    ('0000', 'fairy'),
    (1111, 'amazon'),
    (2222, 'ebay'),
    (3333, 'mano_a_mano'),
    (4444, 'figma'),
    (5555, 'netflix'),
    (6666, 'hbo'),
    (7777, 'asadores'),
    (8888, 'construcciones_adbellah'),
    (9999, 'colchones');

INSERT INTO suministra VALUES 
    (0, 9999, 15),
    (1, '0000', 6),
    (8, 1111, 10),
    (5, 2222, 12),
    (2, 3333, 20),
    (4, 4444, 17),
    (3, 5555, 70),
    (6, 6666, 54),
    (7, 8888, 60),
    (9, 7777, 20);