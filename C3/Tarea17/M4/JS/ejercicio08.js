use ejercicio08;

db.createCollection('facultades');

db.facultades.insertMany([
    {
        "codigo": 1,
        "nombre": "Facultad de Ciencias"
    },
    {
        "codigo": 2,
        "nombre": "Facultad de Ingeniería"
    },
    {
        "codigo": 3,
        "nombre": "Facultad de Medicina"
    }
]);

db.createCollection('investigadores');

db.investigadores.insertMany([
    {
        "dni": "12345678A",
        "NomApels": "Juan Pérez",
        "facultad": 1
    },
    {
        "dni": "23456789B",
        "NomApels": "María López",
        "facultad": 2
    },
    {
        "dni": "34567890C",
        "NomApels": "Pedro Gómez",
        "facultad": 1
    }
]);

db.createCollection('equipos');

db.equipos.insertMany([
    {
        "numSerie": 101,
        "nombre": "Equipo A",
        "facultad": 1
    },
    {
        "numSerie": 102,
        "nombre": "Equipo B",
        "facultad": 2
    },
    {
        "numSerie": 103,
        "nombre": "Equipo C",
        "facultad": 3
    }
]);

db.createCollection('reserva');

db.reserva.insertMany([
    {
        "dni": "12345678A",
        "numSerie": 101,
        "comienzo": "2024-05-01",
        "fin": "2024-05-10"
    },
    {
        "dni": "23456789B",
        "numSerie": 102,
        "comienzo": "2024-05-03",
        "fin": "2024-05-12"
    },
    {
        "dni": "34567890C",
        "numSerie": 103,
        "comienzo": "2024-05-05",
        "fin": "2024-05-15"
    }
]);