CREATE DATABASE ejercicio01 ;
USE ejercicio01;

CREATE TABLE estacion (
identificador INT AUTO_INCREMENT,
latitud INT,
longitud INT,
altitud INT,
PRIMARY KEY (identificador));

CREATE TABLE muestra (
idestacion INT,
fecha DATE,
temperaturamin INT,
temperaturamax INT,
precipitaciones INT,
humedadmin INT,
humedadmax INT,
velocidadmin INT,
velocidadmax INT,
FOREIGN KEY (idestacion) REFERENCES estacion (identificador) ON DELETE CASCADE ON UPDATE CASCADE);