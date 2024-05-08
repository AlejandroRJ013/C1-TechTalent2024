use ejercicio06;

db.createCollection('piezas');

db.piezas.insertMany([
    {
        "codigo": 1,
        "nombre": "Tornillo"
    },
    {
        "codigo": 2,
        "nombre": "Tuerca"
    },
    {
        "codigo": 3,
        "nombre": "Arandela"
    }
]);

db.createCollection('proveedores');

db.proveedores.insertMany([
    {
        "id": 1,
        "nombre": "Proveedor A"
    },
    {
        "id": 2,
        "nombre": "Proveedor B"
    },
    {
        "id": 3,
        "nombre": "Proveedor C"
    }
]);

db.createCollection('suministra');

db.suministra.insertMany([
    {
        "codigoPieza": 1,
        "idProveedor": 1,
        "precio": 0.5
    },
    {
        "codigoPieza": 1,
        "idProveedor": 2,
        "precio": 0.6
    },
    {
        "codigoPieza": 2,
        "idProveedor": 2,
        "precio": 0.7
    },
    {
        "codigoPieza": 2,
        "idProveedor": 3,
        "precio": 0.8
    },
    {
        "codigoPieza": 3,
        "idProveedor": 1,
        "precio": 0.3
    },
    {
        "codigoPieza": 3,
        "idProveedor": 3,
        "precio": 0.4
    }
]);