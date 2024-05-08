use ejercicio05;

db.createCollection('despachos');

db.despachos.insertMany([
    {
        "numero": 1,
        "capacidad": 5
    },
    {
        "numero": 2,
        "capacidad": 8
    },
    {
        "numero": 3,
        "capacidad": 10
    }
]);

db.createCollection('directores');

db.directores.insertMany([
    {
        "dni": "12345678A",
        "nombre": "Juan",
        "dni_jefe": null,
        "despacho": 1
    },
    {
        "dni": "23456789B",
        "nombre": "Maria",
        "dni_jefe": "12345678A",
        "despacho": 2
    },
    {
        "dni": "34567890C",
        "nombre": "Pedro",
        "dni_jefe": "12345678A",
        "despacho": 3
    },
    {
        "dni": "45678901D",
        "nombre": "Ana",
        "dni_jefe": "23456789B",
        "despacho": 1
    },
    {
        "dni": "56789012E",
        "nombre": "Laura",
        "dni_jefe": "23456789B",
        "despacho": 2
    },
    {
        "dni": "67890123F",
        "nombre": "Carlos",
        "dni_jefe": "34567890C",
        "despacho": 3
    }
]);
