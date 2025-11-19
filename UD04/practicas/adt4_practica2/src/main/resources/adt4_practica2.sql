DROP DATABASE IF EXISTS adt4_practica2;
CREATE DATABASE adt4_practica2;
USE adt4_practica2;
CREATE TABLE usuario(
 id INT AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(50),
 password VARCHAR(50)
);
INSERT INTO usuario(nombre, password) VALUES ('pepe', '1234');
INSERT INTO usuario(nombre, password) VALUES ('juan', '4321');
INSERT INTO usuario(nombre, password) VALUES ('anna', '1111');
