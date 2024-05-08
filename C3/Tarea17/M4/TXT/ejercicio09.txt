use ejercicio09;

db.createCollection('cientificos');

db.cientificos.insertMany([
    {
        "dni": "12345678A",
        "NomApels": "Juan Pérez"
    },
    {
        "dni": "23456789B",
        "NomApels": "María López"
    },
    {
        "dni": "34567890C",
        "NomApels": "Pedro Gómez"
    }
]);

db.createCollection('proyectos');

db.proyectos.insertMany([
    {
        "id": 1,
        "nombre": "Proyecto A",
        "horas": 100
    },
    {
        "id": 2,
        "nombre": "Proyecto B",
        "horas": 200
    },
    {
        "id": 3,
        "nombre": "Proyecto C",
        "horas": 150
    }
]);

db.createCollection('asignado_a');

db.asignado_a.insertMany([
    {
        "cientifico": "12345678A",
        "proyecto": 1
    },
    {
        "cientifico": "23456789B",
        "proyecto": 2
    },
    {
        "cientifico": "34567890C",
        "proyecto": 3
    }
]);