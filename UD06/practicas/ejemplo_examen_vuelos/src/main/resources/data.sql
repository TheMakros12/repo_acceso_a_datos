-- Primero borramos las tablas hijas para evitar problemas de Foreign Key
DELETE FROM pasajero;
DELETE FROM vuelo;

-- Reiniciamos los IDs autoincrementales a 1
ALTER TABLE pasajero AUTO_INCREMENT=1;
ALTER TABLE vuelo AUTO_INCREMENT=1;

-- Insertamos los vuelos (Entidad Padre)
-- Nota: La fecha de BD sigue el formato estándar YYYY-MM-DD
INSERT INTO vuelo (codigo, fecha, estado) VALUES
                                              ('IB-1001', '2025-06-01', 'PROGRAMADO'),
                                              ('RY-2002', '2025-06-05', 'EN_CURSO'),
                                              ('AE-3003', '2025-06-10', 'COMPLETADO'),
                                              ('LX-4004', '2025-06-15', 'PROGRAMADO');

-- Insertamos los pasajeros (Entidad Hija) asociados a sus vuelos
-- El id_vuelo hace referencia al Vuelo insertado justo arriba (por su ID generado)
INSERT INTO pasajero (nombre_completo, numero_asiento, precio_billete, id_vuelo) VALUES
                                                                                     ('Laura González', '12A', 150.50, 1),
                                                                                     ('Carlos Ruiz', '12B', 150.50, 1),
                                                                                     ('María López', '14F', 180.00, 1),
                                                                                     ('Javier Martín', '05C', 45.99, 2),
                                                                                     ('Ana Gómez', '05D', 45.99, 2),
                                                                                     ('Pedro Sánchez', '01A', 350.00, 3),
                                                                                     ('Elena Navarro', '22B', 95.00, 4);