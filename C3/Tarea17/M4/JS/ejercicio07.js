use ejercicio07;

db.createCollection('productos');

db.productos.insertMany([
    {
        "codigo": 1,
        "nombre": "Pan",
        "precio": 1.50
    },
    {
        "codigo": 2,
        "nombre": "Leche",
        "precio": 0.80
    },
    {
        "codigo": 3,
        "nombre": "Huevos",
        "precio": 2.00
    }
]);

db.createCollection('cajeros');

db.cajeros.insertMany([
    {
        "codigo": 101,
        "NomApels": "Juan Pérez"
    },
    {
        "codigo": 102,
        "NomApels": "María López"
    },
    {
        "codigo": 103,
        "NomApels": "Pedro Gómez"
    }
]);

db.createCollection('maquinas_registradoras');

db.maquinas_registradoras.insertMany([
    {
        "codigo": 201,
        "piso": 1
    },
    {
        "codigo": 202,
        "piso": 2
    },
    {
        "codigo": 203,
        "piso": 3
    }
]);

db.createCollection('venta');

db.venta.insertMany([
    {
        "cajero": 101,
        "maquina": 201,
        "producto": 1
    },
    {
        "cajero": 102,
        "maquina": 202,
        "producto": 2
    },
    {
        "cajero": 103,
        "maquina": 203,
        "producto": 3
    }
]);