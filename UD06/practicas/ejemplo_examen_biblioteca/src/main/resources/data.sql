-- Primero borramos las tablas hijas para evitar problemas de Foreign Key
DELETE FROM libro;
DELETE FROM idBiblioteca;

-- Reiniciamos los IDs autoincrementales a 1
ALTER TABLE libro AUTO_INCREMENT=1;
ALTER TABLE idBiblioteca AUTO_INCREMENT=1;

-- Insertamos las bibliotecas (Entidad Padre)
INSERT INTO idBiblioteca (nombre, ubicacion, ano_apertura, numero_libros_total) VALUES
                                                                                  ('Biblioteca Central de Madrid', 'Calle Mayor, 15', 1990, 50000),
                                                                                  ('Biblioteca Municipal de Barcelona', 'Paseo de Gracia, 42', 1985, 35000),
                                                                                  ('Biblioteca Regional de Valencia', 'Avenida de las Ciencias, 100', 2005, 25000),
                                                                                  ('Biblioteca Pública de Sevilla', 'Plaza Nueva, 8', 1995, 20000);

-- Insertamos los libros (Entidad Hija) asociados a sus bibliotecas
-- El biblioteca_id hace referencia a la Biblioteca insertada justo arriba (por su ID generado)
INSERT INTO libro (titulo, autor, isbn, ano_publicacion, estado, biblioteca_id) VALUES
                                                                                    ('Cien Años de Soledad', 'Gabriel García Márquez', '9780060850524', 1967, 'DISPONIBLE', 1),
                                                                                    ('El Quijote', 'Miguel de Cervantes', '9788467040654', 1605, 'PRESTADO', 1),
                                                                                    ('1984', 'George Orwell', '9780451524935', 1949, 'DISPONIBLE', 1),
                                                                                    ('El Origen de las Especies', 'Charles Darwin', '9780140430769', 1859, 'DAÑADO', 2),
                                                                                    ('Orgullo y Prejuicio', 'Jane Austen', '9780141439518', 1813, 'DISPONIBLE', 2),
                                                                                    ('Harry Potter y la Piedra Filosofal', 'J.K. Rowling', '9788498382761', 1997, 'PRESTADO', 2),
                                                                                    ('Don Juan Tenorio', 'José Zorrilla', '9788491051305', 1844, 'DISPONIBLE', 3),
                                                                                    ('La Casa de los Espíritus', 'Isabel Allende', '9788401337753', 1982, 'DISPONIBLE', 4),
                                                                                    ('Fundación', 'Isaac Asimov', '9780553293357', 1951, 'DESCATALOGADO', 4);