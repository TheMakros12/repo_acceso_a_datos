-- Primero borramos las tablas hijas para evitar problemas de Foreign Key
DELETE FROM libro;
DELETE FROM autor;

-- Reiniciamos los IDs autoincrementales a 1
ALTER TABLE libro AUTO_INCREMENT=1;
ALTER TABLE autor AUTO_INCREMENT=1;

-- Insertamos los autores (Entidad Padre)
INSERT INTO autor (nombre, nacionalidad) VALUES
                                              ('Stephen King', 'Estadounidense'),
                                              ('J.K. Rowling', 'Británica'),
                                              ('Isaac Asimov', 'Ruso-Estadounidense'),
                                              ('Yuval Noah Harari', 'Israelí');

-- Insertamos los libros (Entidad Hija) asociados a sus autores
-- El id_autor hace referencia al Autor insertado justo arriba (por su ID generado)
INSERT INTO libro (titulo, genero, anyo_publicacion, id_autor) VALUES
                                                                                     ('El Resplandor', 'TERROR', 1977, 1),
                                                                                     ('It', 'TERROR', 1986, 1),
                                                                                     ('Harry Potter y la Piedra Filosofal', 'FANTASIA', 1997, 2),
                                                                                     ('Yo, Robot', 'CIENCIA', 1950, 3),
                                                                                     ('Fundación', 'CIENCIA', 1951, 3),
                                                                                     ('Sapiens: De animales a dioses', 'NO_FICCION', 2011, 4),
                                                                                     ('Homo Deus', 'NO_FICCION', 2015, 4);
