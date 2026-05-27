-- Primero borramos las tablas hijas para evitar problemas de Foreign Key
DELETE FROM jugador;
DELETE FROM equipo;

-- Reiniciamos los IDs autoincrementales a 1
ALTER TABLE jugador AUTO_INCREMENT=1;
ALTER TABLE equipo AUTO_INCREMENT=1;

-- Insertamos los equipos (Entidad Padre)
INSERT INTO equipo (nombre, ciudad) VALUES
                                        ('Real Madrid CF', 'Madrid'),
                                        ('FC Barcelona', 'Barcelona'),
                                        ('Atlético de Madrid', 'Madrid'),
                                        ('Valencia CF', 'Valencia');

-- Insertamos los jugadores (Entidad Hija) asociados a sus equipos
-- El id_equipo hace referencia al Equipo insertado justo arriba (por su ID generado)

-- Jugadores del Real Madrid (id_equipo = 1)
INSERT INTO jugador (nombre_completo, posicion, salario, id_equipo) VALUES
                                                                        ('Thibaut Courtois', 'PORTERO', 7000000.00, 1),
                                                                        ('Eder Militao', 'DEFENSA', 6000000.00, 1),
                                                                        ('Antonio Rüdiger', 'DEFENSA', 6500000.00, 1),
                                                                        ('Jude Bellingham', 'MEDIOCAMPISTA', 10000000.00, 1),
                                                                        ('Vinicius Junior', 'DELANTERO', 12000000.00, 1),
                                                                        ('Rodrygo Goes', 'DELANTERO', 8000000.00, 1);

-- Jugadores del FC Barcelona (id_equipo = 2)
INSERT INTO jugador (nombre_completo, posicion, salario, id_equipo) VALUES
                                                                        ('Marc-André ter Stegen', 'PORTERO', 6500000.00, 2),
                                                                        ('Ronald Araujo', 'DEFENSA', 5000000.00, 2),
                                                                        ('Jules Koundé', 'DEFENSA', 5500000.00, 2),
                                                                        ('Pedri González', 'MEDIOCAMPISTA', 7500000.00, 2),
                                                                        ('Gavi', 'MEDIOCAMPISTA', 6000000.00, 2),
                                                                        ('Robert Lewandowski', 'DELANTERO', 15000000.00, 2);

-- Jugadores del Atlético de Madrid (id_equipo = 3)
INSERT INTO jugador (nombre_completo, posicion, salario, id_equipo) VALUES
                                                                        ('Jan Oblak', 'PORTERO', 8000000.00, 3),
                                                                        ('Jose María Giménez', 'DEFENSA', 5500000.00, 3),
                                                                        ('Koke Resurrección', 'MEDIOCAMPISTA', 6500000.00, 3),
                                                                        ('Marcos Llorente', 'MEDIOCAMPISTA', 5000000.00, 3),
                                                                        ('Antoine Griezmann', 'DELANTERO', 11000000.00, 3),
                                                                        ('Álvaro Morata', 'DELANTERO', 7000000.00, 3);

-- Jugadores del Valencia CF (id_equipo = 4)
INSERT INTO jugador (nombre_completo, posicion, salario, id_equipo) VALUES
                                                                        ('Giorgi Mamardashvili', 'PORTERO', 3000000.00, 4),
                                                                        ('José Gayà', 'DEFENSA', 4500000.00, 4),
                                                                        ('Cristhian Mosquera', 'DEFENSA', 1500000.00, 4),
                                                                        ('Hugo Guillamón', 'MEDIOCAMPISTA', 2500000.00, 4),
                                                                        ('Javi Guerra', 'MEDIOCAMPISTA', 2000000.00, 4),
                                                                        ('Hugo Duro', 'DELANTERO', 3500000.00, 4);