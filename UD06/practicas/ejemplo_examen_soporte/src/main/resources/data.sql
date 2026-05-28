-- Primero borramos las tablas hijas para evitar problemas de Foreign Key
DELETE FROM ticket;
DELETE FROM proyecto;

-- Reiniciamos los IDs autoincrementales a 1
ALTER TABLE ticket AUTO_INCREMENT=1;
ALTER TABLE proyecto AUTO_INCREMENT=1;

-- Insertamos los proyectos (Entidad Padre)
INSERT INTO proyecto (nombre, descripcion, fecha_inicio, presupuesto) VALUES
                                                                          ('Cliente Tech Solutions', 'Desarrollo de plataforma web para Tech Solutions', '2024-01-15', 50000.00),
                                                                          ('Cliente Finanzas Global', 'Migración de sistemas legacy a cloud', '2024-02-01', 75000.00),
                                                                          ('Cliente Educatech', 'Implementación de LMS para institución educativa', '2024-03-10', 30000.00),
                                                                          ('Cliente Construcciones Avanzadas', 'Sistema de gestión de proyectos inmobiliarios', '2024-01-20', 40000.00);

-- Insertamos los tickets (Entidad Hija) asociados a sus proyectos
-- El proyecto_id hace referencia al Proyecto insertado justo arriba (por su ID generado)
INSERT INTO ticket (titulo, descripcion, prioridad, estado, fecha_creacion, proyecto_id) VALUES
                                                                                             ('Login no funciona en mobile', 'El formulario de login no responde en dispositivos móviles', 'ALTA', 'ABIERTO', '2025-01-10', 1),
                                                                                             ('Mejorar velocidad de carga', 'La página principal tarda demasiado en cargar', 'MEDIA', 'EN_PROGRESO', '2025-01-12', 1),
                                                                                             ('Diseño responsive en tablet', 'Ajustar diseño para tablets de 7 y 10 pulgadas', 'BAJA', 'CERRADO', '2025-01-05', 1),
                                                                                             ('Error en base de datos', 'Fallo de conexión a la base de datos en producción', 'ALTA', 'EN_PROGRESO', '2025-01-15', 2),
                                                                                             ('Documentar API REST', 'Crear documentación swagger de todos los endpoints', 'MEDIA', 'ABIERTO', '2025-01-14', 2),
                                                                                             ('Integración SSO con Azure AD', 'Implementar inicio de sesión con Azure Active Directory', 'ALTA', 'ABIERTO', '2025-01-16', 3),
                                                                                             ('Testing de módulo de reportes', 'Realizar pruebas exhaustivas del nuevo módulo de reportes', 'MEDIA', 'EN_PROGRESO', '2025-01-11', 4);