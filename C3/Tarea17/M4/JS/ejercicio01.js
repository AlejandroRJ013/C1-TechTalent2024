use ejercicio01;

db.createCollection('fabricantes');

db.fabricantes.insertMany([
    {
    "codigo": 1,
    "nombre": "Juan Magan",
    },
    {
    "codigo": 2,
    "nombre": "Antonio Banderas",
    },
    {
    "codigo": 3,
    "nombre": "Abraham Mateo",
    }
]);

db.createCollection('articulos');

db.articulos.insertMany([
    {
    "codigo": 1,
    "nombre": "Manzana",
    "precio": 1.20,
    "fabricante": 1,
    },
    {
    "codigo": 2,
    "nombre": "Peras",
    "precio": 1.30,
    "fabricante": 2,
    },
    {
    "codigo": 3,
    "nombre": "Melon",
    "precio": 5.20,
    "fabricante": 3,
    },
    {
    "codigo": 4,
    "nombre": "Cereales",
    "precio": 15.15,
    "fabricante": 2,
    },
    {
    "codigo": 5,
    "nombre": "Agua Mineral",
    "precio": 0.75,
    "fabricante": 1,
    },
    {
    "codigo": 6,
    "nombre": "Espinacas",
    "precio": 6.40,
    "fabricante": 3,
    }
]);