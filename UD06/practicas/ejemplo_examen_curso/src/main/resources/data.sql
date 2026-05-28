-- Primero borramos las tablas hijas para evitar problemas de Foreign Key
DELETE FROM estudiante;
DELETE FROM curso;

-- Reiniciamos los IDs autoincrementales a 1
ALTER TABLE estudiante AUTO_INCREMENT=1;
ALTER TABLE curso AUTO_INCREMENT=1;

-- Insertamos los cursos (Entidad Padre)
INSERT INTO curso (nombre, profesor_asignado, creditos) VALUES
                                                            ('Desarrollo Web Full-Stack', 'Juan Pérez García', 60),
                                                            ('Python para Data Science', 'María López Rodríguez', 45),
                                                            ('Diseño UX/UI Avanzado', 'Carlos Martín Sánchez', 30),
                                                            ('Ciberseguridad Aplicada', 'Elena Navarro Díaz', 50);

-- Insertamos los estudiantes (Entidad Hija) asociados a sus cursos
-- El curso_id hace referencia al Curso insertado justo arriba (por su ID generado)
INSERT INTO estudiante (nombre_completo, email, fecha_matriculacion, curso_id) VALUES
                                                                                   ('Laura González García', 'laura.gonzalez@example.com', '2025-01-15', 1),
                                                                                   ('Carlos Ruiz Martínez', 'carlos.ruiz@example.com', '2025-01-15', 1),
                                                                                   ('María López Fernández', 'maria.lopez@example.com', '2025-01-20', 1),
                                                                                   ('Javier Martín Álvarez', 'javier.martin@example.com', '2025-02-01', 2),
                                                                                   ('Ana Gómez García', 'ana.gomez@example.com', '2025-02-03', 2),
                                                                                   ('Pedro Sánchez Rodríguez', 'pedro.sanchez@example.com', '2025-01-25', 3),
                                                                                   ('Elena Navarro López', 'elena.navarro@example.com', '2025-02-10', 4),
                                                                                   ('Francisco Díaz Herrera', 'francisco.diaz@example.com', '2025-02-12', 4),
                                                                                   ('Isabel Romero García', 'isabel.romero@example.com', '2025-01-30', 2);